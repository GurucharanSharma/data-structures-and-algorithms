package sorting.problems;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    testQuickSort1();
    testQuickSort2();
  }

  //Function to sort an array using quick sort algorithm.
  private static void quickSort(int[] arr, int low, int high) {
    // code here
    if (low < high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    // your code here
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void testQuickSort1() {
    int[] arr = {4, 1, 3, 9, 7};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void testQuickSort2() {
    int[] arr = {57, 38, 91, 10, 38, 28, 79, 41};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
