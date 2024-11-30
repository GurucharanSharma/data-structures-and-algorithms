package array.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75">238. Product of Array
 * Except Self</a>
 */
public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
//    int[] nums = {-1, 1, 0, -3, 3};
//    int[] nums = {0, 0};
//    int[] nums = {0, 4, 0};

    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.productExceptSelf(nums)));

    Solution1 solution1 = new Solution1();
    System.out.println(Arrays.toString(solution1.productExceptSelf(nums)));

    Solution2 solution2 = new Solution2();
    System.out.println(Arrays.toString(solution2.productExceptSelf(nums)));
  }

  static class Solution2 {

    public int[] productExceptSelf(int[] nums) {
      int[] answer = new int[nums.length];

      answer[0] = 1;
      for (int i = 1; i < nums.length; i++) {
        answer[i] = nums[i - 1] * answer[i - 1];
      }

      int suffixMul = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
        answer[i] = answer[i] * suffixMul;
        suffixMul = suffixMul * nums[i];
      }

      return answer;
    }
  }

  static class Solution1 {

    public int[] productExceptSelf(int[] nums) {
      int[] prefixMul = new int[nums.length];
      prefixMul[0] = 1;
      for (int i = 1; i < nums.length; i++) {
        prefixMul[i] = nums[i - 1] * prefixMul[i - 1];
      }

      int[] suffixMul = new int[nums.length];
      suffixMul[nums.length - 1] = 1;
      for (int i = nums.length - 2; i >= 0; i--) {
        suffixMul[i] = nums[i + 1] * suffixMul[i + 1];
      }

      int[] answer = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        answer[i] = prefixMul[i] * suffixMul[i];
      }

      return answer;
    }
  }

  static class Solution {

    public int[] productExceptSelf(int[] nums) {
      int[] prefixMul = new int[nums.length];
      prefixMul[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        prefixMul[i] = nums[i] * prefixMul[i - 1];
      }

      int[] suffixMul = new int[nums.length];
      suffixMul[nums.length - 1] = nums[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        suffixMul[i] = nums[i] * suffixMul[i + 1];
      }

      int[] answer = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        if (i == 0) {
          answer[i] = suffixMul[i + 1];
        } else if (i == nums.length - 1) {
          answer[i] = prefixMul[i - 1];
        } else {
          answer[i] = prefixMul[i - 1] * suffixMul[i + 1];
        }
      }

      return answer;
    }
  }
}
