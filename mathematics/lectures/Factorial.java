package mathematics.lectures;

public class Factorial {

  public static void main(String[] args) {
    int num = 0;

    System.out.println(factorialOfANumber(num));
    System.out.println();
    System.out.println(factorialOfANumber1(num));
    System.out.println();
    System.out.println(factorialOfANumber2(num, 1));
  }

  private static int factorialOfANumber(int n) {
    int fact = 1;
    for (int i = n; i >= 1; i--) {
      fact = fact * i;
    }

    return fact;
  }

  private static int factorialOfANumber1(int n) {
    if (n == 0) {
      return 1;
    }

    return n * factorialOfANumber1(n - 1);
  }

  private static int factorialOfANumber2(int n, int fact) {
    if (n == 0) {
      return fact;
    }

    return factorialOfANumber2(n - 1, fact * n);
  }
}
