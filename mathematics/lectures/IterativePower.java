package mathematics.lectures;

public class IterativePower {

  public static void main(String[] args) {
    int x = 3;
    int n = 5;

    System.out.println(iterativePower(x, n));
    System.out.println(iterativePower1(x, n));
    System.out.println(iterativePower2(x, n));
  }

  // Naive approach
  // Time Complexity: O(n)
  // Auxiliary Space: O(1)
  private static int iterativePower(int n, int p) {
    int result = 1;
    for (int i = 0; i < p; i++) {
      result = result * n;
    }

    return result;
  }

  // Naive approach
  // Time Complexity: O(log(n))
  // Auxiliary Space: O(1)
  private static int iterativePower1(int x, int n) {
    int result = 1;
    while (n > 0) {
      if (n % 2 != 0) {
        // Bit is 1
        result = result * x;
      }

      x = x * x;
      n = n / 2; // shifts the bits of the number 1 position to the right (towards 0)
    }

    return result;
  }

  // Efficient approach
  // Time Complexity: O(log(p))
  // Auxiliary Space: O(1)
  private static int iterativePower2(int n, int p) {
    int result = 1;
    int pow = n;

    while (p != 0) {
      if (p % 2 == 1) {
        result = result * pow;
      }

      pow = pow * pow;
      p = p / 2; // p = p >> 1;
    }

    return result;
  }

}
