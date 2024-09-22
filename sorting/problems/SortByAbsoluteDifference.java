package sorting.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortByAbsoluteDifference {

  public static void main(String[] args) {
    testSortABS1();
    testSortABS2();
  }

  //Function to sort the array according to difference with given number.
  static void sortABS(List<Integer> arr, int n, int k) {
    // add your code here
    //Comparing integers based on their absolute difference with the given number.
    arr.sort(Comparator.comparingInt(x -> Math.abs(x - k)));
  }

  static void sortABS(Integer[] arr, int n, int x) {
    // Below lines are similar to insertion sort
    for (int i = 1; i < n; i++) {
      int diff = Math.abs(arr[i] - x);

      // Insert arr[i] at correct place
      int j = i - 1;
      if (Math.abs(arr[j] - x) > diff) {
        int temp = arr[i];
        while (j >= 0 && Math.abs(arr[j] - x) > diff) {
          arr[j + 1] = arr[j];
          j--;
        }

        arr[j + 1] = temp;
      }
    }
  }

  static void sortABS(int k, int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      sortABS(k, arr, start, mid);
      sortABS(k, arr, mid + 1, end);
      merge(arr, start, mid, end, k);
    }
  }

  static void merge(int[] arr, int start, int mid, int end, int k) {
    int m = mid - start + 1;
    int n = end - mid;

    int[] left = new int[m];
    int[] right = new int[n];

    for (int i = 0; i < m; i++) {
      left[i] = arr[start + i];
    }

    for (int i = 0; i < n; i++) {
      right[i] = arr[start + m + i];
    }

    int i = 0;
    int j = 0;
    int index = start;
    while (i < m && j < n) {
      if (Math.abs(left[i] - k) <= Math.abs(right[j] - k)) {
        arr[index++] = left[i++];
      } else {
        arr[index++] = right[j++];
      }
    }

    while (i < m) {
      arr[index++] = left[i++];
    }

    while (j < n) {
      arr[index++] = right[j++];
    }
  }

  private static void testSortABS1() {
    Integer[] arr = {10, 5, 3, 9, 2};

    sortABS(Arrays.asList(arr), arr.length, 7);
    System.out.println(Arrays.toString(arr));

    sortABS(arr, arr.length, 7);
    System.out.println(Arrays.toString(arr));
  }

  private static void testSortABS2() {
    int[] arr = {10, 5, 3, 9, 2};
    int k = 7;

    sortABS(k, arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
