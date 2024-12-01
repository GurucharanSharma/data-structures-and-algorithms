package array.problems;

import java.util.Arrays;

public class RightRotateArray {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;

    Solution solution = new Solution();
    solution.rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }

  static class Solution {

    public void rotate(int[] nums, int k) {
      k = k % nums.length;
      int d = nums.length - k - 1;

      if (d >= 0) {
        rotate(nums, 0, d);
        rotate(nums, d + 1, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
      }

    }

    private void rotate(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        start++;
        end--;
      }
    }

  }
}
