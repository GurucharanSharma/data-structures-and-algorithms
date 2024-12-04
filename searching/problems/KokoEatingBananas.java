package searching.problems;

public class KokoEatingBananas {

  public static void main(String[] args) {
//    int[] piles = {3, 6, 7, 11};
//    int h = 8;

//    int[] piles = {30, 11, 23, 4, 20};
//    int h = 5;

    int[] piles = {30, 11, 23, 4, 20};
    int h = 6;

    Solution solution = new Solution();
    System.out.println(solution.minEatingSpeed(piles, h));
  }

  static class Solution {

    public int minEatingSpeed(int[] piles, int h) {
      int start = 1;
      int end = piles[0];

      for (int i = 0; i < piles.length; i++) {
        end = Math.max(end, piles[i]);
      }

      while (start < end) {
        int mid = start + (end - start) / 2;
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
          time += (piles[i] + mid - 1) / mid;
          // Alternatively, time += ((piles[i] / max) + (piles[i] % max > 0 ? 1 : 0));
        }

        if (time > h) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }

      return start;
    }
  }
}
