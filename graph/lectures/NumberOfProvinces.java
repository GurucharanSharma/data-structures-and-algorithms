package graph.lectures;

import graph.common.Graph;
import graph.common.Graph.AdjacencyList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {

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
    System.out.println(solution.countProvinces(adjacencyList.getAdjList()));
  }

  private static class Solution {

    public int countProvinces(List<List<Integer>> adj) {
      if (adj.isEmpty()) {
        return 0;
      }

      int n = adj.size();
      boolean[] visited = new boolean[n];
      int count = 0;

      for (int i = 1; i < n; i++) {
        if (!visited[i]) {
          traverse(adj, visited, i);
          count++;
        }
      }

      return count;
    }

    private void traverse(List<List<Integer>> adj, boolean[] visited, int start) {
      Queue<Integer> queue = new LinkedList<>();

      queue.add(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
        int u = queue.remove();

        for (Integer v : adj.get(u)) {
          if (!visited[v]) {
            visited[v] = true;
            queue.add(v);
          }
        }
      }
    }
  }
}
