import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class KnightChessDownUp {

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
        Double[][] w1 = new Double[w][w];
      //  Arrays.fill(w1,0.0);
        for (Double[] doubles : w1) {
            Arrays.fill(doubles,0.0);
        }
        //Arrays.stream(w1).map(Arrays.fill(,0.0));
        w1[row][col] = 1.0;
        Double prob=0.0;
        Queue<int[]> positions = new LinkedList<>();
        positions.add(new int[]{row,col});

        int cnt=0;
        while(noOfTimes>0){
            Double[][] w2 = new Double[w][w];
            for (Double[] doubles : w2) {
                Arrays.fill(doubles,0.0);
            }
            Queue<int[]> positions2 = new LinkedList<>();

            if(w==0)
                return 1.0;
            while(!positions.isEmpty()) {
                int[] pinfo = positions.remove();
                //int prow
                for (int a = 0; a < directions.length; a++) {
                    final int rows = pinfo[0] + directions[a][0];
                    final int cols = pinfo[1] + directions[a][1];

                    if (isInRange(w, rows, cols)) {
                        w2[rows][cols]
                                += w1[pinfo[0]][pinfo[1]]/8.0;

                        if(noOfTimes==1)
                            prob+=w1[pinfo[0]][pinfo[1]]/8.0;
                    //    prob+=w2[rows][cols];
                      //  System.out.println(prob);
             //           System.out.println(w2[rows][cols]);
//                        System.out.println("rows "+rows+"cols "+cols);
//                        System.out.println("row "+pinfo[0]+"col "+pinfo[1]);
//                        System.out.println("row "+directions[a][0]+"col "+directions[a][1]);
//                        System.out.println("=======================");
//                        System.out.println("           ");
             //           System.out.println("cols "+cols);
                        positions2.add(new int[]{rows,cols});
                    }
                }
            }
         //   if(cnt>0)
           //     prob=prob/8.0;


//            int j=0;
//            for (Double[] position : w2) {
//                int c=0;
//                System.out.println(Arrays.toString(w2[j]));
//                for (Double i : position) {
//                    prob+=i;
//                    c++;
//                }
//                j++;
//            }
            cnt++;

            System.out.println("    ");
            positions=positions2;
            w1=w2;
            noOfTimes--;
        }


//        int j=0;
//        for (Double[] position : w1) {
//            int c=0;
//        //    System.out.println(Arrays.toString(w1[j]));
//            for (Double i : position) {
//                prob+=w1[j][c];
//                c++;
//            }
//            j++;
//        }
        return prob;//0.0;//prob(w,row,col,noOfTimes);
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
   //     System.out.println(hsd.entrySet().size());
     //   System.out.println(hsd.entrySet().toString());
    }
}
