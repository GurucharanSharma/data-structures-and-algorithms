package array.problems;

public class MaximumPointsFromCards {

  public static void main(String[] args) {
    int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
    int k = 3;

    Solution solution = new Solution();
    System.out.println(solution.maxScore(cardPoints, k));
  }

  static class Solution {

    public int maxScore(int[] cardPoints, int k) {
      int currSum = 0;
      for (int i = 0; i < k; i++) {
        currSum += cardPoints[i];
      }

      int result = currSum;
      int j = cardPoints.length - 1;
      for (int i = k - 1; i >= 0; i--) {
        currSum = currSum - cardPoints[i] + cardPoints[j--];
        result = Math.max(currSum, result);
      }

      return result;
    }
  }
}
