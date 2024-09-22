package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanWithSameSumInBinaryArrays {

  public static void main(String[] args) {
    testLongestCommonSpan();
  }

  private static int longestCommonSpan(int[] arr, int[] brr) {
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
  }
}
