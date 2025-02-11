package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  public static class AdjacencyList {

    private final List<List<Integer>> adj = new ArrayList<>();

    public AdjacencyList(int n) {
      for (int i = 0; i <= n; i++) {
        adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    public void printGraph() {
      for (int i = 0; i < adj.size(); i++) {
        for (int edge : adj.get(i)) {
          System.out.print("[" + i + " -> " + edge + "] ");
        }
        System.out.println();
      }
    }

    public List<List<Integer>> getAdjList() {
      return adj;
    }
  }
}
