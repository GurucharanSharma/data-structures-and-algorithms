package sorting.lectures;

import java.util.Arrays;

public class SortAnArrayOfNegativesAndPositives {

  public static void main(String[] args) {

    int[] arr = {-1, 2, 3, -8, 4, 5, -9, -7};
    segPostNegOptimised(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void segPosNegNaive(int[] arr) {
    int[] temp = new int[arr.length];
    int index = 0;

    for (int j : arr) {
      if (j < 0) {
        temp[index++] = j;
      }
    }

    for (int j : arr) {
      if (j > 0) {
        temp[index++] = j;
      }
    }

    System.arraycopy(temp, 0, arr, 0, arr.length);
  }

  private static void segPostNegOptimised(int[] arr) {
    int i = -1;
    int j = arr.length;

    while (true) {
      do {
        i++;
      } while (i < j && arr[i] < 0);

      do {
        j--;
      } while (j > i && arr[j] >= 0);

      if (i >= j) {
        return;
      }

      swap(arr, i, j);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
