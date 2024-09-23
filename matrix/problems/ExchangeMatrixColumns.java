package matrix.problems;

import java.util.Arrays;

public class ExchangeMatrixColumns {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 2, 3, 4},
//        {5, 6, 7, 8},
//        {9, 10, 11, 12},
//        {13, 14, 15, 16}
//    };

    int[][] matrix = {
        {4, 3, 2},
        {1, 5, 6}
    };

    exchangeColumns(matrix);

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  //Function to exchange first column of a matrix with its last column.
  static void exchangeColumns(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      int temp = matrix[i][0];
      matrix[i][0] = matrix[i][n - 1];
      matrix[i][n - 1] = temp;
    }
  }
}
