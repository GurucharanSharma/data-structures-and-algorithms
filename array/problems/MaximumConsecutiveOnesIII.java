package array.problems;

public class MaximumConsecutiveOnesIII {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    int k = 2;

    Solution solution = new Solution();
    System.out.println(solution.longestOnes(nums, k));
  }

  static class Solution {

    public int longestOnes(int[] nums, int k) {
      int start = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          k--;
        }

        if (k < 0) {
          if (nums[start] == 0) {
            k++;
          }

          start++;
        }
      }

      return nums.length - start;
    }
  }
}
