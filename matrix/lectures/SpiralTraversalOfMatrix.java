package matrix.lectures;

public class SpiralTraversalOfMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };

    spiralTraversal(arr, arr.length, arr[0].length);
  }

  private static void spiralTraversal(int[][] arr, int R, int C) {
    int top = 0;
    int right = C - 1;
    int bottom = R - 1;
    int left = 0;

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        System.out.print(arr[top][i] + " ");
      }
      System.out.println();

      top++;

      for (int i = top; i <= bottom; i++) {
        System.out.print(arr[i][right] + " ");
      }
      System.out.println();

      right--;

      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          System.out.print(arr[bottom][i] + " ");
        }
        System.out.println();

        bottom--;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          System.out.print(arr[i][left] + " ");
        }
        System.out.println();

        left++;
      }
    }
  }
}
