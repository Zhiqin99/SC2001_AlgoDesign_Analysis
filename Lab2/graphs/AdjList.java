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
