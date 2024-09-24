package matrix.problems;

public class DeterminantOfMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 0, 2, -1},
        {3, 0, 0, 5},
        {2, 1, 4, -3},
        {1, 0, 5, 0}
    };

//    int[][] matrix = {
//        {1, 2, 3},
//        {4, 5, 6},
//        {7, 10, 9}
//    };

    System.out.println(determinantOfMatrix(matrix, matrix.length));
    System.out.println(determinantOfMatrix1(matrix, matrix.length));
  }

  /**
   * Approach 1: Using recursion
   */
  //Function for finding determinant of matrix.
  static int determinantOfMatrix(int[][] matrix, int n) {
    if (n == 1) {
      return matrix[0][0];
    }

    if (n == 2) {
      return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    int det = 0;
    int sign = 1;
    int[][] temp = new int[n][n];

    for (int i = 0; i < n; i++) {
      getCofactor(matrix, temp, 0, i, n);
      det += sign * matrix[0][i] * determinantOfMatrix(temp, n - 1);
      sign = -sign;
    }

    return det;
  }

  static void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
    int i = 0;
    int j = 0;

    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (r != p && c != q) {
          temp[i][j++] = matrix[r][c];

          if (j == n - 1) {
            j = 0;
            i++;
          }
        }
      }
    }
  }

  /**
   * Approach 1: Iterative approach
   */
  //Function for finding determinant of matrix.
  static int determinantOfMatrix1(int[][] matrix, int n) {
    // TODO
    return -1;
  }

  static void swapRows(int[][] matrix, int row1, int row2, int n) {
    for (int i = 0; i < n; i++) {
      int temp = matrix[row1][i];
      matrix[row1][i] = matrix[row2][i];
      matrix[row2][i] = temp;
    }
  }
}
