import java.lang.reflect.Array;
import java.util.*;

public class TimeToInformAllEmployees {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graphIds = new ArrayList();
        HashMap<Integer,ArrayList> hsd = new HashMap<>();

        for(int i=0;i<manager.length;i++){
            if(manager[i]==-1)
                continue;
            if(!hsd.containsKey(manager[i])) {
                ArrayList<Integer> ar =new ArrayList();
                ar.add(i);
                hsd.put(manager[i], ar);
            }else{
                ArrayList<Integer> ar =hsd.get(manager[i]);
                ar.add(i);
                hsd.replace(manager[i],ar);
            }
        }

        Queue<Integer> qq = new LinkedList<>();


//        qq.add(4);
//        while (!qq.isEmpty()){
//            int a= qq.remove();
//            ArrayList<Integer> art = hsd.get(a);
//            for (int s:
//                 art) {
//                qq.add(s);
//            }
//        }

        System.out.println(timeTorechEnd(hsd,4,informTime));

   //     for (ArrayList a:
     //           hsd.values()) {
       //     System.out.println(Arrays.toString(a.toArray(new Integer[0])));
        //}

        return 0;

    }

    static int timeTorechEnd(HashMap<Integer,ArrayList> hh,int id,int[] timeAry) {
        if (!hh.containsKey(id))
            return timeAry[id];
        if (hh.get(id).size() == 0)
            return timeAry[id];

        int maxTime = 0;
        ArrayList<Integer> art = hh.get(id);
        for (int s :
                art) {
            maxTime = Math.max(timeTorechEnd(hh, s,timeAry), maxTime);
        }

        return timeAry[id]+maxTime;
    }

    public static void main(String[] args) {
        numOfMinutes(0,0,new int[]{2,2,4,6,-1,4,4,5},new int[]{0,0,4,0,7,3,6,0});
    }
}
