package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

  public static void main(String[] args) {
    int[][] mat = {
        {0, 1, 2},
        {0, 1, 2},
        {2, 1, 1}
    };

    Solution solution = new Solution();
    System.out.println(solution.orangesRotting(mat));
  }

  private static class Solution {

    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
      int n = mat.length, m = mat[0].length;
      int[][] visited = new int[n][m];

      Queue<Pair> queue = new LinkedList<>();
      int freshCount = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (mat[i][j] == 2) {
            visited[i][j] = 2;
            queue.add(new Pair(i, j, 0));
          } else {
            visited[i][j] = 0;

            if (mat[i][j] == 1) {
              freshCount++;
            }
          }
        }
      }

      int[] delRow = {0, 1, 0, -1};
      int[] delCol = {1, 0, -1, 0};
      int result = 0, rottenCount = 0;

      while (!queue.isEmpty()) {
        Pair pair = queue.remove();
        result = Math.max(result, pair.time);

        for (int i = 0; i < 4; i++) {
          int nRow = pair.row + delRow[i];
          int nCol = pair.col + delCol[i];

          if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
            if (visited[nRow][nCol] == 0 && mat[nRow][nCol] == 1) {
              visited[nRow][nCol] = 2;
              queue.add(new Pair(nRow, nCol, pair.time + 1));
              rottenCount++;
            }
          }
        }
      }

      // System.out.println(rottenCount);
      // System.out.println(freshCount);

      return rottenCount == freshCount ? result : -1;
    }

    private static class Pair {

      int row;
      int col;
      int time;

      Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
      }
    }
  }
}
