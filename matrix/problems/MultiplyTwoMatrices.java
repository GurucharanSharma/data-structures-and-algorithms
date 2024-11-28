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

  // Approach 1
  static boolean multiplyMatrix(int[][] mat1, int[][] mat2, int[][] result) {
    if (mat2.length != mat1[0].length) {
      return false;
    }

    int[][] res = new int[mat2.length][mat1[0].length];

    for (int i = 0; i < mat1.length; i++) {
      for (int j = 0; j < mat2[i].length; j++) {
        for (int k = 0; k < mat1[i].length; k++) {
          res[i][j] += (mat1[i][k] * mat2[k][j]);
        }
      }
    }

    if (res.length != result.length || res[0].length != result[0].length) {
      return false;
    }

    for (int i = 0; i < result.length; i++) {
      if (!Arrays.equals(res[i], result[i])) {
        return false;
      }
    }

    return true;
  }

  // Approach 2
  static boolean multiplyMatrix1(int[][] mat1, int[][] mat2, int[][] result) {
    if (mat2.length != mat1[0].length) {
      return false;
    }

    int[][] res = new int[mat2.length][mat1[0].length];

    for (int i = 0; i < mat1.length; i++) {
      for (int j = 0; j < mat2[i].length; j++) {
        for (int k = 0; k < mat1[i].length; k++) {
          res[i][j] += (mat1[i][k] * mat2[k][j]);
        }

        if (res[i][j] != result[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
}
