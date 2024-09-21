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

//    System.arraycopy(arr, low, left, 0, n);
//    System.arraycopy(arr, mid + 1, right, 0, m);

    int index = 0;
    for (int i = low; i <= mid; i++) {
      left[index++] = arr[i];
    }

    index = 0;
    for (int i = mid + 1; i <= high; i++) {
      right[index++] = arr[i];
    }

    int i = 0;
    int j = 0;
    index = low;
    while (i < n && j < m) {
      if (left[i] <= right[j]) {
        arr[index++] = left[i++];
      } else {
        arr[index++] = right[j++];
      }
    }

    while (i < n) {
      arr[index++] = left[i++];
    }

    while (j < m) {
      arr[index++] = right[j++];
    }
  }

  static void merge1(int[] arr, int start, int mid, int end) {
    int m = mid - start + 1;
    int n = end - mid;

    int[] left = new int[m];
    int[] right = new int[n];

    for (int i = 0; i < m; i++) {
      left[i] = arr[start + i];
    }

    for (int i = 0; i < n; i++) {
      right[i] = arr[start + m + i];
    }

    int i = 0;
    int j = 0;
    int index = start;
    while (i < m && j < n) {
      if (left[i] <= right[j]) {
        arr[index++] = left[i++];
      } else {
        arr[index++] = right[j++];
      }
    }

    while (i < m) {
      arr[index++] = left[i++];
    }

    while (j < n) {
      arr[index++] = right[j++];
    }

  }
}
