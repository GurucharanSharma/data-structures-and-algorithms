package strings.problems;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

  public static void main(String[] args) {
    String s = "leetcode";
    int k = 3;

    Solution solution = new Solution();
    System.out.println(solution.maxVowels(s, k));
  }

  static class Solution {

    public int maxVowels(String s, int k) {
      int currCount = 0;
      int maxCount = 0;

      for (int i = 0; i < s.length(); i++) {
        if (i < k) {
          currCount += (isVowel(s.charAt(i)) ? 1 : 0);
          maxCount = Math.max(maxCount, currCount);
        } else {
          currCount = currCount - (isVowel(s.charAt(i - k)) ? 1 : 0) + (isVowel(s.charAt(i)) ? 1 : 0);
          maxCount = Math.max(currCount, maxCount);
        }
      }

      return maxCount;
    }

    private boolean isVowel(char ch) {
      ch = Character.toLowerCase(ch);
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
  }
}
