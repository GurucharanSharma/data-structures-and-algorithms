package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

  public static void main(String[] args) {
    int N = 4, M = 3;

    Solution solution = new Solution();
    solution.graphColoring(N, M);
  }

  static class Solution {

    public void graphColoring(int N, int M) {
      List<Integer>[] G = new ArrayList[N];
      for (int i = 0; i < N; i++) {
        G[i] = new ArrayList<>();
      }

      G[0].add(1);
      G[1].add(0);
      G[1].add(2);
      G[2].add(1);
      G[2].add(3);
      G[3].add(2);
      G[3].add(0);
      G[0].add(3);
      G[0].add(2);
      G[2].add(0);

      int[] color = new int[N];
      boolean ans = graphColoring(G, color, 0, M);
      if (ans) {
        System.out.println("1");
      } else {
        System.out.println("0");
      }
    }

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
}
