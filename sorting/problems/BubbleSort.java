package sorting.problems;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    testBubbleSort1();
    testBubbleSort2();
  }

  //Function to sort the array using bubble sort algorithm.
  public static void bubbleSort(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      boolean swapped = false;

      for (int j = 1; j < (n - i); j++) {
        if (arr[j] < arr[j - 1]) {
          swapped = true;

          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        }
      }

      if (!swapped) {
        break;
      }
    }
  }

  private static void testBubbleSort1() {
    int[] arr = {4, 1, 3, 9, 7};
    bubbleSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testBubbleSort2() {
    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    bubbleSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
