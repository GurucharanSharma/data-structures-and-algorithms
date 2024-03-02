package sorting.lectures;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {

    int[] arr = {10, 5, 30, 15, 7};
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(arr1, 0, arr1.length - 1);
    System.out.println(Arrays.toString(arr1));
  }

  private static void sort(int[] arr, int start, int end) {
    if (end > start) {
      int mid = start + (end - start) / 2;

      sort(arr, start, mid);
      sort(arr, mid + 1, end);
      merge(arr, start, mid, end);
    }
  }

  private static void merge(int[] arr, int low, int mid, int high) {
    int n = mid - low + 1;
    int m = high - mid;

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
