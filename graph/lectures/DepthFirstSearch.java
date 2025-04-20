package graph.lectures;

import graph.common.Graph;
import graph.common.Graph.AdjacencyList;
import java.util.List;

public class DepthFirstSearch {

  public static void main(String[] args) {
    Graph.AdjacencyList adjacencyList = new AdjacencyList(10);

    adjacencyList.addEdge(1, 2);
    adjacencyList.addEdge(1, 6);
    adjacencyList.addEdge(2, 3);
    adjacencyList.addEdge(2, 4);
    adjacencyList.addEdge(4, 5);
    adjacencyList.addEdge(5, 8);
    adjacencyList.addEdge(6, 7);
    adjacencyList.addEdge(6, 9);
    adjacencyList.addEdge(7, 8);

    Solution solution = new Solution();
    solution.traverse(adjacencyList.getAdjList());
  }

  static class Solution {

    public void traverse(List<List<Integer>> adjList) {
      boolean[] visited = new boolean[adjList.size()];

      for (int i = 0; i < adjList.size(); i++) {
        if (!visited[i]) {
          visited[i] = true;
          traverse(adjList, visited, i);
        }
      }
    }

    private void traverse(List<List<Integer>> adjList, boolean[] visited, int u) {
      if (adjList.isEmpty()) {
        return;
      }

      if (visited[u]) {
        System.out.println(u);
      }

      for (Integer v : adjList.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          traverse(adjList, visited, v);
        }
      }
    }
  }

}

