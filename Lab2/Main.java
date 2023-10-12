
import java.util.*;
public class Main {
    public static void main(String[] args) {

       

        //adjmatrix test
        AdjMatrix matrix = new AdjMatrix(4);
        matrix.randomGraph(4);
        matrix.printGraph();

        
        ArrayList<ArrayList<Node>> l = AdjList.convert(matrix.getMatirx());
        AdjList.printArrayList(l);
        DijkstraMinHeap.dijkstra(l, 0);
        matrix.adjMatDijkstra(matrix.getMatirx(), 0);
        
        
       
    }
}
