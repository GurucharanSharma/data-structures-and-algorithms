package stack.lectures;

public class LargestRectangleAreaWithAll1s {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1}
    };
//    int[][] matrix = {
//        {0, 1, 1, 0},
//        {1, 1, 1, 1},
//        {1, 1, 1, 1},
//        {1, 1, 0, 0},
//    };

    System.out.println(largestArea(matrix));
  }

  public static int largestArea(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;

    int res = largestHistogram(matrix[0]);
    for (int i = 1; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
        }
      }

      res = Math.max(res, largestHistogram(matrix[i]));
    }

    return res;
  }

  private static int largestHistogram(int[] arr) {
    int res = 0;

    for (int i = 0; i < arr.length; i++) {
      int pse = 0;
      int nse = arr.length - 1;

      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i]) {
          pse = j + 1;
          break;
        }
      }

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          nse = j - 1;
          break;
        }
      }

      int area = (nse - pse + 1) * arr[i];
      res = Math.max(res, area);
    }

    return res;
  }
}
