package matrix.lectures;

public class MatrixBoundaryTraversal {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    boundaryTraversal(arr);
  }

  private static void boundaryTraversal(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;

    if (arr.length == 1) {
      for (int i = 0; i < cols; i++) {
        System.out.print(arr[0][i] + " ");
      }
    } else if (arr[0].length == 1) {
      for (int i = 0; i < rows; i++) {
        System.out.print(arr[i][0] + " ");
      }
    } else {
      for (int i = 0; i < cols; i++) {
        System.out.print(arr[0][i] + " ");
      }
      System.out.print("-> ");

      for (int i = 1; i < rows; i++) {
        System.out.print(arr[i][cols - 1] + " ");
      }
      System.out.print("-> ");

      for (int i = cols - 2; i >= 0; i--) {
        System.out.print(arr[rows - 1][i] + " ");
      }
      System.out.print("-> ");

      for (int i = rows - 2; i >= 1; i--) {
        System.out.print(arr[i][0] + " ");
      }
    }
  }
}
