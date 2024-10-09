package recursion.problems;

public class DigitalRoot {

  public static void main(String[] args) {
    System.out.println(digitalRoot(99999));
    System.out.println();
    System.out.println(digitalRoot1(99999));
  }

  // Recursive approach
  private static int digitalRoot(int n) {
    if (n / 10 == 0) {
      return n;
    }

    return digitalRoot(digitSum(n));
  }

  private static int digitSum(int n) {
    if (n <= 0) {
      return 0;
    }

    return n % 10 + digitSum(n / 10);
  }

  // Iterative approach
  private static int digitalRoot1(int n) {
    int sum;

    do {
      sum = 0;
      while (n > 0) {
        sum += (n % 10);
        n = n / 10;
      }

      n = sum;
    } while (sum / 10 != 0);

    return sum;
  }
}
