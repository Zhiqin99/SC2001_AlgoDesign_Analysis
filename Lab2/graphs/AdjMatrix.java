/*
 * class for adjacency matrix
 * inherits from Graph
 */
public class AdjMatrix extends Graph {
    private int matrix[][];

    // constructor
    public AdjMatrix(int v) {
        super(v);
        this.matrix = new int[v][v];
    }

    // methods
    @Override
    public void addEdge(int start, int end, int weight) {
        matrix[start][end] = weight;
        matrix[end][start] = weight;
        this.incrementE();
        // System.out.println("Edge between " + start + " and " + end + " with weight " + weight + " added");
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < this.getV(); i++) {
            if (i == 0) {
                System.out.print("   ");
                for (int j = 0; j < this.getV(); j++) {
                    // System.out.print((j+1)+"\t");
                    System.out.printf("%4s", (j + 1));
                }
                printLine(this.getV() * 5);
            }
            System.out.printf("%2s |", i + 1);
            for (int j = 0; j < this.getV(); j++) {
                // System.out.print(matrix[i][j]+"\t");
                System.out.printf("%4s", matrix[i][j]);

            }
            System.out.println("");
        }
    }

    // create random graph with e edges, weights 1 to 10
    public void randomGraph(int e) {
        this.matrix = new int[V][V]; //reset graph
        this.E = 0;

        int start, end, weight;

        for (int i = 0; i < e; i++) {
            start = (int) Math.floor(Math.random() * getV());
            end = (int) Math.floor(Math.random() * getV());

            if (start == end) { // make sure start doesnt == end
                i--;
                continue;
            }

            if(matrix[start][end] == 0){
                weight = (int) Math.floor(Math.random() * 10) + 1;
                addEdge(start, end, weight);
            }
            else{
                i--;
            }

            if(E >= (V*(V-1)/2)){
                break;
            }
        }
    }

    private void printLine(int len) {
        System.out.print("\n");
        for (int i = 0; i < len; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public int[] adjMatDijkstra(int[][] matrix, int source) {
        boolean visited[] = new boolean[super.getV()];
        int dist[] = new int[super.getV()];

        for (int i = 0; i < super.getV(); i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        for (int i = 0; i < super.getV(); i++) {
            int min = nextMin(dist, visited);
            if (min == -1) {
                return dist;
            }

            visited[min] = true;

            for (int j = 0; j < super.getV(); j++) {
                if (matrix[min][j] > 0 && dist[j] > matrix[min][j] + dist[min]) {
                    dist[j] = matrix[min][j] + dist[min];
                }
            }
        }

        return dist;
    }

    // helper function to get next min
    private int nextMin(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < super.getV(); i++) {
            if (visited[i] == false && distance[i] < min) {
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public int[][] getMatirx() {
        return matrix;
    }

}
