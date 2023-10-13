import java.util.*;

public class DijkstraMinHeap {
    private static final int INF = Integer.MAX_VALUE;

    public static int[] dijkstra(ArrayList<ArrayList<Node>> adjList, int source) {
        // Create a priority queue to store the unvisited vertices.
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.getCost() - node2.getCost());

        // Add the source vertex to the priority queue with a distance of 0.
        pq.add(new Node(source, 0));

        // Create an array to store the shortest distances to all vertices.
        int[] distances = new int[adjList.size()];
        Arrays.fill(distances, INF);

        // Initialize the distance to the source vertex as 0.
        distances[source] = 0;

        while (!pq.isEmpty()) {
            // Get the vertex with the shortest distance from the priority queue.
            Node currentNode = pq.poll();

            // For each adjacent vertex of the current vertex:
            for (Node adjacentNode : adjList.get(currentNode.getVertex())) {
                // If the distance to the adjacent vertex is greater than the distance to the
                // current vertex plus the weight of the edge between them:
                if (distances[adjacentNode.getVertex()] > distances[currentNode.getVertex()] + adjacentNode.getCost()) {
                    // Update the distance to the adjacent vertex.
                    distances[adjacentNode.getVertex()] = distances[currentNode.getVertex()] + adjacentNode.getCost();

                    // Add the adjacent vertex to the priority queue.
                    pq.add(adjacentNode);
                }
            }
        }

        return distances;
    }
}