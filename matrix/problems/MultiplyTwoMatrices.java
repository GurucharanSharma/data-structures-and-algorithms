package matrix.problems;

import java.util.Arrays;

public class MultiplyTwoMatrices {

  public static void main(String[] args) {
//    int[][] A = {{2}};
//    int[][] B = {{3}};

    int[][] A = {
        {4, 8},
        {0, 2},
        {1, 6}
    };

    int[][] B = {
        {5, 2},
        {9, 4}
    };

    int[][] result = multiplyMatrix(A, B);

    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
  }

  //Function to multiply two matrices.
  static int[][] multiplyMatrix(int[][] A, int[][] B) {
    int n1 = A.length;
    int m1 = A[0].length;
    int n2 = B.length;
    int m2 = B[0].length;

    if (m1 != n2) {
      return new int[0][0];
    }

    int[][] output = new int[n1][m2];
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < m2; j++) {
        for (int k = 0; k < n2; k++) {
          output[i][j] += (A[i][k] * B[k][j]);
        }
      }

    }

    return output;
  }
}
