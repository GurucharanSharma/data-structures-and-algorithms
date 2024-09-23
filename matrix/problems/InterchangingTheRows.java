package matrix.problems;

import java.util.Arrays;

public class InterchangingTheRows {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 2, 3, 4},
//        {5, 6, 7, 8},
//        {9, 10, 11, 12},
//        {13, 14, 15, 16}
//    };

    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {10, 11, 12},
        {13, 14, 15}
    };

    interchangeRows(matrix);

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  //Function to interchange the rows of a matrix.
  static void interchangeRows(int[][] matrix) {
    int m = matrix.length;      // rows
    int n = matrix[0].length;   // cols

    for (int i = 0; i < n; i++) {
      int start = 0;
      int end = m - 1;

      while (start < end) {
        int temp = matrix[start][i];
        matrix[start][i] = matrix[end][i];
        matrix[end][i] = temp;

        start++;
        end--;
      }
    }
  }
}
