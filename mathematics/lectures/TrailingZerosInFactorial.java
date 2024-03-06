package mathematics.lectures;

/**
 * List the number of trailing zeros in the factorial of the number N
 */
public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        System.out.println(getTrailingZeros(100));
    }

    public static int getTrailingZeros(int n) {
        int count = 0;

        for (int i = 5; (n / i) >= 1; i = i * 5) {
            count = count + (n / i);
        }

        return count;
    }
}