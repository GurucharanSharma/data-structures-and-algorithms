package graph.lectures;

import graph.Graph;
import graph.Graph.AdjacencyList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

  public static void main(String[] args) {
    Graph.AdjacencyList adjacencyList = new AdjacencyList(10);

    adjacencyList.addEdge(1, 2);
    adjacencyList.addEdge(1, 6);
    adjacencyList.addEdge(2, 1);
    adjacencyList.addEdge(2, 3);
    adjacencyList.addEdge(2, 4);
    adjacencyList.addEdge(3, 2);
    adjacencyList.addEdge(4, 2);
    adjacencyList.addEdge(4, 5);
    adjacencyList.addEdge(5, 4);
    adjacencyList.addEdge(5, 8);
    adjacencyList.addEdge(6, 1);
    adjacencyList.addEdge(6, 7);
    adjacencyList.addEdge(6, 9);
    adjacencyList.addEdge(7, 6);
    adjacencyList.addEdge(7, 8);
    adjacencyList.addEdge(8, 5);
    adjacencyList.addEdge(8, 7);
    adjacencyList.addEdge(9, 6);

    Solution solution = new Solution();
    solution.traverse(adjacencyList.getAdjList());
  }

  static class Solution {

    public void traverse(List<List<Integer>> adjList) {
      boolean[] visited = new boolean[adjList.size()];

      // To handle disconnected components
      for (int i = 0; i < adjList.size(); i++) {
        if (!visited[i]) {
          visited[i] = true;
          traverse(adjList, visited, i);
        }
      }
    }

    private void traverse(List<List<Integer>> adjList, boolean[] visited, int start) {
      if (adjList.isEmpty()) {
        return;
      }

      Queue<Integer> queue = new LinkedList<>();

      queue.add(start);
      visited[start] = true;

      while (!queue.isEmpty()) {
        int node = queue.remove();
        System.out.println(node);

        for (Integer adjNode : adjList.get(node)) {
          if (!visited[adjNode]) {
            visited[adjNode] = true;
            queue.add(adjNode);
          }
        }
      }
    }
  }
}


