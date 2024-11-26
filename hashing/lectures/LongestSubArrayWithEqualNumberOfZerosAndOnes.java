package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqualNumberOfZerosAndOnes {

  public static void main(String[] args) {
    testMaxLength();
    System.out.println();
    testMaxLength1();
    System.out.println();
    testMaxLength2();
    System.out.println();
    testMaxLength3();
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

      if (hashMap.containsKey(prefixSum)) {
        res = Math.max(res, i - hashMap.get(prefixSum));
      } else {
        hashMap.put(prefixSum, i);
      }
    }

    return res;
  }

  private static int maxLength1(int[] arr) {
    int maxLength = 0;

    for (int i = 0; i < arr.length; i++) {
      int zeroCount = 0;
      int oneCount = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] == 0) {
          zeroCount++;
        } else if (arr[j] == 1) {
          oneCount++;
        }

        if (zeroCount == oneCount) {
          maxLength = Math.max(maxLength, j - i + 1);
        }
      }
    }

    return maxLength;
  }

  private static void testMaxLength() {
    int[] arr = {1, 1, 1, 0, 1, 0};

    System.out.println(maxLength1(arr));
    System.out.println(maxLength(arr));
  }

  private static void testMaxLength1() {
    int[] arr = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1};

    System.out.println(maxLength1(arr));
    System.out.println(maxLength(arr));
  }

  private static void testMaxLength2() {
    int[] arr = {1, 1, 1, 0, 0, 1, 1, 1, 1, 0};

    System.out.println(maxLength1(arr));
    System.out.println(maxLength(arr));
  }

  private static void testMaxLength3() {
    int[] arr = {0, 1, 1, 0, 1, 0, 0, 1};

    System.out.println(maxLength1(arr));
    System.out.println(maxLength(arr));
  }
}
