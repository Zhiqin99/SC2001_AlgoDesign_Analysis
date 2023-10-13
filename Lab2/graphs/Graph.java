/*
 * parent class for adj matrix and list versions
 * 
 */

public class Graph {
    int V; // vertices
    int E; // edges
    
    // Constructor
    public Graph(int v){
        this.V = v;
        this.E = 0;
    }

    // Methods
    public void addEdge(int start, int end, int weight){}
    public void printGraph(){}


    //Getter & Setter
    public int getE() {
        return E;
    }
    public void setE(int e) {
        E = e;
    }
    public void incrementE(){
        E++;
    }

    public int getV() {
        return V;
    }
    public void setV(int v) {
        V = v;
    }
}