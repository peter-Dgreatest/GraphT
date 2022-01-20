import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAL {

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

        System.out.println(Arrays.toString(bfs(graph,0)));
    }

    private static int[] bfs(int[][] graph, int pos) {
        Queue<Integer> qq
= new LinkedList<>();

        qq.add(pos);

        int[] aray =new int[]{};
        HashMap<Integer,Integer> araay = new HashMap<>();

        while (!qq.isEmpty()){
            pos = qq.remove();
            for (int a:
                    graph[pos]) {

                if(araay.containsKey(pos))
                    continue;
                qq.add(a);
            }
            if(araay.containsKey(pos))
                continue;
            araay.put(pos,pos);
            aray=Arrays.copyOf(aray,aray.length+1);
            aray[aray.length-1]=pos;
        }
        return aray;
    }
}
