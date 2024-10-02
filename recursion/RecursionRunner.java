package recursion;

public class RecursionRunner {

  public static void main(String[] args) {
    String input = "abbas";

    System.out.println(isPalindrome(input, 0, input.length() - 1));
  }

  private static boolean isPalindrome(String input, int start, int end) {
    if (start >= end) {
      return true;
    }

    if (input.charAt(start) != input.charAt(end)) {
      return false;
    }

    return isPalindrome(input, start + 1, end - 1);
  }
}
