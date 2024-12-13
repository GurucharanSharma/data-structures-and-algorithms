package strings.problems;

import java.util.Arrays;

public class NumberOfSubstringsContainingAll3Characters {

  public static void main(String[] args) {
//    String str = "abcabc";
//    String str = "aaacb";
    String str = "abc";

    Solution solution = new Solution();
    System.out.println(solution.numberOfSubstrings(str));
    System.out.println();
    System.out.println(solution.numberOfSubstrings1(str));
    System.out.println();
    System.out.println(solution.numberOfSubstrings2(str));
  }

  static class Solution {

    public int numberOfSubstrings2(String s) {
      int count = 0;
      int[] hash = new int[26];
      Arrays.fill(hash, -1);

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        hash[ch - 'a'] = i;

        int index = Math.min(Math.min(hash[0], hash[1]), hash[2]);
        if (index != -1) {
          count += index + 1;
        }
      }

      return count;
    }

    public int numberOfSubstrings1(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        int[] hash = new int[26];
        for (int j = i; j < s.length(); j++) {
          hash[s.charAt(j) - 'a'] = 1;
          if (hash[0] + hash[1] + hash[2] == 3) {
            count += (s.length() - j);
            break;
          }
        }
      }

      return count;
    }

    public int numberOfSubstrings(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
          String substring = s.substring(i, j + 1);
          if (isValid(substring)) {
            count++;
          }
        }
      }

      return count;
    }

    private boolean isValid(String str) {
      return (str.contains("a") && str.contains("b") && str.contains("c"));
    }
  }
}
