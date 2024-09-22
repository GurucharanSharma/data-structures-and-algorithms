package matrix.lectures;

public class RotateMatrixAntiClockwiseBy90 {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    rotateMatrixOptimised(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void rotateMatrixNaive(int[][] arr) {
    int[][] temp = new int[arr.length][arr[0].length];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        temp[arr.length - j - 1][i] = arr[i][j];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      System.arraycopy(temp[i], 0, arr[i], 0, arr[i].length);
    }
  }

  private static void rotateMatrixOptimised(int[][] arr) {
    transposeOptimised(arr);

    for (int i = 0; i < arr[0].length; i++) {
      int low = 0;
      int high = arr.length - 1;

      while (low <= high) {
        int temp = arr[low][i];
        arr[low][i] = arr[high][i];
        arr[high][i] = temp;

        low++;
        high--;
      }
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
