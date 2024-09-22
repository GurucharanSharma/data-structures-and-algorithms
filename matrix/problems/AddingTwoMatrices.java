package matrix.problems;

import java.util.Arrays;

public class AddingTwoMatrices {

  public static void main(String[] args) {
    int[][] A = {
        {1, 2, 3},
        {4, 5, 6}
    };

    int[][] B = {
        {1, 3, 3},
        {2, 3, 3}
    };

    int[][] result = sumMatrix(A, B);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  //Function to add two matrices.
  static int[][] sumMatrix(int[][] A, int[][] B) {
    int r1 = A.length;
    int c1 = A[0].length;

    int r2 = B.length;
    int c2 = B[0].length;

    if (r1 != r2 || c1 != c2) {
      return new int[0][0];
    }

    int[][] output = new int[r1][c1];
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        output[i][j] = A[i][j] + B[i][j];
      }
    }

    return output;
  }
}
