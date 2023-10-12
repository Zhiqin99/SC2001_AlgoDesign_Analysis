import java.util.*;
 
public class AdjList {

  // Function to convert adjacency
  // list to adjacency matrix
  static ArrayList<ArrayList<Node>> convert(int[][] a) {
    // no of vertices
    int l = a[0].length;
    ArrayList<ArrayList<Node>> adjListArray = new ArrayList<ArrayList<Node>>(l);

    // Create a new list for each
    // vertex such that adjacent
    // nodes can be stored
    int i, j;
    for (i = 0; i < l; i++) {
      adjListArray.add(new ArrayList<Node>());
    }

    for (i = 0; i < a[0].length; i++) {
      for (j = 0; j < a.length; j++) {
        if (a[i][j] != 0) {
          adjListArray.get(i).add(new Node(j, a[i][j]));
        }
      }
    }

    return adjListArray;
  }

  // Function to print the adjacency list
  static void printArrayList(ArrayList<ArrayList<Node>> adjListArray) {
    // Print the adjacency list
    for (int v = 0; v < adjListArray.size(); v++) {
      System.out.print(v);
      for (Node u : adjListArray.get(v)) {
        System.out.print(" -> " + u.getVertex() + "(" + u.getCost() + ")");
      }
      System.out.println();
    }
  }
}
