package mathematics;

public class MathematicsRunner {

  public static void main(String[] args) {
    int n = 3712;

    System.out.println(checkArmstrong(n));
  }

  private static boolean checkArmstrong(int n) {
    int count = digitCount(n);
    int sum = 0;

    int temp = n;
    while (temp != 0) {
      int digit = temp % 10;
      sum = sum + computationPower(digit, count);
      temp = temp / 10;
    }

    return sum == n;
  }

  private static int digitCount(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      n = n / 10;
    }

    return count;
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
