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

  // Recursive Approach
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
      getCofactor(matrix, temp, i, n);
      det += sign * matrix[0][i] * determinantOfMatrix(temp, n - 1);
      sign = -sign;
    }

    return det;
  }

  static void getCofactor(int[][] matrix, int[][] temp, int q, int n) {
    int i = 0;
    int j = 0;

    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (r != 0 && c != q) {
          temp[i][j++] = matrix[r][c];

          if (j == n - 1) {
            j = 0;
            i++;
          }
        }
      }
    }
  }

  // Iterative Approach
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
      System.arraycopy(matrix[i], 0, temp, 0, n);

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

  public static double calculateDeterminant(int[][] matrix) {
    int n = matrix.length;
    double determinant = 1;

    // Convert the matrix to an upper triangular form
    for (int col = 0; col < n; col++) {
      // Find the pivot (maximum element in the current column)
      int maxRow = col;
      for (int row = col + 1; row < n; row++) {
        if (Math.abs(matrix[row][col]) > Math.abs(matrix[maxRow][col])) {
          maxRow = row;
        }
      }

      // If the pivot is zero, the determinant is zero
      if (matrix[maxRow][col] == 0) {
        return 0;
      }

      // Swap rows if needed
      if (maxRow != col) {
        swapRows(matrix, col, maxRow, n);
        determinant *= -1; // Swapping rows changes the sign of the determinant
      }

      // Eliminate entries below the pivot
      for (int row = col + 1; row < n; row++) {
        double factor = (double) matrix[row][col] / matrix[col][col];
        for (int k = col; k < n; k++) {
          matrix[row][k] -= (int) (factor * matrix[col][k]);
        }
      }

      // Multiply determinant by the diagonal element
      determinant *= matrix[col][col];
    }

    return determinant;
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
