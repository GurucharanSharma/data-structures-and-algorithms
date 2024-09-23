package matrix.problems;

import java.util.ArrayList;
import java.util.List;

public class SumOfUpperAndLowerTriangles {

  public static void main(String[] args) {
//    int[][] mat = {
//        {6, 5, 4},
//        {1, 2, 5},
//        {7, 9, 7}
//    };
//    int n = 3;

//    int[][] mat = {
//        {1, 2},
//        {3, 4}
//    };
//    int n = 2;

    int[][] mat = {{1}};
    int n = 1;

    System.out.println(sumTriangles(mat, n));
  }

  //Function to return sum of upper and lower triangles of a matrix.
  static ArrayList<Integer> sumTriangles(int[][] matrix, int n) {
    int uSum = 0;
    int lSum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j <= i) {
          lSum += matrix[i][j];
        }

        if (j >= i) {
          uSum += matrix[i][j];
        }
      }
    }

    return new ArrayList<>(List.of(uSum, lSum));
  }
}
