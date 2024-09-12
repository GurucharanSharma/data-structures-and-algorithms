package sorting.lectures;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {10, 5, 8, 20, 2, 18};
    sort(arr1);
    System.out.println(Arrays.toString(arr1));
  }

  // Method to perform insertion sort on an array.
  private static void sort(int[] arr) {
    // Loop starts from the second element (index 1) as the first element is considered sorted.
    for (int i = 1; i < arr.length; i++) {
      // 'j' is used to track the index for comparison and insertion, starting from 'i-1'.
      int j = i - 1;
      // 'element' holds the value of the current element to be inserted in the sorted part of the array.
      int element = arr[i];

      // Loop to find the correct position for 'element' in the sorted part of the array.
      // We use arr[j] > element to ensure stability - equal elements retain their original order.
      // The loop continues as long as 'j' is within bounds and 'element' is smaller than arr[j].
      while (j >= 0 && arr[j] > element) {
        // Shift the element at 'j' to the right, making space for 'element' to be inserted.
        arr[j + 1] = arr[j];
        // Decrement 'j' to compare 'element' with the previous element in the array.
        j--;
      }

      // Insert 'element' at its correct position, which is now at 'j+1'.
      arr[j + 1] = element;
    }
  }

  private static void sort1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int j = i;

      while (j > 0 && arr[j] < arr[j - 1]) {
        swap(arr, j, j - 1);
        j--;
      }
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
