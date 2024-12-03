package array.problems;

public class CanPlaceFlowers {

  public static void main(String[] args) {
    int[] flowerbed = {0, 1, 0};
    int n = 2;

    Solution solution = new Solution();
    System.out.println(solution.canPlaceFlowers(flowerbed, n));
  }

  static class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      int count = 0;
      for (int i = 0; i < flowerbed.length; ) {
        if (flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {
          count++;
          i = i + 2;
        } else {
          i = i + 1;
        }
      }

      return count >= n;
    }
  }

}
