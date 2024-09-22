package hashing.lectures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the
 * consecutive numbers can be in any order.
 */
public class LongestConsecutiveSubsequence {

  public static void main(String[] args) {
    testLongestSubsequence();
  }

  /**
   * Time Complexity: O(n * log(n)) <br> Auxiliary Space: O(1)
   */
  private static int longestSubsequence(int[] arr) {
    Arrays.sort(arr);
    int res = 1, curr = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == (arr[i - 1] + 1)) {
        curr++;
      } else {
        res = Math.max(res, curr);
        curr = 1;
      }
    }

    return Math.max(res, curr);
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n) <br> <b>NOTE:</b> There are always 2n look ups at most
   */
  private static int longestSubsequence1(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      set.add(i);
    }

    int res = 1;
    for (Integer i : set) {
      if (!set.contains(i - 1)) {
        int curr = 0;
        while (set.contains(i + curr)) {
          curr++;
        }

        res = Math.max(res, curr);
      }
    }

    return res;
  }

  private static void testLongestSubsequence() {
    int[] arr = {2, 9, 4, 3, 10};
    System.out.println(longestSubsequence(arr));
    System.out.println(longestSubsequence1(arr));
  }
}
