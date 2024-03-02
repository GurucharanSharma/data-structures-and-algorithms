package sorting.lectures;

import java.util.Arrays;

public class TailCallEliminationInQuickSort {

  public static void main(String[] args) {

    // Using Lomuto partition
    int[] arr1 = {8, 4, 7, 9, 3, 10, 5};
    lSort(arr1, 0, arr1.length - 1);
    System.out.println(Arrays.toString(arr1));

    int[] arr3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    lSort(arr3, 0, arr3.length - 1);
    System.out.println(Arrays.toString(arr3));

    int[] arr5 = {1, 2, 3, 4, 5, 6};
    lSort(arr5, 0, arr5.length - 1);
    System.out.println(Arrays.toString(arr5));

    // Using Hoare partition
    int[] arr = {8, 4, 7, 9, 3, 10, 5};
    hSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));

    int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    hSort(arr2, 0, arr2.length - 1);
    System.out.println(Arrays.toString(arr2));

    int[] arr4 = {1, 2, 3, 4, 5, 6};
    hSort(arr4, 0, arr4.length - 1);
    System.out.println(Arrays.toString(arr4));
  }

  /**
   * Since Lomuto partition ensures that the pivot will always be at its correct position, hence we call Lomuto partition from low to pivot - 1 and
   * then from pivot + 1 till the end.
   *
   * @param arr
   * @param low
   * @param high
   */
  private static void lSort(int[] arr, int low, int high) {
    while (low < high) {
      // Partition the array and get the pivot index
      int pivot = lPartition(arr, low, high);

      // Decide whether to recursively call lSort on the left or the right half
      // We choose the smaller half to reduce the maximum recursion depth
      if (pivot - low < high - pivot) {
        // Recursively sort the smaller left part
        lSort(arr, low, pivot - 1);
        // Update low to sort the right part iteratively in the next loop iteration
        low = pivot + 1;
      } else {
        // Recursively sort the smaller right part
        lSort(arr, pivot + 1, high);
        // Update high to sort the left part iteratively in the next loop iteration
        high = pivot - 1;
      }
    }
  }

  private static int lPartition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
    }

    swap(arr, i, high);
    return i;
  }

  /**
   * Since Hoare partition does not ensure the correct position of the pivot element, we also have to sort the pivot element as well. Hence, we call
   * Hoare partition from low to pivot and then from pivot + 1 till the end.
   *
   * @param arr
   * @param low
   * @param high
   */
  private static void hSort(int[] arr, int low, int high) {
    while (low < high) {
      int pivot = hPartition(arr, low, high);

      // Instead of recursively calling for both halves,
      // we handle the smaller half recursively and the larger half iteratively.
      if (pivot - low < high - pivot) {
        hSort(arr, low, pivot);
        low = pivot + 1;
      } else {
        hSort(arr, pivot + 1, high);
        high = pivot;
      }
    }
  }

  private static int hPartition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      swap(arr, i, j);
    }

    return j;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
