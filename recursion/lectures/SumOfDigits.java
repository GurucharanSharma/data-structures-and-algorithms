package recursion.lectures;

public class SumOfDigits {

  public static void main(String[] args) {
    System.out.println(sumOfDigits(9987));
    System.out.println(sumOfDigits(9987, 0));
  }

  // Recursive recursion
  static int sumOfDigits(int n) {
    if (n <= 0) {
      return 0;
    }

    return n % 10 + sumOfDigits(n / 10);
  }

  // Tail recursion
  static int sumOfDigits(int n, int k) {
    if (n <= 0) {
      return k;
    }

    return sumOfDigits(n / 10, k + (n % 10));
  }
}
