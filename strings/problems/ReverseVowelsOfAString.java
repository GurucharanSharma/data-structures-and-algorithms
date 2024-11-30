package strings.problems;

public class ReverseVowelsOfAString {

  public static void main(String[] args) {
    String str = "IceCreAm";
//    String str = "leetcode";

    Solution solution = new Solution();
    System.out.println(solution.reverseVowels(str));

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.reverseVowels(str));
  }

  static class Solution1 {

    public String reverseVowels(String s) {
      char[] strArr = s.toCharArray();
      char[] vowArr = new char[s.length()];
      int index = 0;
      for (int i = 0; i < strArr.length; i++) {
        if (isVowel(strArr[i])) {
          vowArr[index] = strArr[i];
          index++;
        }
      }

      reverse(vowArr, 0, index - 1);
      index = 0;

      for (int i = 0; i < strArr.length; i++) {
        if (isVowel(strArr[i])) {
          strArr[i] = vowArr[index++];
        }
      }

      return String.valueOf(strArr);
    }

    private void reverse(char[] arr, int start, int end) {
      while (start < end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
      }
    }

    private boolean isVowel(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
  }

  static class Solution {

    public String reverseVowels(String s) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (isVowel(ch)) {
          builder.append(ch);
        }
      }

      char[] strArr = s.toCharArray();
      char[] vowelArr = builder.reverse().toString().toCharArray();
      int index = 0;

      for (int i = 0; i < strArr.length; i++) {
        if (isVowel(strArr[i])) {
          strArr[i] = vowelArr[index];
          index++;
        }
      }

      return String.valueOf(strArr);
    }

    private boolean isVowel(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
  }
}
