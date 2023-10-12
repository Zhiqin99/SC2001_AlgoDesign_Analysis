
public class Main {
    public static void main(String[] args) {

       

        //adjmatrix test
        AdjMatrix matrix = new AdjMatrix(10);
        matrix.randomGraph(50);
        matrix.printGraph();

        AdjList list = new AdjList(10);
        ArrayList<ArrayList<Integer>> l = AdjList.convert(matrix.getMatirx());

        AdjList.printArrayList(l);
        
        
       
    }
}
