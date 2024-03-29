package patterns.problems;

public class SymmetricVoid {

  public static void symmetry(int n) {
    // Write your code here
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2 * n; j++) {
        if (j < n - i || j >= n + i) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2 * n; j++) {
        if (j <= i || j >= (2 * n - (i + 1))) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void symmetry1(int n) {
    n = 2 * n;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (row < n / 2 && (col < (n / 2 - row) || col >= (n / 2 + row))) {
          System.out.print('*');
        } else if (row >= n / 2 && (col <= (row - n / 2) || col >= (n - row + n / 2 - 1))) {
          System.out.print('*');
        } else {
          System.out.print(' ');
        }

        System.out.print(' ');
      }
      System.out.println();
    }
  }
}
