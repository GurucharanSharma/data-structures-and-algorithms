package matrix.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowAndColumnPairs {

  public static void main(String[] args) {
    int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
//    int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};

    Solution solution = new Solution();
    System.out.println(solution.equalPairs(grid));
    System.out.println();

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.equalPairs(grid));
    System.out.println(solution1.equalPairs1(grid));
    System.out.println();

    Solution2 solution2 = new Solution2();
    System.out.println(solution2.equalPairs(grid));
    System.out.println();
  }

  static class Solution2 {

    public int equalPairs(int[][] grid) {
      int n = grid.length;
      int[][] copy = new int[n][n];
      int count = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          copy[j][i] = grid[i][j];
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (Arrays.equals(grid[i], copy[j])) {
            count++;
          }
        }
      }

      return count;
    }
  }

  static class Solution1 {

    public int equalPairs1(int[][] grid) {
      int gridWidth = grid.length;
      Map<List<Integer>, Integer> rowHashMap = new HashMap<>(gridWidth);

      // Add rows to the hashmap
      for (int[] row : grid) {
        List<Integer> rowList = new ArrayList<>(gridWidth);
        for (int num : row) {
          rowList.add(num);
        }
        rowHashMap.put(rowList, rowHashMap.getOrDefault(rowList, 0) + 1);
      }

      int sum = 0;
      // Check columns and count matches with rows
      for (int j = 0; j < gridWidth; j++) {
        List<Integer> columnList = new ArrayList<>(gridWidth);
        for (int i = 0; i < gridWidth; i++) {
          columnList.add(grid[i][j]);
        }

        sum += rowHashMap.getOrDefault(columnList, 0);
      }
      return sum;
    }

    public int equalPairs(int[][] grid) {
      Map<String, Integer> rowHash = new HashMap<>();
      Map<String, Integer> colHash = new HashMap<>();

      for (int i = 0; i < grid.length; i++) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < grid[0].length; j++) {
          builder.append(grid[i][j]).append("+");
        }

        rowHash.put(builder.toString(), rowHash.getOrDefault(builder.toString(), 0) + 1);
      }

      for (int j = 0; j < grid[0].length; j++) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
          builder.append(grid[i][j]).append("+");
        }

        colHash.put(builder.toString(), colHash.getOrDefault(builder.toString(), 0) + 1);
      }

      int count = 0;
      for (Map.Entry<String, Integer> entry : rowHash.entrySet()) {
        if (colHash.containsKey(entry.getKey())) {
          count += (entry.getValue() * colHash.get(entry.getKey()));
        }
      }

      return count;
    }
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
