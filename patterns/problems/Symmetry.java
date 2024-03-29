package patterns.problems;

public class Symmetry {

    public static void symmetry(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
              if (j <= i || j >= (2 * n - i - 1)) {
                System.out.print("* ");
              } else {
                System.out.print("  ");
              }
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
              if (j < n - i || j >= n + i) {
                System.out.print("* ");
              } else {
                System.out.print("  ");
              }
            }
            System.out.println();
        }
    }
}
