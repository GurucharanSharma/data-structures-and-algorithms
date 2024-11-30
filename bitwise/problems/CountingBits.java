package bitwise.problems;

import java.util.Arrays;

public class CountingBits {

  public static void main(String[] args) {
//    int n = 2;
    int n = 5;

    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.countBits(n)));

    Solution1 solution1 = new Solution1();
    System.out.println(Arrays.toString(solution1.countBits(n)));
  }

  static class Solution1 {

    public int[] countBits(int n) {
      int[] ans = new int[n + 1];
      for (int i = 0; i < n + 1; i++) {
        if (i % 2 == 0) {
          ans[i] = ans[i / 2];
        } else {
          ans[i] = ans[i - 1] + 1;
        }
      }
      return ans;
    }
  }

  static class Solution {

    public int[] countBits(int n) {
      int[] result = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        result[i] = getBitCount(i);
      }

      return result;
    }

    private int getBitCount(int num) {
      int count = 0;

      while (num > 0) {
        if ((num & 1) == 1) {
          count++;
        }

        num = num >> 1;
      }

      return count;
    }
  }
}
