package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  public static void main(String[] args) {
    String str = "aabb";

    Solution solution = new Solution();
    System.out.println(solution.partition(str));
  }

  static class Solution {

    public List<List<String>> partition(String str) {
      List<List<String>> result = new ArrayList<>();
      partition(str, result, new ArrayList<>(), 0);

      return result;
    }

    private void partition(String str, List<List<String>> result, List<String> list, int index) {
      if (index == str.length()) {
        result.add(new ArrayList<>(list));
        return;
      }

      for (int i = index; i < str.length(); i++) {
        if (isPalindrome(str, index, i)) {
          list.add(str.substring(index, i + 1));
          partition(str, result, list, i + 1);
          list.remove(list.size() - 1);
        }
      }
    }

    private boolean isPalindrome(String str, int start, int end) {
      while (start <= end) {
        if (str.charAt(start) != str.charAt(end)) {
          return false;
        }

        start++;
        end--;
      }

      return true;
    }
  }
}
