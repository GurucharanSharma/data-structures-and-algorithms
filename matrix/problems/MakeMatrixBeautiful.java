package matrix.problems;

import java.util.Arrays;

public class MakeMatrixBeautiful {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {1, 2},
//        {3, 4}
//    };

    int[][] matrix = {
        {1, 2, 3},
        {4, 2, 3},
        {3, 2, 1}
    };

    System.out.println(findMinOperation(matrix.length, matrix));

    for (int[] arr : matrix) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public static int findMinOperation(int N, int[][] matrix) {
    int[] rowSum = new int[N];
    int[] colSum = new int[N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        rowSum[i] = rowSum[i] + matrix[i][j];
        colSum[j] = colSum[j] + matrix[i][j];
      }
    }

    int maxSum = 0;
    for (int i = 0; i < N; i++) {
      maxSum = Math.max(maxSum, Math.max(colSum[i], rowSum[i]));
    }

    int count = 0;
    for (int i = 0, j = 0; i < N && j < N; ) {
      int diff = Math.min(maxSum - rowSum[i], maxSum - colSum[j]);
      matrix[i][j] += diff;
      rowSum[i] += diff;
      colSum[j] += diff;
      count += diff;

      if (rowSum[i] == maxSum) {
        i++;
      }

      if (colSum[j] == maxSum) {
        j++;
      }
    }

    return count;
  }
}
