package graph.lectures;

public class AdjacencyMatrix {

  public static void main(String[] args) {
    int n = 5;
    int[][] adj = new int[n + 1][n + 1];

    addEdge(1, 2, adj);
    addEdge(1, 3, adj);
    addEdge(2, 4, adj);
    addEdge(3, 4, adj);
    addEdge(2, 5, adj);
    addEdge(4, 5, adj);

    printGraph(adj);
  }

  private static void addEdge(int u, int v, int[][] adj) {
    adj[u][v] = 1;
    adj[v][u] = 1;
  }

  private static void printGraph(int[][] adj) {
    for (int i = 0; i < adj.length; i++) {
      for (int j = 0; j < adj[0].length; j++) {
        if (adj[i][j] == 1) {
          System.out.print("[" + i + " -> " + j + "] ");
        }
      }
      System.out.println();
    }
  }
}
