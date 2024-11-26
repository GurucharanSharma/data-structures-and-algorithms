package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {

  public static void main(String[] args) {
    System.out.println();
    testLongestSubArray();

    System.out.println();
    testLongestSubArray1();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static int longestSubArray(int[] arr, int sum) {
    int res = 0;

    for (int i = 0; i < arr.length; i++) {
      int subSum = 0;
      for (int j = i; j < arr.length; j++) {
        subSum += arr[j];

        if (subSum == sum) {
          res = Math.max(j - i + 1, res);
        }
      }
    }

    return res;
  }

  // Better Approach
  private static int longestSubArray2(int[] arr, int sum) {
    int currSum = 0;
    int index = 0;
    int maxLength = Integer.MIN_VALUE;

    int start = 0;
    int end = 0;

    for (int i = 0; i < arr.length; i++) {
      currSum += arr[i];
      while (index < i && currSum > sum) {
        currSum -= arr[index];
        index++;
      }

      if (currSum == sum && index != i) {
        int currLength = i - index + 1;
        if (currLength > maxLength) {
          maxLength = currLength;
          start = index;
          end = i;
        }
      }
    }

    System.out.println("From " + start + " to " + end);
    return maxLength;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static int longestSubArray1(int[] arr, int sum) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    int prefixSum = 0, res = 0;
    int start = 0, end = 0;

    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];

      if (prefixSum == sum) {
        res = i + 1;
      }

      if (hashMap.containsKey(prefixSum - sum)) {
        // We can use the below method in case start and end indexes are not required.
        // res = Math.max(res, i - hashMap.get(prefixSum - sum));

        // To capture the start and end indexes of this max sub array
        if (i - hashMap.get(prefixSum - sum) > res) {
          int index = hashMap.get(prefixSum - sum);
          res = i - index;
          start = index + 1;
          end = i;
        }
      } else {
        hashMap.put(prefixSum, i);
      }
    }

    System.out.println(start + " " + end);
    return res;
  }

  private static void testLongestSubArray() {
    int[] arr = {5, 2, 3};
    int sum = 5;

    System.out.println(longestSubArray(arr, sum));
    System.out.println();
    System.out.println(longestSubArray2(arr, sum));
    System.out.println();
    System.out.println(longestSubArray1(arr, sum));
  }

  private static void testLongestSubArray1() {
    int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
    int sum = 5;

    System.out.println(longestSubArray(arr, sum));
    System.out.println();
    System.out.println(longestSubArray2(arr, sum));
    System.out.println();
    System.out.println(longestSubArray1(arr, sum));
  }
}
