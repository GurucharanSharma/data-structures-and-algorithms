package backtracking.lectures;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

  public static void main(String[] args) {
    int n = 4;
    int[][] a = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {1, 1, 0, 0},
        {0, 1, 1, 1}
    };

    Solution solution = new Solution();
    System.out.println(solution.findPath(n, a));

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.findPath(n, a));
  }

  static class Solution {

    public List<List<String>> findPath(int n, int[][] matrix) {
      List<List<String>> result = new ArrayList<>();
      boolean[][] visited = new boolean[n][n];

      if (matrix[0][0] == 1) {
        findPath(matrix, n, result, new ArrayList<>(), visited, 0, 0);
      }

      return result;
    }

    private void findPath(int[][] matrix, int n, List<List<String>> result, List<String> path, boolean[][] visited, int row, int col) {
      if (row == n - 1 && col == n - 1) {
        result.add(new ArrayList<>(path));
        return;
      }

      // up
      if (row - 1 >= 0 && !visited[row - 1][col] && matrix[row - 1][col] == 1) {
        visited[row][col] = true;
        path.add("U");
        findPath(matrix, n, result, path, visited, row - 1, col);
        path.remove(path.size() - 1);
        visited[row][col] = false;
      }

      // right
      if (col + 1 < n && !visited[row][col + 1] && matrix[row][col + 1] == 1) {
        visited[row][col] = true;
        path.add("R");
        findPath(matrix, n, result, path, visited, row, col + 1);
        path.remove(path.size() - 1);
        visited[row][col] = false;
      }

      // down
      if (row + 1 < n && !visited[row + 1][col] && matrix[row + 1][col] == 1) {
        visited[row][col] = true;
        path.add("D");
        findPath(matrix, n, result, path, visited, row + 1, col);
        path.remove(path.size() - 1);
        visited[row][col] = false;
      }

      // left
      if (col - 1 >= 0 && !visited[row][col - 1] && matrix[row][col - 1] == 1) {
        visited[row][col] = true;
        path.add("L");
        findPath(matrix, n, result, path, visited, row, col - 1);
        path.remove(path.size() - 1);
        visited[row][col] = false;
      }
    }
  }

  static class Solution1 {

    public List<List<String>> findPath(int n, int[][] matrix) {
      List<List<String>> result = new ArrayList<>();
      boolean[][] visited = new boolean[n][n];

      int[] dI = {-1, 0, 1, 0};
      int[] dJ = {0, 1, 0, -1};

      if (matrix[0][0] == 1) {
        findPath(matrix, n, result, new ArrayList<>(), visited, 0, 0, dI, dJ);
      }

      return result;
    }

    private void findPath(int[][] matrix, int n, List<List<String>> result, List<String> path, boolean[][] visited, int row, int col, int[] dI,
        int[] dJ) {
      if (row == n - 1 && col == n - 1) {
        result.add(new ArrayList<>(path));
        return;
      }

      String directions = "URDL";

      for (int d = 0; d < 4; d++) {
        int nextRow = row + dI[d];
        int nextCol = col + dJ[d];

        if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && !visited[nextRow][nextCol] && matrix[nextRow][nextCol] == 1) {
          visited[nextRow][nextCol] = true;
          path.add(String.valueOf(directions.charAt(d)));
          findPath(matrix, n, result, path, visited, nextRow, nextCol, dI, dJ);
          path.remove(path.size() - 1);
          visited[nextRow][nextCol] = false;
        }
      }
    }
  }
}
