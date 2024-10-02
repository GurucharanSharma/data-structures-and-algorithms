package recursion.lectures;

public class Palindrome {

  public static void main(String[] args) {
        String str = "abba";
//        String str = "";
//    String str = "abbas";

    System.out.println(checkPalindrome(str, 0, str.length() - 1));
    System.out.println(checkPalindrome1(str, 0, str.length() - 1));
  }

  private static boolean checkPalindrome(String str, int start, int end) {
    if (start >= end) {
      return true;
    }

    return ((str.charAt(start) == str.charAt(end)) && checkPalindrome(str, start + 1, end - 1));
  }

  private static boolean checkPalindrome1(String input, int start, int end) {
    if (start >= end) {
      return true;
    }

    if (input.charAt(start) != input.charAt(end)) {
      return false;
    }

    return checkPalindrome1(input, start + 1, end - 1);
  }
}
