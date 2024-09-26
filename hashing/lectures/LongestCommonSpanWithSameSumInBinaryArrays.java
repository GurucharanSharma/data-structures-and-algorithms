package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanWithSameSumInBinaryArrays {

  public static void main(String[] args) {
    testLongestCommonSpan();
  }

  /**
   * Naive approach
   * <p>
   * Time Complexity: O(n<sup>2</sup>)
   * <p>
   * Space Complexity: O(1)
   */
  private static int longestCommonSpan(int[] arr, int[] brr) {
    if (arr.length != brr.length) {
      System.out.println("Both the arrays must be of equal length!");
      return -1;
    }

    int n = arr.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      int aSum = 0;
      int bSum = 0;

      for (int j = i; j < n; j++) {
        aSum += arr[j];
        bSum += brr[j];

        if (aSum == bSum) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  /**
   * Efficient approach
   * <p>
   * Time Complexity: O(n)
   * <p>
   * Space Complexity: O(n)
   */
  private static int longestCommonSpan1(int[] arr, int[] brr) {
    if (arr.length != brr.length) {
      System.out.println("Both the arrays must be of equal length!");
      return -1;
    }

    int[] temp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i] - brr[i];
    }

    Map<Integer, Integer> hashMap = new HashMap<>();
    int prefixSum = 0, res = 0;

    for (int i = 0; i < temp.length; i++) {
      prefixSum += temp[i];

      if (prefixSum == 0) {
        res = i + 1;
      }

      if (!hashMap.containsKey(prefixSum)) {
        hashMap.put(prefixSum, i);
      }

      if (hashMap.containsKey(prefixSum)) {
        res = Math.max(res, i - hashMap.get(prefixSum));
      }
    }

    return res;
  }

  private static void testLongestCommonSpan() {
    int[] arr = {0, 1, 0, 0, 0, 0};
    int[] brr = {1, 0, 1, 0, 0, 1};

    System.out.println(longestCommonSpan(arr, brr));
    System.out.println(longestCommonSpan1(arr, brr));
  }
}
