package array.problems;

/**
 * <a href="https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">334. Increasing
 * Triplet Subsequence</a>
 */
public class IncreasingTripletSubsequence {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5};
//    int[] arr = {5, 4, 3, 2, 1};
//    int[] arr = {2, 1, 5, 0, 4, 6};
    int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1};

    Solution solution = new Solution();
    System.out.println(solution.increasingTriplet(arr));

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.increasingTriplet(arr));

    Solution2 solution2 = new Solution2();
    System.out.println(solution2.increasingTriplet(arr));

    Solution3 solution3 = new Solution3();
    System.out.println(solution3.increasingTriplet(arr));
  }

  static class Solution3 {

    public boolean increasingTriplet(int[] nums) {
      int first = Integer.MAX_VALUE;
      int second = Integer.MAX_VALUE;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= first) {
          first = nums[i];
        } else if (nums[i] <= second) {
          second = nums[i];
        } else {
          return true;
        }
      }

      return false;
    }
  }

  static class Solution2 {

    public boolean increasingTriplet(int[] nums) {

      int[] rightMax = new int[nums.length];
      rightMax[nums.length - 1] = nums[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
      }

      int leftMin = nums[0];
      for (int i = 1; i < nums.length - 1; i++) {
        if (leftMin < nums[i] && rightMax[i] > nums[i]) {
          return true;
        }

        leftMin = Math.min(leftMin, nums[i]);
      }

      return false;
    }
  }

  static class Solution1 {

    public boolean increasingTriplet(int[] nums) {
      int[] leftMin = new int[nums.length];
      leftMin[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
      }

      int[] rightMax = new int[nums.length];
      rightMax[nums.length - 1] = nums[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
      }

      for (int i = 1; i < nums.length - 1; i++) {
        if (leftMin[i] < nums[i] && rightMax[i] > nums[i]) {
          return true;
        }
      }

      return false;
    }
  }

  static class Solution {

    public boolean increasingTriplet(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          for (int k = j + 1; k < nums.length; k++) {
            if (nums[k] > nums[j] && nums[j] > nums[i]) {
              return true;
            }
          }
        }
      }

      return false;
    }
  }
}
