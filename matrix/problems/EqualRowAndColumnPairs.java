package matrix.problems;

public class EqualRowAndColumnPairs {

  public static void main(String[] args) {
//    int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
    int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};

    Solution solution = new Solution();
    System.out.println(solution.equalPairs(grid));
  }

  static class Solution {

    public int equalPairs(int[][] grid) {
      int pairs = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (isEqual(grid, i, j)) {
            pairs++;
          }
        }
      }

      return pairs;
    }

    private boolean isEqual(int[][] grid, int row, int col) {
      int i = 0;

      while (i < grid.length && i < grid[0].length) {
        if (grid[row][i] != grid[i][col]) {
          return false;
        }

        i++;
      }

      return true;
    }
  }
}
