package matrix.problems;

public class DeterminantOfMatrix {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 0, 2, -1},
//        {3, 0, 0, 5},
//        {2, 1, 4, -3},
//        {1, 0, 5, 0}
//    };

    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 10, 9}
    };

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

  static int determinantOfMatrix1(int[][] matrix, int n) {
    int num1, num2, det = 1, index, total = 1; // Initialize result

    // temporary array for storing row
    int[] temp = new int[n + 1];

    // loop for traversing the diagonal elements
    for (int i = 0; i < n; i++) {
      index = i; // initialize the index

      // finding the index which has non zero value
      while (index < n && matrix[index][i] == 0) {
        index++;
      }
      if (index == n) // if there is non zero element
      {
        // the determinant of matrix as zero
        continue;
      }

      if (index != i) {
        // loop for swapping the diagonal element row and index row
        swapRows(matrix, index, i, n);
        // determinant sign changes when we shift rows go through determinant properties
        det = det * (int) Math.pow(-1, index - i);
      }

      // storing the values of diagonal row elements
      for (int j = 0; j < n; j++) {
        temp[j] = matrix[i][j];
      }

      // traversing every row below the diagonal element
      for (int j = i + 1; j < n; j++) {
        num1 = temp[i]; // value of diagonal element
        num2 = matrix[j][i]; // value of next row element

        System.out.println(num1 + " " + num2);

        // traversing every column of row and multiplying to every row
        for (int k = 0; k < n; k++) {
          // multiplying to make the diagonal element and next row element equal
          matrix[j][k] = (num1 * matrix[j][k]) - (num2 * temp[k]);
        }

        total = total * num1; // Det(kA)=kDet(A);
      }
    }

    // multiplying the diagonal elements to get determinant
    for (int i = 0; i < n; i++) {
      det = det * matrix[i][i];
    }

    return (det / total); // Det(kA)/k=Det(A);
  }

  // Function to swap two rows
  static void swapRows(int[][] matrix, int row1, int row2, int n) {
    for (int i = 0; i < n; i++) {
      int temp = matrix[row1][i];
      matrix[row1][i] = matrix[row2][i];
      matrix[row2][i] = temp;
    }
  }
}
