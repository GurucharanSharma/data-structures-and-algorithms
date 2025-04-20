package graph.problems;

import graph.common.Graph;
import graph.common.Graph.AdjacencyList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

  public static void main(String[] args) {
    Graph.AdjacencyList adjacencyList = new AdjacencyList(10);

    adjacencyList.addEdge(1, 2);
    adjacencyList.addEdge(1, 3);
    adjacencyList.addEdge(2, 4);
    adjacencyList.addEdge(5, 6);
    adjacencyList.addEdge(7, 8);
    adjacencyList.addEdge(7, 9);

    // Uncomment the following line to make the graph cyclic
//    adjacencyList.addEdge(8, 9);

    System.out.println(isCyclicBFS(adjacencyList.getAdjList()));
    System.out.println();

    System.out.println(isCyclicDFS(adjacencyList.getAdjList()));
    System.out.println();
  }

  /**
   * Determines if the graph contains a cycle using BFS.
   *
   * @param adjList The adjacency list representation of the graph.
   * @return true if the graph contains a cycle, false otherwise.
   */
  private static boolean isCyclicBFS(List<List<Integer>> adjList) {
    int n = adjList.size();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;

        if (hasCycleBFS(adjList, visited, i)) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean hasCycleBFS(List<List<Integer>> adjList, boolean[] visited, int start) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(start, -1));

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();

      for (Integer node : adjList.get(pair.node)) {
        if (!visited[node]) {
          visited[node] = true;
          queue.add(new Pair(node, pair.node));
        } else {
          if (pair.parent != node) {
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * Determines if the graph contains a cycle using DFS.
   *
   * @param adjList The adjacency list representation of the graph.
   * @return true if the graph contains a cycle, false otherwise.
   */
  private static boolean isCyclicDFS(List<List<Integer>> adjList) {
    int n = adjList.size();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (hasCycleDFS(adjList, visited, new Pair(i, -1))) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean hasCycleDFS(List<List<Integer>> adjList, boolean[] visited, Pair pair) {
    for (Integer node : adjList.get(pair.node)) {
      if (!visited[node]) {
        visited[node] = true;
        if (hasCycleDFS(adjList, visited, new Pair(node, pair.node))) {
          return true;
        }
      } else {
        if (pair.parent != node) {
          return true;
        }
      }
    }

    return false;
  }

  private static class Pair {

    int node;
    int parent;

    Pair(int node, int parent) {
      this.node = node;
      this.parent = parent;
    }
  }
}
