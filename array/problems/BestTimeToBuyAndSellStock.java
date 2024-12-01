package array.problems;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};

    Solution solution = new Solution();
    System.out.println(solution.maxProfit(prices));
  }

  static class Solution {

    public int maxProfit(int[] prices) {
      int[] leftMin = new int[prices.length];
      leftMin[0] = prices[0];
      for (int i = 1; i < prices.length; i++) {
        leftMin[i] = Math.min(leftMin[i - 1], prices[i]);
      }

      int[] rightMax = new int[prices.length];
      rightMax[prices.length - 1] = prices[prices.length - 1];
      for (int i = prices.length - 2; i >= 0; i--) {
        rightMax[i] = Math.max(prices[i], rightMax[i + 1]);
      }

      System.out.println(Arrays.toString(leftMin));
      System.out.println(Arrays.toString(rightMax));

      int maxProfit = 0;
      int i = 0;
      int j = 0;

      while (i < leftMin.length && j < rightMax.length) {
        if (leftMin[i] >= rightMax[j]) {
          i++;
          j++;
        } else {
          maxProfit = Math.max(maxProfit, (rightMax[j] - leftMin[i]));
          j++;
        }
      }

      return maxProfit;
    }
  }
}
