package graph.problems;

import java.util.Arrays;

public class FloodFillAlgorithm {

  static class Solution {

    public static void main(String[] args) {
      int[][] image = {
          {1, 1, 1},
          {2, 2, 0},
          {2, 2, 2}
      };

      System.out.println(Arrays.deepToString(floodFill(image, 2, 0, 3)));
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      int initColor = image[sr][sc];
      int[][] result = Arrays.stream(image).map(a -> Arrays.copyOf(a, a.length)).toArray(int[][]::new);

      int[] delRow = {-1, 0, 1, 0};
      int[] delCol = {0, -1, 0, 1};

      traverse(image, result, sr, sc, delRow, delCol, newColor, initColor);
      return result;
    }

    private static void traverse(int[][] image, int[][] result, int sr, int sc, int[] delRow, int[] delCol, int newColor, int initColor) {
      result[sr][sc] = newColor;

      int n = image.length;
      int m = image[0].length;

      for (int i = 0; i < delRow.length; i++) {
        int nRow = sr + delRow[i];
        int nCol = sc + delCol[i];

        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
          if (image[nRow][nCol] == initColor && result[nRow][nCol] != newColor) {
            result[nRow][nCol] = newColor;
            traverse(image, result, nRow, nCol, delRow, delCol, newColor, initColor);
          }
        }
      }
    }
  }
}
