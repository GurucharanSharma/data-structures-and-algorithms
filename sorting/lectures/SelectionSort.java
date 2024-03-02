package sorting.lectures;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {

    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sortNaive(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {10, 5, 8, 20, 2, 18};
    sortNaive(arr1);
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sortOptimised(arr2);
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = {10, 5, 8, 20, 2, 18};
    sortOptimised(arr3);
    System.out.println(Arrays.toString(arr3));
  }

  private static void sortNaive(int[] arr) {
    int[] temp = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int min = arr[i];
      int index = i;

      for (int j = 0; j < arr.length; j++) {
        if (arr[j] < arr[index]) {
          min = arr[j];
          index = j;
        }
      }

      temp[i] = min;
      arr[index] = Integer.MAX_VALUE;
    }

    System.arraycopy(temp, 0, arr, 0, arr.length);
  }

  // Method to perform the selection sort on an array.
  private static void sortOptimised(int[] arr) {
    // Iterate over each element of the array except the last one.
    for (int i = 0; i < arr.length - 1; i++) {
      // 'index' is used to track the position of the smallest element found during the iteration.
      // It's initially set to the current position 'i'.
      int index = i;

      // Inner loop to find the smallest element in the unsorted part of the array.
      // It starts from 'i + 1' as the part before 'i' is already sorted.
      for (int j = i + 1; j < arr.length; j++) {
        // If a smaller element is found, update 'index' with its position.
        if (arr[j] < arr[index]) {
          index = j;
        }
      }

      // Swap the smallest found element with the element at position 'i'.
      // This places the smallest element found in its correct sorted position.
      swap(arr, i, index);
    }
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
