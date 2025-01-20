package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

  public static void main(String[] args) {
//    int N = 4, M = 3;
//
//    List<Integer>[] G = new ArrayList[N];
//    for (int i = 0; i < N; i++) {
//      G[i] = new ArrayList<>();
//    }
//
//    G[0].add(1);
//    G[1].add(0);
//    G[1].add(2);
//    G[2].add(1);
//    G[2].add(3);
//    G[3].add(2);
//    G[3].add(0);
//    G[0].add(3);
//    G[0].add(2);
//    G[2].add(0);
//
//    int[] color = new int[N];
//
//    Solution solution = new Solution();
//    boolean ans = solution.graphColoring(G, color, 0, M);
//    if (ans) {
//      System.out.println("1");
//    } else {
//      System.out.println("0");
//    }

    int v = 3;
    int m = 2;

    List<int[]> edges = new ArrayList<>();
    edges.add(new int[]{1, 2});

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.graphColoring(v, edges, m));
  }

  static class Solution {

    private boolean graphColoring(List<Integer>[] G, int[] color, int i, int M) {
      int nodes = G.length;
      return solve(G, color, i, M, nodes);
    }

    private boolean solve(List<Integer>[] G, int[] color, int node, int M, int nodes) {
      if (node == nodes) {
        return true;
      }

      for (int i = 1; i <= M; i++) {
        if (isValid(G, color, node, i)) {
          color[node] = i;
          if (solve(G, color, node + 1, M, nodes)) {
            return true;
          } else {
            color[node] = 0;
          }
        }
      }

      return false;
    }

    private boolean isValid(List<Integer>[] G, int[] color, int node, int c) {
      for (Integer neighbour : G[node]) {
        if (color[neighbour] == c) {
          return false;
        }
      }

      return true;
    }
  }

  static class Solution1 {

    boolean graphColoring(int v, List<int[]> edges, int m) {
      int[] colors = new int[v];
      return colorGraph(v, edges, m, 0, colors);
    }

    private boolean colorGraph(int v, List<int[]> edges, int m, int node, int[] colors) {
      if (node == v) {
        return true;
      }

      for (int i = 1; i <= m; i++) {
        if (isValid(v, edges, i, node, colors)) {
          colors[node] = i;

          if (colorGraph(v, edges, m, node + 1, colors)) {
            return true;
          } else {
            colors[node] = 0;
          }
        }
      }

      return false;
    }

    private boolean isValid(int v, List<int[]> edges, int color, int node, int[] colors) {
      if (node >= edges.size()) {
        return false;
      }

      int[] neighbors = edges.get(node);
      for (int neighbor : neighbors) {
        if (colors[neighbor] == color) {
          return false;
        }
      }

      return true;
    }
  }
}
