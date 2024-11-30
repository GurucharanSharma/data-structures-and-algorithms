package array.problems;

/**
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75">643. Maximum Average
 * Subarray I</a>
 */
public class MaximumAverageSubarrayI {

  public static void main(String[] args) {
    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;

//    int[] nums = {0, 1, 1, 3, 3};
//    int k = 4;

    Solution solution = new Solution();
    System.out.println(solution.findMaxAverage(nums, k));
  }

  static class Solution {

    public double findMaxAverage(int[] nums, int k) {
      int currSum = 0;
      double maxAverage = Double.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
        if (i < k) {
          currSum += nums[i];
          maxAverage = (currSum / (double) k);
        } else {
          maxAverage = Math.max(maxAverage, (currSum / (double) k));
          currSum = currSum - nums[i - k] + nums[i];
        }
      }

      return Math.max(maxAverage, (currSum / (double) k));
    }
  }
}
