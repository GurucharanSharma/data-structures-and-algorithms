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

  private static void testSortABS1() {
    Integer[] arr = {10, 5, 3, 9, 2};
    sortABS(Arrays.asList(arr), arr.length, 7);
    System.out.println(Arrays.toString(arr));
  }
}
