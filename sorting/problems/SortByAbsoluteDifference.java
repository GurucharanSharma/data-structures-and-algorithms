package sorting.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortByAbsoluteDifference {

  public static void main(String[] args) {
    testSortABS1();
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

  private static void testSortABS1() {
    Integer[] arr = {10, 5, 3, 9, 2};

    sortABS(Arrays.asList(arr), arr.length, 7);
    System.out.println(Arrays.toString(arr));

    sortABS(arr, arr.length, 7);
    System.out.println(Arrays.toString(arr));
  }
}
