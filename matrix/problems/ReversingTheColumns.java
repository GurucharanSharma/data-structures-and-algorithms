package matrix.problems;

import java.util.Arrays;

public class ReversingTheColumns {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 2, 3},
//        {5, 6, 7},
//        {11, 10, 9},
//        {13, 14, 15}
//    };

    int[][] matrix = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10}
    };

    reverseCol(matrix);

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  //Function to reverse the columns of a matrix.
  static void reverseCol(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      int start = 0;
      int end = n - 1;

      while (start < end) {
        int temp = matrix[i][start];
        matrix[i][start] = matrix[i][end];
        matrix[i][end] = temp;

        start++;
        end--;
      }
    }
  }
}
