/**
 * AdjList
public class AdjList extends Graph{

    public AdjList(int v){
        super(v);
        //add more stuff
    }
}
*/
import java.util.*;
 
public class AdjList {
 
    // Function to convert adjacency
    // list to adjacency matrix
    static ArrayList<ArrayList<Integer>> convert(int[][] a)
    {
        // no of vertices
        int l = a[0].length;
        ArrayList<ArrayList<Integer>> adjListArray 
        = new ArrayList<ArrayList<Integer>>(l);
 
        // Create a new list for each
        // vertex such that adjacent
        // nodes can be stored
        for (int i = 0; i < l; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
         
        int i, j;
        for (i = 0; i < a[0].length; i++) {
            for (j = 0; j < a.length; j++) {
                if (a[i][j] != 0) {
                    adjListArray.get(i).add(j);
                }
            }
        }
         
        return adjListArray;
    }
     
    // Function to print the adjacency list
    static void printArrayList(ArrayList<ArrayList<Integer>> 
                                                adjListArray)
    {
        // Print the adjacency list
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }

public class DijkstraMinHeap {
	public static void dijkstra(int V, ArrayList<ArrayList<Node>> graph, int source) {
		int[] dist = new int[V];

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[source] = 0;

		PriorityQueue<Node> minHeap = new PriorityQueue<>((v1, v2) -> v1.getCost() - v2.getCost());
		minHeap.add(new Node(source, 0));

		while (minHeap.size() > 0) {
			Node current = minHeap.poll();

			for (Node node : graph.get(current.getVertex())) {
				if (dist[current.getVertex()] + node.getCost() < dist[node.getVertex()]) {
					dist[node.getVertex()] = dist[current.getVertex()] + node.getCost();
					minHeap.add(new Node(node.getVertex(), dist[node.getVertex()]));
				}
			}
		}

		for (int j = 0; j < V; j++)
			System.out.println("Vertex: " + j + " Minimum Distance from Source: " + dist[j]);

	}
