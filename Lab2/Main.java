
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        //loop until 300 in intervals of 10
        int max = 300;
        int interval = 10;

        // trivial case to remove JIT overhead
        ArrayList<ArrayList<Node>> a = AdjList.convert(new int[1][1]);
        DijkstraMinHeap.dijkstra(a, 0);
        AdjMatrix aa = new AdjMatrix(2);
        aa.randomGraph(1);
        
        //test sparse graph
        System.out.println("\n-----Sparse-------------------");
        Test(max, interval, 5);

        //test medium graph
        System.out.println("\n-----Medium-------------------");
        Test(max, interval, 3);

        //test full graph
        System.out.println("\n-----Full---------------------");
        Test(max, interval, 2);

    }

    // 
    public static void Test(int max, int interval, int E){
        int repeat = 1000; //loop each case 1k times, PLS change if it takes too long

        for(int i = 10; i <= max; i+=interval){
            float timeL = 0, timeM = 0;
            AdjMatrix graph = new AdjMatrix(i);

            //repeat the same size
            for(int b = 0; b < repeat; b++){         
                //init graphs
                graph.randomGraph((int)Math.floor(i*(i/E)));
                ArrayList<ArrayList<Node>> adjList = AdjList.convert(graph.getMatirx());

                // matrix
                long startTimeAdjMatrix = System.nanoTime();
                int[] distMatrix = graph.adjMatDijkstra(graph.getMatirx(), 0);
                long endTimeAdjMatrix = System.nanoTime();
                timeM += (endTimeAdjMatrix - startTimeAdjMatrix) / 1000;

                // list
                long startTimeAdjList = System.nanoTime();
                int[] distList = DijkstraMinHeap.dijkstra(adjList, 0);
                long endTimeAdjList = System.nanoTime();
                timeL += (endTimeAdjList - startTimeAdjList) / 1000;
            }

            //get outputs here
            System.out.println("size:"+ graph.getV() +"\tE:"+ graph.getE() +"\tmatrix:"+(timeM/repeat)+"\tlist:"+(timeL/repeat));
        }
    }
}
