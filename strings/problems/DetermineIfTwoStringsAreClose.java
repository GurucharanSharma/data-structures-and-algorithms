package strings.problems;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {

  public static void main(String[] args) {
//    String word1 = "abc";
//    String word2 = "bca";

//    String word1 = "a";
//    String word2 = "aa";

    String word1 = "cabbba";
    String word2 = "abbccc";

    Solution solution = new Solution();
    System.out.println(solution.closeStrings(word1, word2));
  }

  static class Solution {

    public boolean closeStrings(String word1, String word2) {
      boolean[] word1Lookup = new boolean[26];
      boolean[] word2Lookup = new boolean[26];

      int[] word1Count = new int[26];
      int[] word2Count = new int[26];

      for (int i = 0; i < word1.length(); i++) {
        char ch = word1.charAt(i);
        word1Lookup[ch - 'a'] = true;
        word1Count[ch - 'a']++;
      }

      for (int i = 0; i < word2.length(); i++) {
        char ch = word2.charAt(i);
        word2Lookup[ch - 'a'] = true;
        word2Count[ch - 'a']++;
      }

      Arrays.sort(word1Count);
      Arrays.sort(word2Count);

      return Arrays.equals(word1Count, word2Count) && Arrays.equals(word1Lookup, word2Lookup);
    }
  }
}
