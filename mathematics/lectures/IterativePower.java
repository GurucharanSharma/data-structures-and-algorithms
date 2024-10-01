package mathematics.lectures;

public class IterativePower {

  public static void main(String[] args) {
    int x = 3;
    int n = 5;

    System.out.println(iterativePower(x, n));
    System.out.println(iterativePower1(x, n));
  }

  private static int iterativePower(int x, int n) {
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

  private static int iterativePower1(int n, int p) {
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
