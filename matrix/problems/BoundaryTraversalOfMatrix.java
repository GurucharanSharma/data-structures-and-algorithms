package matrix.problems;

import java.util.ArrayList;

public class BoundaryTraversalOfMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    System.out.println(boundaryTraversal(matrix, matrix.length, matrix[0].length));
  }

  static ArrayList<Integer> boundaryTraversal(int[][] matrix, int n, int m) {
    ArrayList<Integer> list = new ArrayList<>();

    if (n == 1) {
      for (int i = 0; i < m; i++) {
        list.add(matrix[0][i]);
      }
    } else if (m == 1) {
      for (int i = 0; i < n; i++) {
        list.add(matrix[i][0]);
      }
    } else {
      for (int i = 0; i < m; i++) {
        list.add(matrix[0][i]);
      }

      for (int i = 1; i < n; i++) {
        list.add(matrix[i][m - 1]);
      }

      for (int i = m - 2; i >= 0; i--) {
        list.add(matrix[n - 1][i]);
      }

      for (int i = n - 2; i > 0; i--) {
        list.add(matrix[i][0]);
      }
    }

    return list;
  }
}
