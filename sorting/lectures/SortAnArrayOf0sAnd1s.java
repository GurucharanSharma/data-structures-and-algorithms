package sorting.lectures;

import java.util.Arrays;

public class SortAnArrayOf0sAnd1s {

  public static void main(String[] args) {

    int[] arr = {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    int i = -1;
    int j = arr.length;

    while (true) {
      do {
        i++;
      } while (i < j && arr[i] == 0);

      do {
        j--;
      } while (j > i && arr[j] == 1);

      if (i >= j) {
        break;
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
