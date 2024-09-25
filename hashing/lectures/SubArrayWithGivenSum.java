package hashing.lectures;

import java.util.HashSet;

public class SubArrayWithGivenSum {

  public static void main(String[] args) {
    testIsSum();
    System.out.println();

    testIsSum1();
    System.out.println();

    testIsSum2();
    System.out.println();

  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static boolean isSum(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      int prefixSum = 0;
      for (int j = i; j < arr.length; j++) {
        prefixSum += arr[j];

        if (prefixSum == sum) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static boolean isSum1(int[] arr, int sum) {
    HashSet<Integer> hashSet = new HashSet<>();
    int prefixSum = 0;

    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];

      if (hashSet.contains(prefixSum - sum) || prefixSum == sum) {
        return true;
      } else {
        hashSet.add(prefixSum);
      }
    }

    return false;
  }

  private static void testIsSum() {
    int[] arr = {-3, 4, -3, -1, 1};

    System.out.println(isSum(arr, -4));
    System.out.println(isSum1(arr, -4));
  }

  private static void testIsSum1() {
    int[] arr = {5, 3, 2, -1};

    System.out.println(isSum(arr, 4));
    System.out.println(isSum1(arr, 4));
  }

  private static void testIsSum2() {
    int[] arr = {2, 3, 4, 6};

    System.out.println(isSum(arr, 9));
    System.out.println(isSum1(arr, 9));
  }
}
