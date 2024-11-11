package recursion.problems;

public class DigitalRoot {

  public static void main(String[] args) {
//    int n = 99999;
    int n = 1345433;
    
    System.out.println(digitalRoot(n));
    System.out.println();
    System.out.println(digitalRoot1(n));
    System.out.println();
    System.out.println(digitalRoot2(n));
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

  // Iterative approach 1
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

  // Iterative approach 2
  private static int digitalRoot2(int n) {
    while (n / 10 != 0) {
      int sum = 0;
      while (n != 0) {
        sum = sum + (n % 10);
        n = n / 10;
      }

      n = sum;
    }

    return n;
  }
}
