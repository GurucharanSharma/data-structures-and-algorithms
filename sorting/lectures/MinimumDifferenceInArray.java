package sorting.lectures;

import java.util.Arrays;

/**
 * Find minimum difference between any two elements (pair) in given array
 */
public class MinimumDifferenceInArray {

  public static void main(String[] args) {
    int[] arr = {10, 8, 1, 4};
    System.out.println(getMinDiffNaive(arr));
    System.out.println(getMinDiffOptimised(arr));
    System.out.println();

    int[] arr1 = {10, 3, 20, 12};
    System.out.println(getMinDiffNaive(arr1));
    System.out.println(getMinDiffOptimised(arr1));
    System.out.println();

    int[] arr2 = {5, 3, 8};
    System.out.println(getMinDiffNaive(arr2));
    System.out.println(getMinDiffOptimised(arr2));
    System.out.println();

    int[] arr3 = {1, 8, 12, 5, 18};
    System.out.println(getMinDiffNaive(arr3));
    System.out.println(getMinDiffOptimised(arr3));
    System.out.println();

    int[] arr4 = {8, 15};
    System.out.println(getMinDiffNaive(arr4));
    System.out.println(getMinDiffOptimised(arr4));
    System.out.println();

    int[] arr5 = {8, -1, 0, 3};
    System.out.println(getMinDiffNaive(arr5));
    System.out.println(getMinDiffOptimised(arr5));
    System.out.println();

    int[] arr6 = {10};
    System.out.println(getMinDiffNaive(arr6));
    System.out.println(getMinDiffOptimised(arr6));
    System.out.println();
  }

  private static int getMinDiffNaive(int[] arr) {
    int res = Integer.MAX_VALUE;

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        res = Math.min(res, Math.abs(arr[i] - arr[j]));
      }
    }

    return res;
  }

  private static int getMinDiffOptimised(int[] arr) {
    Arrays.sort(arr);

    int res = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      res = Math.min(res, Math.abs(arr[i] - arr[i - 1]));
    }

    return res;
  }
}
