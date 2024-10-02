package mathematics.lectures;

/**
 * Printing all the divisors in sorted order
 */
public class DivisorsOfANumber {

  public static void main(String[] args) {
    int n = 67;

    printAllDivisors(n);
    System.out.println();
    printAllDivisors1(n);
    System.out.println();
    printAllDivisors2(n);
  }

  // Naive approach
  private static void printAllDivisors(int n) {
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        System.out.print(i + " ");
      }
    }
  }

  // Efficient approach: Print the divisors in any order
  private static void printAllDivisors1(int n) {
    // Note that this loop runs till square root
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        // If divisors are equal, print only one
        if (n / i == i) {
          System.out.print(" " + i);
        } else { // Otherwise print both
          System.out.print(i + " " + n / i + " ");
        }
      }
    }
  }

  // Efficient approach: Print the divisors in sorted order
  private static void printAllDivisors2(int n) {
    int i = 0;
    for (i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        System.out.print(i + " ");
      }
    }

    for (; i >= 1; i--) {
      // Second condition is added to prevent duplicates from the first loop
      if (n % i == 0 && n / i != i - 1) {
        System.out.print((n / i) + " ");
      }
    }
  }
}
