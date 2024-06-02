package patterns.problems;

public class NinjaAndNumberPattern {

    public static void getStarPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void getNumberPattern(int n) {
        int rows = 2 * n - 1;
        int cols = 2 * n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cols; j++) {
                if (j >= i && j < cols - i) {
                    System.out.print(n - i);
                } else if (j < cols / 2) {
                    System.out.print(n - j);
                } else if (j >= cols / 2) {
                    System.out.print(j - cols / 2 + 1);
                }
            }
            System.out.println();
        }

        for (int i = n; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j >= cols - i - 1 && j <= i) {
                    System.out.print(i - n + 2);
                } else if (j < cols / 2) {
                    System.out.print(n - j);
                } else if (j >= cols / 2) {
                    System.out.print(j - cols / 2 + 1);
                }
            }
            System.out.println();
        }
    }

    public static void getNumberPattern1(int n) {
        int k = 2 * n - 1;

        // Calculating the values in each cell and printing.
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = Math.abs(i - n + 1);
                int y = Math.abs(j - n + 1);
                int currCell = Math.max(x, y) + 1;
                System.out.print(currCell);
            }
            System.out.println();
        }
    }
}
