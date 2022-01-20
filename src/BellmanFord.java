import java.util.Arrays;

public class BellmanFord {


    public static void main(String[] args) {
        System.out.println(getShortestDistancePath(new int[][]{ {1,2,9}, {4,5,6},
                {5,3,7}, {3,2,3}, {2,5,-3},{1,4,2}, {4,2,-4}, {3,1,5}},1,5));

 //       System.out.println(getShortestDistancePath(new int[][]{ {0,1,5}, {0,2,10},
   //             {1,2,10}, {1,3,15}, {2,3,15},{2,4,20}, {3,4,20}, {3,5,25},
     //           {7,8,40},
       //         {4,5,25}, {4,6,30}, {5,6,30},{5,7,35}, {6,7,35}, {6,8,40},
       // },0,8));
    }

    static int getShortestDistancePath(int[][] ary,int k, int n){
        int[] distance = new int[n];
        Arrays.fill(distance, (Integer.MAX_VALUE));
        distance[k-1]=0;

        for(int i=0;i<=n-2;i++){
            int foundChanges=0;
           // int c=0;
            for (int[] a:
                 ary) {
                final int d = a[2];
                final int v = a[1];
                final int c = a[0];

                if(distance[c-1] != Integer.MAX_VALUE && distance[c-1]+d <distance[v-1]) {
                    distance[v - 1] = Math.min(distance[v - 1], distance[c-1] + d);
                    foundChanges++;
                }
             //   c++;
            }

            if(foundChanges==0)
                i=n;
        }

        int max = distance[0];
        for(int a=0;a<distance.length;a++){
            max= Math.max(max,distance[a]);
        }
        System.out.println(Arrays.toString(distance));

        return max==Integer.MAX_VALUE?-1:max;
    }
}
