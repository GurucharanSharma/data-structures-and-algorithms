package sorting.problems;

import java.util.Arrays;

public class MinimumPlatforms {

  public static void main(String[] args) {
    testFindPlatform1();
    testFindPlatform2();
  }

  //Function to find the minimum number of platforms required at the
  //railway station such that no train waits.
  private static int findPlatform(int[] arr, int[] dep, int n) {
    // add your code here
    Arrays.sort(arr);
    Arrays.sort(dep);

    int i = 0, j = 0;
    int platforms = 0;
    int result = 0;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        platforms++;
        i++;
      } else {
        platforms--;
        j++;
      }

      result = Math.max(result, platforms);
    }

    return result;
  }

  private static void testFindPlatform1() {
    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

    System.out.println(findPlatform(arr, dep, arr.length));
  }

  private static void testFindPlatform2() {
    int[] arr = {900, 1100, 1235};
    int[] dep = {1000, 1200, 1240};

    System.out.println(findPlatform(arr, dep, arr.length));
  }
}
