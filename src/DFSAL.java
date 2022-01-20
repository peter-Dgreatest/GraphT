import java.util.Arrays;
import java.util.HashMap;

public class DFSAL {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,3},{0},{3,8},{0,4,5,2},{3,6},{3},{4,7},{6},{2}};

        HashMap<Integer,int[]> graph1= new HashMap<>();
        graph1.put(0,new int[]{1,3});
        graph1.put(1,new int[]{});
        graph1.put(3,new int[]{4,5,2});
        graph1.put(4,new int[]{6});
        graph1.put(5,new int[]{});
        graph1.put(2,new int[]{3,8});
        graph1.put(6,new int[]{7});
        graph1.put(8,new int[]{});
        graph1.put(7,new int[]{});

        System.out.println(Arrays.toString(info(graph)));
    }

    static int[] info(int[][] graph){
        if(graph.length==0)
            return new int[]{};
        int[] ary = new int[]{0};
        HashMap<Integer,Boolean> hsh = new HashMap<Integer,Boolean>();
        hsh.put(0,true);
      //  return dfs(graph,0,hsh);
        return dfs2(graph,0,new int[]{},hsh);
    }

    static int[] ar = new int[]{};

    private static int[] dfs(int[][] graph, int i, HashMap<Integer, Boolean> integerBooleanHashMap) {

        if(i==0) {
            ar = new int[1];
            ar[0] = 0;
        }
      // if(!integerBooleanHashMap.containsKey(i)) {

       //}

        for (int a:
             graph[i]) {
            if(integerBooleanHashMap.containsKey(a))
                continue;
                integerBooleanHashMap.put(a,true);
            ar = Arrays.copyOf(ar, ar.length + 1);
            ar[ar.length - 1] = a;
            dfs(graph, a,integerBooleanHashMap);
        }

        return ar;
    }


    private static int[] dfs2(int[][] graph, int i,int[] values, HashMap<Integer, Boolean> integerBooleanHashMap) {

      //  if(i==0) {
        //    values = new int[0];
     //       values[0] = 0;
       // }
        // if(!integerBooleanHashMap.containsKey(i)) {

        //}
        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = i;
        integerBooleanHashMap.put(i,true);

        for (int a:
                graph[i]) {
            if(!integerBooleanHashMap.containsKey(a)) //continue;
            dfs2(graph, a,values,integerBooleanHashMap);
        }

        return values;
    }

}
