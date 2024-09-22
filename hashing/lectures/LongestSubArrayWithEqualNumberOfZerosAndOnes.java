package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqualNumberOfZerosAndOnes {

  public static void main(String[] args) {
    testMaxLength();
  }

  private static int maxLength(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        arr[i] = -1;
      }
    }

    Map<Integer, Integer> hashMap = new HashMap<>();
    int prefixSum = 0, res = 0;

    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];

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

  private static void testMaxLength() {
    int[] arr = {1, 1, 1, 0, 1, 0};
    System.out.println(maxLength(arr));
  }
}
