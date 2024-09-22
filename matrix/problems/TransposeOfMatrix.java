package matrix.problems;

import java.util.Arrays;

public class TransposeOfMatrix {

  public static void main(String[] args) {
//    int[][] mat = {
//        {1, 1, 1, 1},
//        {2, 2, 2, 2},
//        {3, 3, 3, 3},
//        {4, 4, 4, 4}
//    };

    int[][] mat = {
        {1, 2},
        {-9, -2}
    };

    transpose(mat.length, mat);

    for (int[] arr : mat) {
      System.out.println(Arrays.toString(arr));
    }
  }

  static void transpose(int n, int[][] a) {
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
      }
    }
  }
}
