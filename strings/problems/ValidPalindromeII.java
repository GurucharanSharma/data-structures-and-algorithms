package strings.problems;

public class ValidPalindromeII {

  public static void main(String[] args) {
    String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

    Solution solution = new Solution();
    System.out.println(solution.validPalindrome(str));
  }

  static class Solution {

    public boolean validPalindrome(String s) {
      int i = 0;
      int j = s.length() - 1;

      while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
          return checkPalindrome(s.substring(i, j)) || checkPalindrome(s.substring(i + 1, j + 1));
        }

        i++;
        j--;
      }

      return true;
    }

    public boolean checkPalindrome(String s) {
      int i = 0;
      int j = s.length() - 1;

      while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
          return false;
        }

        i++;
        j--;
      }

      return true;
    }
  }
}
