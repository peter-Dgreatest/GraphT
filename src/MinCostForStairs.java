import java.util.HashMap;

public class MinCostForStairs {

    public static void main(String[] args) {
               System.out.println(minCostInClimb(new int[]{5,10,15,20,25,30,35,40}));
    }

    static int minCostInClimb(int[] ary){
        final int p = ary.length;
        HashMap<Integer,Integer> arts = new HashMap<>();


        return Math.min(getMinCostT2B(p-1,ary,arts),getMinCostT2B(p-2,ary,arts));
       // return Math.min(getMinCostBT(ary,0,arts),getMinCostBT(ary,1,arts));
    }

    static int getMinCostT2B(int p,int[] ary,HashMap<Integer,Integer> arts){
        if(p<0)
            return 0;
        int cost = ary[p];
        if(p==0 || p-1 ==0) {
            arts.put(p,cost+Math.min(ary[p],getMinCostT2B(p-1,ary,arts)));
            return arts.get(p);
        }
     //   if(p-1==0)
       //     return ary[p];
      //  if(p-2==0)
        //    return cost+Math.min(ary[p-1],ary[p-2]);
        if(arts.containsKey(p))
            return arts.get(p);

        arts.put(p,cost+Math.min(getMinCostT2B(p-1,ary,arts),
                getMinCostT2B(p-2,ary,arts)));

        return arts.get(p);
    }


    static int getMinCostBT(int[] ary,int pos, HashMap<Integer,Integer> fds){
        if(pos> ary.length)
            return 0;
        if(pos== ary.length-1)
            return ary[pos];
        if(pos== ary.length-2)
            return Math.min(ary[pos],ary[pos-1]);

        int[] preAry = new int[]{ary[0],ary[1]};
      //  fds.put(0,ary[0]);
        //fds.put(1,ary[1]);

        int i=2;
//        int minCost= Math.min(fds.get(0),fds.get(1));
        int minCost=0; //Math.min(preAry[0],preAry[1]);
        while (i< ary.length){
            minCost = ary[i]+Math.min(preAry[0],preAry[1]);
            preAry[0]=preAry[1];
            preAry[1] = minCost;//(i== ary.length-1)?0:ary[i];
            i++;
        }
//
//        if(fds.containsKey(pos))
//            return fds.get(pos);
//
//        fds.put(pos,ary[pos]+Math.min(getMinCostBT(ary,pos+1,fds),getMinCostBT(ary,pos+2,fds)));
//
//        return fds.get(pos);

      //  return minCost;
        return Math.min(preAry[0],preAry[1]);
    }
}
