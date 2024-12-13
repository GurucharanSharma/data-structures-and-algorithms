package strings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

  public static void main(String[] args) {
    String str = "cbaebabacd";
    String pat = "abc";

    Solution solution = new Solution();
    System.out.println(solution.findAnagrams(str, pat));
  }

  static class Solution {

    public List<Integer> findAnagrams(String s, String p) {
      List<Integer> list = new ArrayList<>();

      int[] cS = new int[26];
      int[] cP = new int[26];

      for (int i = 0; i < p.length(); i++) {
        cS[s.charAt(i) - 'a']++;
        cP[p.charAt(i) - 'a']++;
      }

      for (int i = p.length(); i < s.length(); i++) {
        if (Arrays.equals(cS, cP)) {
          list.add(i - p.length());
        }

        cS[s.charAt(i - p.length()) - 'a']--;
        cS[s.charAt(i) - 'a']++;
      }

      if (Arrays.equals(cS, cP)) {
        list.add(s.length() - p.length());
      }

      return list;
    }
  }
}
