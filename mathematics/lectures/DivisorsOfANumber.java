package mathematics.lectures;

/**
 * Printing all the divisors in sorted order
 */
public class DivisorsOfANumber {
    public static void main(String[] args) {
        int n = 176;
        int i = 0;

        for (i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) System.out.print(i + " ");
        }

        for (; i >= 1; i--) {
            if (n % i == 0) System.out.print((n / i) + " ");
        }
    }
}
