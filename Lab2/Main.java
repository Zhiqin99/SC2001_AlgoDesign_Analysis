
public class Main {
    public static void main(String[] args) {

        // heapsort test
        // int[] arr = {3, 2, 5, 6, 2, 6, 1, 8, 5};
        // MinHeap.heapSort(arr);

        // for(int i = 0; i < arr.length; i++){
        //     System.out.print(arr[i]);
        // }

        // adjmatrix test
        // AdjMatrix matrix = new AdjMatrix(10);
        // matrix.randomGraph(50);
        // matrix.printGraph();

        //generate the same graph twice test
        int start, end, weight;
        int size = 10;
        int edges = 20;
        AdjMatrix m = new AdjMatrix(size);
        AdjList l = new AdjList(size);
        for(int i = 0; i < edges; i++){
            start = (int) Math.floor(Math.random() * size);
            end = (int) Math.floor(Math.random() * size);

            if(start == end){ //make sure start != end
                end++;
                if(end > size-1){
                    end = 0;
                }
            }

            weight = (int) Math.floor(Math.random() * 10) + 1;
            m.addEdge(start, end, weight);
            l.addEdge(start, end, weight);
        }
        m.printGraph();
        l.printGraph(); // need to implement
    }
}
