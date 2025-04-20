package graph.common;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  /**
   * Adjacency List
   */
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
      System.out.println("Adjacency List Representation:");
      for (int i = 1; i < adj.size(); i++) {
        System.out.print(i + " => ");
        List<Integer> neighbors = adj.get(i);
        for (int j = 0; j < neighbors.size(); j++) {
          System.out.print(neighbors.get(j));
          if (j < neighbors.size() - 1) {
            System.out.print(" -> ");
          }
        }
        System.out.println();
      }
    }

    public List<List<Integer>> getAdjList() {
      return adj;
    }
  }

  /**
   * Adjacency Matrix
   */
  public static class AdjacencyMatrix {

    private final int[][] adj;

    public AdjacencyMatrix(int n) {
      this.adj = new int[n + 1][n + 1];
    }

    public void addEdge(int u, int v) {
      adj[u][v] = 1;
      adj[v][u] = 1;
    }

    public void printGraph() {
      for (int i = 0; i < adj.length; i++) {
        for (int j = 0; j < adj[0].length; j++) {
          if (adj[i][j] == 1) {
            System.out.print("[" + i + " -> " + j + "] ");
          }
        }
        System.out.println();
      }
    }

    public int[][] getAdjMatrix() {
      return adj;
    }
  }
}
