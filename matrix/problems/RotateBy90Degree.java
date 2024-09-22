package matrix.problems;

import java.util.Arrays;

public class RotateBy90Degree {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}
//    };

//    int[][] matrix = {
//        {1, 2},
//        {3, 4}
//    };

    int[][] matrix = {
        {2, 94, 49, 30, 24, 85},
        {55, 57, 41, 67, 77, 32},
        {9, 45, 40, 27, 24, 38},
        {39, 19, 83, 30, 42, 34},
        {16, 40, 59, 5, 31, 78},
        {7, 74, 87, 22, 46, 25}
    };

    rotateby90(matrix, matrix.length);

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  //Function to rotate matrix anticlockwise by 90 degrees.
  static void rotateby90(int[][] matrix, int n) {
    transpose(matrix, n);

    for (int i = 0; i < n; i++) {
      int start = 0;
      int end = n - 1;

      while (start < end) {
        int temp = matrix[start][i];
        matrix[start][i] = matrix[end][i];
        matrix[end][i] = temp;

        start++;
        end--;
      }
    }
  }

  static void transpose(int[][] arr, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
  }
}
