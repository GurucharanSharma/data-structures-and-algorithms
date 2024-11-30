package strings.problems;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75">151. Reverse Words in a
 * String</a>
 */
public class ReverseWordsInAString {

  public static void main(String[] args) {
//    String str = "the sky is blue";
//    String str = "  hello world  ";
    String str = "a good   example";

    Solution solution = new Solution();
    System.out.println(solution.reverseWords(str));

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.reverseWords(str));

    Solution2 solution2 = new Solution2();
    System.out.println(solution2.reverseWords(str));
  }

  static class Solution2 {

    public String reverseWords(String s) {
      // Trim the input string to remove leading and trailing spaces
      String[] str = s.trim().split("\\s+");

      // Initialize the output string
      StringBuilder builder = new StringBuilder();

      // Iterate through the words in reverse order
      for (int i = str.length - 1; i > 0; i--) {
        // Append the current word and a space to the output
        builder.append(str[i]).append(" ");
      }

      // Append the first word to the output (without trailing space)
      return builder.append(str[0]).toString();
    }
  }

  static class Solution1 {

    public String reverseWords(String s) {
      int start = 0;
      s = s.replaceAll(" +", " ");
      char[] strArr = s.trim().toCharArray();

      for (int i = 0; i < strArr.length; i++) {
        if (strArr[i] == ' ') {
          reverse(strArr, start, i - 1);
          start = i + 1;
        }
      }

      reverse(strArr, start, strArr.length - 1);
      reverse(strArr, 0, strArr.length - 1);

      return String.valueOf(strArr);
    }

    private void reverse(char[] charArr, int start, int end) {
      while (start < end) {
        char temp = charArr[start];
        charArr[start] = charArr[end];
        charArr[end] = temp;

        start++;
        end--;
      }
    }
  }

  static class Solution {

    public String reverseWords(String s) {
      int start = 0;
      char[] strArr = s.trim().toCharArray();
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < strArr.length; i++) {
        if (strArr[i] == ' ') {
          String str = reverse(strArr, start, i - 1);
          if (!str.trim().isEmpty()) {
            builder.append(str).append(" ");
          }

          start = i + 1;
        }
      }

      String str = reverse(strArr, start, strArr.length - 1);
      builder.append(str);
      builder.reverse();

      return builder.toString();
    }

    private String reverse(char[] charArr, int start, int end) {
      int s = start;
      int e = end;

      while (start < end) {
        char temp = charArr[start];
        charArr[start] = charArr[end];
        charArr[end] = temp;

        start++;
        end--;
      }

      return String.valueOf(charArr).substring(s, e + 1);
    }
  }
}
