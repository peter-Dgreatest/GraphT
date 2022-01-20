import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMovement {
    static HashMap<String,Double> hsd;

    static int cnt=0;
    static int[][] directions = new int[][]{
            {1,2},
            {1,-2},
            {-1,2},
            {-1,-2},
            {2,1},
            {2,-1},
            {-2,1},
            {-2,-1}
    };

    static boolean isInRange(int l,int row,int col){
        if(row<0 || col <0|| row>=l || col >=l)
            return false;

        return true;
    }

    static Double getProb(int w,int row,int col,int noOfTimes){
        hsd= new HashMap<>();
        return prob(w,row,col,noOfTimes);
    }

    private static Double prob(int w, int row, int col, int k) {
        if(k==0)
            return 1.0;
        Queue<int[]> q = new LinkedList<>();
        if(hsd.containsKey(row+":"+col))
            return hsd.get(row+":"+col);

        for(int a =0;a<directions.length;a++){
            final int rows = row+directions[a][0];
            final int cols = col+directions[a][1];

            if(isInRange(w,rows,cols)) {
                q.add(new int[]{rows, cols});
            }
        }

        Double probs = 0.0;

        if(hsd.containsKey(row+":"+col+":"+k)){
      //      cnt++;
        //    System.out.println("cnt : "+cnt);
            return hsd.get(row+":"+col+":"+k);
        }

        Double pp =0.0;
        while(!q.isEmpty()){
            int[] j = q.remove();
            pp+= prob(w,j[0],j[1],k-1)/8.0;
            hsd.put(row+":"+col+":"+k,pp);
        }
      //  System.out.println(probs);
        return (pp);
    }

    public static void main(String[] args) {
        System.out.println(getProb(6,2,2,2));
//        for (String a: hsd.entrySet().toString()){
//            System.out.println(a);
//        }
        System.out.println(hsd.entrySet().size());
        System.out.println(hsd.entrySet().toString());
    }
}
