/*
 * class for adjacency matrix
 * inherits from Graph
 */
public class AdjMatrix extends Graph {
    private int matrix[][];

    // constructor
    public AdjMatrix(int v){
        super(v);
        this.matrix = new int[v][v];
    }

    //methods
    @Override
    public void addEdge(int start, int end, int weight){
        matrix[start][end] = weight;
        this.incrementE();
        System.out.println("Edge between "+start+" and "+end+" with weight "+weight+" added");
    }

    @Override
    public void printGraph(){
        for(int i = 0; i < this.getV(); i++){
            if(i == 0){
                System.out.print("   ");
                for(int j = 0; j < this.getV(); j++){
                    // System.out.print((j+1)+"\t");
                    System.out.printf("%4s",(j+1));
                }
                printLine(this.getV()*5);
            }
            System.out.printf("%2s |", i+1);
            for(int j = 0; j < this.getV(); j++){
                // System.out.print(matrix[i][j]+"\t");
                System.out.printf("%4s", matrix[i][j]);
                
            }
            System.out.println("");
        }
    }

    // create random graph with e edges, weights 1 to 10
    public void randomGraph(int e){
        int start, end, weight;

        for(int i = 0; i < e; i++){
            start = (int) Math.floor(Math.random() * getV());
            end = (int) Math.floor(Math.random() * getV());

            if(start == end){ //make sure start doesnt == end
                end++;
                if(end > getV()-1){
                    end = 0;
                }
            }

            weight = (int) Math.floor(Math.random() * 10) + 1;
            addEdge(start, end, weight);
        }
    }

    private void printLine(int len){
        System.out.print("\n");
        for(int i = 0; i < len; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void dijkstra(){
        //idk
    }
}
