package strings.problems;

/**
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75">1071. Greatest
 * Common Divisor of Strings</a>
 */
public class GreatestCommonDivisorOfStrings {

  public static void main(String[] args) {
    String str1 = "LEET";
    String str2 = "CODE";

    Solution solution = new Solution();
    System.out.println(solution.gcdOfStrings(str1, str2));
  }

  static class Solution {

    public String gcdOfStrings(String str1, String str2) {
      if (str1.length() < str2.length()) {
        return gcdOfStrings(str2, str1);
      }

      if (str1.equals(str2)) {
        return str1;
      }

      if (str1.startsWith(str2)) {
        return gcdOfStrings(str1.substring(str2.length()), str2);
      }

      return "";
    }
  }
}
