package matrix.problems;

import java.util.Arrays;

public class BooleanMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 0},
        {0, 0}
    };

//    int[][] matrix = {
//        {1, 0, 0},
//        {1, 0, 0},
//        {1, 0, 0},
//        {0, 0, 0}
//    };

    booleanMatrix2(matrix);

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  // Naive Approach
  // Time Complexity: O((N*M)*(N + M)). O(N*M) for traversing through each element and (N+M)for traversing to row and column of elements having value 1.
  // Auxiliary Space: O(1)
  static void booleanMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          int k = 0;
          while (k < n) {
            if (matrix[i][k] != 1) {
              matrix[i][k] = -1;
            }

            k++;
          }

          k = 0;
          while (k < m) {
            if (matrix[k][j] != 1) {
              matrix[k][j] = -1;
            }

            k++;
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == -1) {
          matrix[i][j] = 1;
        }
      }
    }
  }

  // Efficient Approach 1: Using 2 arrays to keep track of 1s in the matrix.
  static void booleanMatrix1(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    int[] rows = new int[m];
    int[] cols = new int[n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          rows[i] = 1;
          cols[j] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rows[i] == 1 || cols[j] == 1) {
          matrix[i][j] = 1;
        }
      }
    }
  }

  // Efficient Approach 2: Without using extra space. Using the first two rows of the matrix to keep track of 1s in the matrix.
  static void booleanMatrix2(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    boolean firstRow = false;
    boolean firstCol = false;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0) {
            firstRow = true;
          }

          if (j == 0) {
            firstCol = true;
          }

          matrix[0][j] = 1;
          matrix[i][0] = 1;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[0][j] == 1 || matrix[i][0] == 1) {
          matrix[i][j] = 1;
        }
      }
    }

    if (firstRow) {
      for (int i = 0; i < n; i++) {
        matrix[0][i] = 1;
      }
    }

    if (firstCol) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 1;
      }
    }
  }
}
