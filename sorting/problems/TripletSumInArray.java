package sorting.problems;

import java.util.Arrays;

public class TripletSumInArray {

  public static void main(String[] args) {
    testFind3Numbers();
    testFind3Numbers1();
    testFind3Numbers2();
  }

  //Function to find if there exists a triplet in the
  //array A[] which sums up to X.
  private static boolean find3Numbers(int[] A, int n, int X) {
    Arrays.sort(A);

    // Your code Here
    for (int i = 0; i < n; i++) {
      int j = i + 1;
      int k = n - 1;

      while (j < k) {
        int sum = A[i] + A[j] + A[k];
        if (sum < X) {
          j++;
        } else if (sum > X) {
          k--;
        } else {
          return true;
        }
      }
    }

    return false;
  }

  // Should return true if there is a triplet with sum equal
  // to x in arr[], otherwise false
  public static boolean find3Numbers1(int[] arr, int n, int x) {
    Arrays.sort(arr);

    for (int i = 0; i < n - 1; i++) {
      if (isPairPossible(arr, n, x - arr[i], i + 1)) {
        return true;
      }
    }

    return false;
  }

  static boolean isPairPossible(int[] arr, int n, int x, int i) {
    int j = n - 1;

    while (i < j) {
      if (arr[i] + arr[j] == x) {
        return true;
      } else if (arr[i] + arr[j] < x) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

  private static void testFind3Numbers() {
    int[] arr = {1, 4, 45, 6, 10, 8};
    System.out.println(find3Numbers(arr, arr.length, 13));
  }

  private static void testFind3Numbers1() {
    int[] arr = {1, 2, 4, 3, 6};
    System.out.println(find3Numbers(arr, arr.length, 13));
  }

  private static void testFind3Numbers2() {
    int[] arr = {1, 2, 4, 3, 6};
    System.out.println(find3Numbers(arr, arr.length, 10));
  }
}
