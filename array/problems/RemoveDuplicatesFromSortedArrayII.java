package array.problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};

    Solution solution = new Solution();
    System.out.println(solution.removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }

  static class Solution {

    public int removeDuplicates(int[] nums) {
      int index = 1;
      int count = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i - 1]) {
          count++;
        } else {
          count = 1;
        }

        if (count <= 2) {
          nums[index] = nums[i];
          index++;
        }
      }

      return index;
    }
  }
}
