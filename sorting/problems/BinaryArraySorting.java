package sorting.problems;

import java.util.Arrays;

public class BinaryArraySorting {

  public static void main(String[] args) {
    testBinaryArraySorting1();
    testBinaryArraySorting2();
    testBinaryArraySorting3();
    testBinaryArraySorting4();
  }

  //Function to sort the binary array.
  private static void binSort(int[] A, int N) {
    // add your code here
    int i = -1;
    int j = N;

    while (i <= j) {

      do {
        i++;
      } while (i < j && A[i] == 0);

      do {
        j--;
      } while (j > i && A[j] == 1);

      if (i >= j) {
        break;
      }

      swap(A, i, j);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void testBinaryArraySorting1() {
    int[] arr = {1, 0, 1, 1, 0};
    binSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testBinaryArraySorting2() {
    int[] arr = {1, 0, 1, 1, 1, 1, 1, 0, 0, 0};
    binSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testBinaryArraySorting3() {
    int[] arr = {1};
    binSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testBinaryArraySorting4() {
    int[] arr = {0};
    binSort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
