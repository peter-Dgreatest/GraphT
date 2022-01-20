import java.util.*;

public class Dijksral {

    public static void main(String[] args) {
        Comparator<Integer> cm= (o1, o2) -> (o1>o2) ? 1 :-1;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(cm);

        pq.add(80);
        System.out.println(pq.toString());
        pq.add(90);
        System.out.println(pq.toString());



        pq.poll();
        System.out.println(pq.toString());


        pq.add(10);
     //   System.out.println(findTimeTotransverseNodes(new int[][]{{1,4,2},{4,5,6},
       //         {5,3,7},{3,2,900},{2,5,1},{1,2,190},{4,2,900},{3,1,-5}},5,1));


        System.out.println(findTimeTotransverseNodes(new int[][]{ {1,2,9}, {4,5,6},
                 {5,3,7}, {3,2,3}, {2,5,-3},{1,4,2}, {4,2,-4}, {3,1,5}},5,1));
    }

    static int findTimeTotransverseNodes(int[][] times,int n, int k){
        int[] distance = new int[n];
        Arrays.fill(distance, (int) Double.POSITIVE_INFINITY);
        int[][] adjList = new int[n-1][];
        HashMap<Integer,Boolean> finishedTrans = new HashMap<>();
        HashMap<Integer,int[][]> added = new HashMap<>();

        for (int[] a:
             times) {
            final int d = a[2];
            final int v = a[1];
            final int start = a[0];

            if(added.containsKey(start-1)){
                int[][] dT = added.get(start-1);
                dT=Arrays.copyOf(dT,dT.length+1);
                dT[dT.length-1] = new int[]{d,v};
                added.replace(start-1,dT);
            }else{
                int[][] dT = new int[][]{{d,v}};
                added.put(start-1,dT);
            }
        }

        PriorityQueue<Integer> pq= new PriorityQueue<>((o1, o2) -> (o1>o2)? 1:-1);
        pq.add(k-1);
        distance[k-1]=0;

        while (!pq.isEmpty()){
            int q= pq.poll();
            if(finishedTrans.containsKey(q)) continue;
            finishedTrans.put(q,true);
            if(added.containsKey(q))
            for (int[] a:
                 added.get(q)) {
                final int v = a[1];
                final int d = a[0];
                if(distance[q]+d<distance[v-1]){
                    distance[v-1]= distance[q]+d; // their algorith including removing the finishedTrans operation
                    pq.add(v-1);
                }
 //               distance[v-1] = Math.min(distance[v-1],d+distance[q]); // mine implementation

      //          if(finishedTrans.containsKey(v-1)) continue;
        //        pq.add(v-1);              // mine implementation
            }
           // finishedTrans.put(q,true);
        }

        int max = 0;
        for (int a:
             distance) {
            max=Math.max(a,max);

        }
        return (max==Double.POSITIVE_INFINITY)?-1:max;

    }


}
