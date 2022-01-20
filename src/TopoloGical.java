import java.util.*;

public class TopoloGical {


    static int[] getinDegree(int[][] ary,int n){

        int[] inDegrees= new int[n];
        Arrays.fill(inDegrees,0);

        int c=0;
        HashMap<Integer,int[]> hsd = new HashMap<>();

        for (int[] a:
             ary) {
            inDegrees[a[0]]+=1;
            if(hsd.containsKey(ary[1])){
                int[] t = hsd.get(a[1]);
                t = Arrays.copyOf(t,t.length+1);
                t[t.length-1]=a[0];
            }else{
                int[] t = new int[1];
             //   t = Arrays.copyOf(t,t.length+1);
                t[0]=a[0];
            }
            c++;
        }


        return inDegrees;
    }


    public static void main(String[] args) {
        System.out.println(canFinishCourses(6,new int[][]{{1,0},{2,1},{2,5},{0,3},{4,3},{3,5},{4,5}}));
    }

    static boolean canFinishCourses(int n,int[][] ary){
        HashMap<Integer,int[]> hsd = new HashMap<>();


        int[] inDegrees= new int[n];
        Arrays.fill(inDegrees,0);

        int c=0;
        for (int[] a:
                ary) {
            inDegrees[a[0]]+=1;
            if(hsd.containsKey(a[1])){
                int[] t = hsd.get(a[1]);
                t = Arrays.copyOf(t,t.length+1);
                t[t.length-1]=a[0];
                hsd.replace(a[1],t);
            }else{
                int[] t = new int[1];
                //   t = Arrays.copyOf(t,t.length+1);
                t[0]=a[0];
                hsd.put(a[1],t);
            }
            c++;
        }
       return detectcycle(ary,n,inDegrees,hsd);

        //return true;
    }

    static boolean detectcycle(int[][] prep, int n, int[] inDegree, HashMap<Integer, int[]> hsd){
     //   if(topSort.length==0){
            ;
       // }
        int c=0;
        Queue<Integer> df = new LinkedList<>();
        for (int a:
                inDegree) {
            if(a==0)
                df.add(c);
                c++;
        }
        int _0indegreeCnt=0;

        while (!df.isEmpty()){
            _0indegreeCnt++;
            int nm = df.remove();
            if(!hsd.containsKey(nm))
                continue;
            for(int a:
                hsd.get(nm)){
                inDegree[a]-=1;
                if(inDegree[a]==0)
                    df.add(a);
            }
        }

        return _0indegreeCnt==n;
    }

}
