import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrereCOurseDetectCycle {

    public static void main(String[] args) {
        System.out.println(canFinishCourses(6,new int[][]{{1,0},{2,1},{2,5},{0,3},{4,3},{3,5},{4,5}}));
    }

    static boolean canFinishCourses(int n,int[][] prerequisites){
        HashMap<Integer,int[]> hsd = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
           // if(manager[i]==-1)
             //   continue;
            if(!hsd.containsKey(prerequisites[i][1])) {
                int[] ar =new int[]{};
                ar = Arrays.copyOf(ar,ar.length+1);
                ar[ar.length-1]=(prerequisites[i][0]);
                hsd.put(prerequisites[i][1], ar);
            }else{
                int[] ar =hsd.get(prerequisites[i][1]);
                ar = Arrays.copyOf(ar,ar.length+1);
                ar[ar.length-1]=(prerequisites[i][0]);
            //    ar.add(prerequisites[i][0]);
                hsd.replace(prerequisites[i][1],ar);
            }
        }

        int[] aa = new int[n];
        for(int a=0;a<n;a++) {
            aa[a] = a;
            if(hsd.containsKey(a)){
               return detectCycle(hsd.get(a),new HashMap<Integer,Boolean>(),hsd,a);
           //    if(!f)
             //      return f;
            }
        }

        return true;
    }

    static boolean detectCycle(int[] ary, HashMap<Integer,Boolean> found,HashMap<Integer,int[]> hsd,int pos){
        if(found.containsKey(pos))
            return false;
        found.put(pos,true);


        for (Integer a:
                ary) {

            if(hsd.containsKey(a))
            return detectCycle(hsd.get(a),found,hsd,a);
        }

        return true;
    }


}
