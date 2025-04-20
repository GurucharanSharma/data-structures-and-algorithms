package graph;

import graph.common.Graph.AdjacencyList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRunner {

  public static void main(String[] args) {
    AdjacencyList adjacencyList = new AdjacencyList(5);

    adjacencyList.addEdge(1, 2);
    adjacencyList.addEdge(1, 3);
    adjacencyList.addEdge(3, 2);
    adjacencyList.addEdge(4, 5);

//    traverse(adjacencyList);
    adjacencyList.printGraph();
  }

  private static void traverse(AdjacencyList list) {
    int n = list.getAdjList().size();
    boolean[] visited = new boolean[n];

    for (int i = 1; i < n; i++) {
      if (!visited[i]) {
        System.out.println(i + " => ");
        visited[i] = true;
        traverse(list.getAdjList(), visited, i);
      }
    }
  }

  private static void traverse(List<List<Integer>> list, boolean[] visited, int start) {
    if (list.isEmpty()) {
      return;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Integer node = queue.remove();
      System.out.println(node);

      for (Integer n: list.get(node)) {
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
}
