package matrix.lectures;

public class TransposeOfAMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    transposeOptimised(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.printf("%2d", arr[i][j]);
      }
      System.out.println();
    }
  }

  private static void transposeNaive(int[][] arr) {
    int[][] temp = new int[arr.length][arr[0].length];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        temp[i][j] = arr[j][i];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      System.arraycopy(temp[i], 0, arr[i], 0, arr[i].length);
    }
  }

  private static void transposeOptimised(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr[i].length; j++) {
        swap(arr, i, j);
      }
    }
  }

  private static void swap(int[][] arr, int i, int j) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
  }
}
