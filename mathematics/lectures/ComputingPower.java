package mathematics.lectures;

public class ComputingPower {

  public static void main(String[] args) {
    int x = 3;
    int n = 5;

    System.out.println(computingPower(x, n));
    System.out.println();
    System.out.println(computingPower1(x, n));
  }

  // Recursive approach
  private static int computingPower(int x, int y) {
    if (y == 0) {
      return 1;
    }

    int temp = computingPower(x, y / 2);

    if (y % 2 == 0) {
      return temp * temp;
    } else {
      return x * temp * temp;
    }
  }

  // Iterative approach
  private static int computingPower1(int n, int p) {
    int res = 1;
    while (p > 0) {
      if (p % 2 == 1) {
        res = res * n;
      }

      n = n * n;
      p = p / 2;
    }

    return res;
  }
}
