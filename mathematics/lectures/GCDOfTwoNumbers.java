package mathematics.lectures;

public class GCDOfTwoNumbers {

  public static void main(String[] args) {
    int n1 = 20;
    int n2 = 28;

    System.out.println(gcdOfTwoNumbers(n1, n2));
    System.out.println();
    System.out.println(gcdOfTwoNumbers1(n1, n2));
    System.out.println();
    System.out.println(gcdOfTwoNumbers2(n1, n2));
  }

  // Naive approach
  private static int gcdOfTwoNumbers(int a, int b) {
    int min = Math.min(a, b);
    int gcd = 1;

    for (int i = 1; i <= min; i++) {
      if (a % i == 0 && b % i == 0) {
        gcd = i;
      }
    }

    return gcd;
  }

  // Euclidean approach
  public static int gcdOfTwoNumbers1(int a, int b) {
    if (a == 0 || b == 0) {
      return 0;
    }

    if (a == 1 || b == 1) {
      return 1;
    }

    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }

    return a;
  }

  // Optimised Euclidean approach
  public static int gcdOfTwoNumbers2(int a, int b) {
    if (a == 0) {
      return b;
    }

    return gcdOfTwoNumbers1(b % a, a);
  }
}
