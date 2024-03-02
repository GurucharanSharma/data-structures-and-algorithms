package sorting.problems;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    testInsertionSort1();
    testInsertionSort2();
  }

  private static void insert(int[] arr, int i) {
    // Your code here
    int num = arr[i];
    int j = i - 1;
    while (j >= 0 && num < arr[j]) {
      arr[j + 1] = arr[j];
      j--;
    }

    arr[j + 1] = num;
  }

  //Function to sort the array using insertion sort algorithm.
  private static void insertionSort(int[] arr, int n) {
    //code here
    for (int i = 1; i < n; i++) {
      insert(arr, i);
    }
  }

  private static void testInsertionSort1() {
    int[] arr = {4, 1, 3, 9, 7};
    insertionSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testInsertionSort2() {
    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    insertionSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
