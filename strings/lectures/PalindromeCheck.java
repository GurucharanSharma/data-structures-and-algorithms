package strings.lectures;

public class PalindromeCheck {

  /**
   * Time Complexity: θ(n) <br> Space Complexity: θ(n)
   */
  private static boolean checkPalindrome(String str) {
    StringBuilder rev = new StringBuilder(str);
    rev.reverse();

    return str.contentEquals(rev);
  }

  /**
   * Time Complexity: O(n) <br> Space Complexity: O(1)
   */
  private static boolean checkPalindrome1(String str) {
    int begin = 0;
    int end = str.length() - 1;

    while (begin <= end) {
      if (str.charAt(begin) == str.charAt(end)) {
        begin++;
        end--;
      } else {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    testCheckPalindrome();
  }

  private static void testCheckPalindrome() {
    String str = "ABCDEDCBA";

    System.out.println(checkPalindrome(str));
    System.out.println(checkPalindrome1(str));
  }
}
