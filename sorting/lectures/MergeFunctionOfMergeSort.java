package sorting.lectures;

import java.util.Arrays;

public class MergeFunctionOfMergeSort {

  public static void main(String[] args) {

    int[] arr = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
    int low = 0;
    int high = arr.length - 1;
    int mid = (high + low) / 2;

    merge(arr, low, mid, high);

    System.out.println(Arrays.toString(arr));
  }

  private static void merge(int[] arr, int low, int mid, int high) {
    int n = mid - low + 1;  // Adding 1 because mid is included in the left half.
    int m = high - mid;     // No need to add 1 because mid is excluded from the right half.

    int[] left = new int[n];
    int[] right = new int[m];

    System.arraycopy(arr, low, left, 0, n);
    System.arraycopy(arr, mid + 1, right, 0, m);

    int i = 0;
    int j = 0;
    int k = low;
    while (i < n && j < m) {
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    while (i < n) {
      arr[k++] = left[i++];
    }

    while (j < m) {
      arr[k++] = right[j++];
    }
  }
}
