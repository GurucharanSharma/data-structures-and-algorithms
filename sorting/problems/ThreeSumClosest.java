package sorting.problems;

import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;

    Solution solution = new Solution();
    System.out.println(solution.threeSumClosest(nums, target));
  }

  static class Solution {

    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int result = Integer.MAX_VALUE;

      for (int i = 0; i < nums.length; i++) {
        int j = i + 1;
        int k = nums.length - 1;
        int sum = target - nums[i];

        while (j < k) {
          if (Math.abs(target - result) > Math.abs(target - (nums[i] + nums[j] + nums[k]))) {
            result = nums[i] + nums[j] + nums[k];
          }

          if (nums[j] + nums[k] < sum) {
            j++;
          } else {
            k--;
          }
        }
      }

      return result;
    }
  }
}
