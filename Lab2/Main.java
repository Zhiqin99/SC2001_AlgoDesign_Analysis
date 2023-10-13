
import java.util.*;
public class Main {
        public static void main(String[] args) {
        List<AdjMatrix> graphs = new ArrayList<>();
        List<ArrayList<ArrayList<Node>>> adjLists = new ArrayList<>();
    
        for (int i = 5; i <= 1000; i += 5) {
          int vertices = i;
          int edges = i * 2;
    
          // Create an adjacency matrix for the graph.
          AdjMatrix graph = new AdjMatrix(vertices);
          graph.randomGraph(edges);
    
          // Convert the adjacency matrix to an adjacency list.
          ArrayList<ArrayList<Node>> adjList = AdjList.convert(graph.getMatirx());
    
          // Add the adjacency matrix and adjacency list to the corresponding lists.
          graphs.add(graph);
          adjLists.add(adjList);
        }
    
        // Find the time to excute Dijkstra's algorithm.
        long[] timesAdjMatrix = new long[graphs.size()];
        long[] timesAdjList = new long[graphs.size()];
    
        for (int i = 0; i < graphs.size(); i++) {
            long startTimeAdjMatrix = System.nanoTime();
            int[] distancesAdjMatrix = graphs.get(i).adjMatDijkstra(graphs.get(i).getMatirx(), 0);
            long endTimeAdjMatrix = System.nanoTime();
            timesAdjMatrix[i] = (endTimeAdjMatrix - startTimeAdjMatrix)/1000;
    
            long startTimeAdjList = System.nanoTime();
            int[] distancesAdjList = DijkstraMinHeap.dijkstra(adjLists.get(i), 0);
            long endTimeAdjList = System.nanoTime();
            timesAdjList[i] = (endTimeAdjList - startTimeAdjList)/1000;
        }
    
        // Print the time taken for each algorithm function on each graph.
        System.out.println("Vertices\tEdges\tTime AdjMatrix (μs)\tTime AdjList (μs)");
        for (int i = 0; i < graphs.size(); i++) {
            System.out.println(graphs.get(i).getV() + "\t\t" + graphs.get(i).getE() + "\t\t" + timesAdjMatrix[i] + "\t\t" + timesAdjList[i]);
        }
    }
}
