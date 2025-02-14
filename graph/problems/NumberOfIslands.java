package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

  public static void main(String[] args) {
//    int[][] grid = {
//        {0, 1}, {1, 0}, {1, 1}, {1, 0}
//    };

    int[][] grid = {
        {0, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 1, 0}
    };

    Solution solution = new Solution();
    System.out.println(solution.numIslands(grid));
  }

  static class Solution {

    public int numIslands(int[][] grid) {
      int n = grid.length, m = grid[0].length;
      int count = 0;
      boolean[][] visited = new boolean[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1 && !visited[i][j]) {
            count++;
            traverse(grid, visited, i, j);
          }
        }
      }

      return count;
    }

    private void traverse(int[][] grid, boolean[][] visited, int row, int col) {
      Queue<Pair> queue = new LinkedList<>();
      int n = grid.length, m = grid[0].length;

      queue.add(new Pair(row, col));
      visited[row][col] = true;

      while (!queue.isEmpty()) {
        Pair pair = queue.remove();

        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            int nRow = pair.row + i;
            int nCol = pair.col + j;

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
              if (grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                visited[nRow][nCol] = true;

                traverse(grid, visited, nRow, nCol);
                //queue.add(new Pair(nRow, nCol));
              }
            }
          }
        }
      }
    }
  }

  static class Pair {

    int row;
    int col;

    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
