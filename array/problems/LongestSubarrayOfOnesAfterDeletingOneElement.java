package array.problems;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

  public static void main(String[] args) {
//    int[] nums = {1, 1, 0, 1};
//    int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
    int[] nums = {1, 1, 1};

    Solution solution = new Solution();
    System.out.println(solution.longestSubarray(nums));
  }

  static class Solution {

    public int longestSubarray(int[] nums) {
      int zeros = 1;
      int start = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          zeros--;
        }

        if (zeros < 0) {
          if (nums[start] == 0) {
            zeros++;

          }

          start++;
        }
      }

      return nums.length - start - 1;
    }
  }
}
