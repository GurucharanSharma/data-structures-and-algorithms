package array.problems;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75">11. Container With Most
 * Water</a>
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
//    int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int[] arr = {1, 1};

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.maxArea(arr));
  }

  static class Solution1 {

    public int maxArea(int[] height) {
      int i = 0;
      int j = height.length - 1;
      int maxCapacity = Integer.MIN_VALUE;

      while (i < j) {
        int minHeight = Math.min(height[i], height[j]);
        int currCapacity = minHeight * (j - i);
        maxCapacity = Math.max(maxCapacity, currCapacity);

        if (height[i] < height[j]) {
          i++;
        } else if (height[i] > height[j]) {
          j--;
        } else {
          i++;
          j--;
        }
      }

      return maxCapacity;
    }
  }
}
