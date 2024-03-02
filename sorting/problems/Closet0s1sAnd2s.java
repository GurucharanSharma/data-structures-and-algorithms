package sorting.problems;

import java.util.Arrays;

public class Closet0s1sAnd2s {

  public static void main(String[] args) {
    testSegragate0121();
    testSegragate0122();
  }

  // The function should do the stated modifications in the given array arr[]
  // Do not return anything.

  // arr[]: Input Array
  // N: Size of the Array arr[]
  //Function to segregate 0s, 1s and 2s in sorted increasing order.
  private static void segragate012(int[] arr, int N) {
    // Your Code Here
    int start = 0;
    int mid = 0;
    int end = N - 1;

    while (mid <= end) {
      if (arr[mid] == 0) {
        swap(arr, start, mid);
        start++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, end);
        end--;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void testSegragate0121() {
    int[] arr = {0, 2, 1, 2, 0};
    segragate012(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void testSegragate0122() {
    int[] arr = {0, 1, 0};
    segragate012(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
