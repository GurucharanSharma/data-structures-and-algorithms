package sorting.problems;

import java.util.Arrays;

public class TripletsWithZeroSum {

  public static void main(String[] args) {
//    testTripletsWithZeroSum1();
//    testTripletsWithZeroSum2();
    testTripletsWithZeroSum3();
  }

  // arr[]: input array
  // n: size of the array
  //Function to find triplets with zero sum.
  private static boolean findTriplets(int[] arr, int n) {
    Arrays.sort(arr);

    //add code here.
    for (int i = 0; i < n; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }

      int j = i + 1;
      int k = n - 1;

      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          return true;
        }
      }
    }

    return false;
  }

  private static void testTripletsWithZeroSum1() {
    int[] arr = {0, -1, 2, -3, 1};
    System.out.println(findTriplets(arr, arr.length));
  }

  private static void testTripletsWithZeroSum2() {
    int[] arr = {1, 2, 3};
    System.out.println(findTriplets(arr, arr.length));
  }

  private static void testTripletsWithZeroSum3() {
    int[] arr = {60, -65, 5, -21, 8, 93};
    System.out.println(findTriplets(arr, arr.length));
  }
}
