package sorting.lectures;

import java.util.Arrays;

public class BubbleSort {

  /**
   * <strong>Explanation</strong>
   * <p>
   * This code is an implementation of the bubble sort algorithm, which is a simple sorting algorithm that repeatedly steps through the list, compares
   * adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted. The
   * optimization in this implementation is that with each pass through the array, the largest unsorted element "bubbles up" to its correct position,
   * reducing the number of comparisons in subsequent passes. This is achieved by reducing the range of the inner loop (arr.length - i - 1) with each
   * outer loop iteration (i).
   */
  public static void main(String[] args) {

    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sortOptimised(arr1);
    System.out.println(Arrays.toString(arr1));
  }

  // Method to perform the bubble sort on an array
  private static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  // Method to perform the optimized bubble sort on an array.
  private static void sortOptimised(int[] arr) {
    // Loop through each element of the array.
    // The variable 'i' represents the number of passes completed.
    for (int i = 0; i < arr.length - 1; i++) {
      // Create a variable to track whether any element was out of order and swapping was done for it.
      boolean swapped = false;
      // Inner loop to perform the comparison and swapping in each pass.
      // We subtract 'i' in the condition because, after each pass, the last 'i' elements are already sorted.
      for (int j = 0; j < arr.length - i - 1; j++) {
        // Comparing adjacent elements.
        // If the current element is greater than the next one, they are swapped.
        if (arr[j] > arr[j + 1]) {
          swapped = true;
          // Call to a method that swaps the elements at index 'j' and 'j+1'.
          swap(arr, j, j + 1);
        }
      }
      // After each pass, the largest element among the unsorted elements is moved to its correct position.

      // If no element was swapped in the pass, that means all the elements are now sorted. Exit the loop.
      if (!swapped) {
        break;
      }
    }
  }

  // Method to swap two elements within the array
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
