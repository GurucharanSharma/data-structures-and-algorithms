package sorting.problems;

import java.util.Arrays;

public class SortKSortedArray {

  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 2, 8, 10, 9};
    int k = 3;

    System.out.println(Arrays.toString(arr));
//    insertionSort(arr, arr.length, k);
    quickSort(arr, 0, arr.length - 1, k);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Approach 1: Insertion sort
   */
  static void insertionSort(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      int item = arr[i];
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          arr[j] = arr[j - 1];
          arr[j - 1] = item;
        }
      }
    }
  }

  /**
   * Approach 2: Modified insertion sort. We need not go more than k steps behind.
   * <p>
   * In this modified algorithm, we only shift elements to the right if the current element is more than k positions away from its correct position.
   * This optimization takes advantage of the fact that the elements are already nearly sorted and reduces the number of operations performed,
   * resulting in a faster sorting algorithm for nearly sorted arrays.
   */
  static void insertionSort(int[] arr, int n, int k) {
    for (int i = 0; i < n; i++) {
      int item = arr[i];
      // Check if the previous element is greater than the current
      // element, and shift elements to the right until the correct
      // position is found, but only if the current element is more
      // than k positions away from its correct position
      for (int j = i; j > Math.max(0, i - k); j--) {
        if (arr[j] < arr[j - 1]) {
          arr[j] = arr[j - 1];
          arr[j - 1] = item;
        }
      }
    }
  }

  /**
   * Approach 3: Modified quick sort. We need not go more than k steps behind.
   * <p>
   * The algorithm uses quick sort but changes the partition function in 2 ways.
   * <p>
   * Selects the pivot element as the middle element instead of the first or last element.
   * <p>
   * Scans the array from max(low, mid – k) to min(mid + k, high) instead of low to high.
   * <p>
   * The middle element is chosen as the pivot for dividing the array into almost 2 halves for logarithmic time complexity
   */
  static void quickSort(int[] arr, int start, int end, int k) {
    if (start < end) {
      int pivot = partition(arr, start, end, k);
      quickSort(arr, start, pivot - 1, k);
      quickSort(arr, pivot + 1, end, k);
    }
  }

  // Lomuto partition
  static int partition(int[] arr, int start, int end, int k) {
    int mid = start + (end - start) / 2;
    start = Math.max(start, mid - k);
    end = Math.min(end, mid + k);

    swap(arr, end, mid);
    int pivot = arr[end];

    int i = start - 1;
    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, end);
    return i + 1;
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
