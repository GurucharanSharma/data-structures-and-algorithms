package mathematics.lectures;

public class PalindromeNumbers {

  public static void main(String[] args) {
    int num = 121;

    System.out.println(checkPalindrome(num));
    System.out.println();
    System.out.println(checkPalindrome1(num));
    System.out.println();
    System.out.println(checkPalindrome2(num));
  }

  private static boolean checkPalindrome(int n) {
    int rev = 0;
    int temp = n;
    while (temp > 0) {
      rev = (rev * 10) + (temp % 10);
      temp = temp / 10;
    }

    return rev == n;
  }

  private static boolean checkPalindrome1(int n) {
    String numStr = String.valueOf(n);
    int start = 0;
    int end = numStr.length() - 1;

    while (start <= end) {
      if (numStr.charAt(start) != numStr.charAt(end)) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }

  private static boolean checkPalindrome2(int n) {
    return n == reverse(n, 0);
  }

  private static int reverse(int num, int rev) {
    if (num == 0) {
      return rev;
    }

    return reverse(num / 10, (rev * 10) + num % 10);
  }
}
