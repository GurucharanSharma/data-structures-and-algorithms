package mathematics.problems;

public class CheckArmstrong {

  public static void main(String[] args) {
//    int n = 3712;
//    int n = 371;
    int n = 153;

    System.out.println(checkArmstrong(n));
  }

  // Approach 1: Using in-built methods
  public static boolean checkArmstrong(int n) {
    int digits = String.valueOf(n).length();
    int res = 0;
    int num = n;

    while (num > 0) {
      res = (int) (res + Math.pow(num % 10, digits));
      num = num / 10;
    }

    return (res == n);
  }

  // Approach 2: Creating our implementation for power computation
  private static boolean checkArmstrong1(int n) {
    int count = String.valueOf(n).length();
    int sum = 0;

    int temp = n;
    while (temp != 0) {
      int digit = temp % 10;
      sum = sum + computationPower(digit, count);
      temp = temp / 10;
    }

    return sum == n;
  }

  private static int computationPower(int n, int p) {
    int result = 1;

    while (p != 0) {
      if (p % 2 != 0) {
        result = result * n;
      }

      n = n * n;
      p = p / 2;
    }

    return result;
  }
}
