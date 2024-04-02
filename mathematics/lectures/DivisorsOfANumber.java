package mathematics.lectures;

/**
 * Printing all the divisors in sorted order
 */
public class DivisorsOfANumber {
    public static void main(String[] args) {
        int n = 6;
        int i = 0;

        for (i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) System.out.print(i + " ");
        }

        for (; i >= 1; i--) {
            // Second condition is added to prevent duplicates from the first loop
            if (n % i == 0 && n / i != i - 1) {
                System.out.print((n / i) + " ");
            }
        }
    }
}
