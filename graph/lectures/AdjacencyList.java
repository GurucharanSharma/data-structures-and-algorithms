package graph.lectures;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

  public static void main(String[] args) {
    int n = 5;

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    addEdge(1, 2, adj);
    addEdge(1, 3, adj);
    addEdge(2, 4, adj);
    addEdge(3, 4, adj);
    addEdge(2, 5, adj);
    addEdge(4, 5, adj);

    printGraph(adj);
  }

  private static void addEdge(int u, int v, List<List<Integer>> adj) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  private static void printGraph(List<List<Integer>> adj) {
    for (int i = 0; i < adj.size(); i++) {
      for (int edge: adj.get(i)) {
        System.out.print("[" + i + " -> " + edge + "] ");
      }
      System.out.println();
    }
  }
}
