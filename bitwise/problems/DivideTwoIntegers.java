package bitwise.problems;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this
 * problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {

    /**
     * Naive approach
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }

        boolean flag = (divisor < 0 && dividend >= 0) || (divisor >= 0 && dividend < 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long sum = d;
        int count = 0;

        while (sum <= n) {
            count++;
            sum = sum + d;
        }

        if (sum >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return flag ? -count : count;
        }
    }

    /**
     * Efficient approach
     */
    public static int divide1(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }

        boolean isNegative = (divisor < 0 && dividend >= 0) || (divisor >= 0 && dividend < 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }

            quotient = quotient + (1L << count);
            n = n - (d << count);
        }

        if (quotient == (1L << 31) && !isNegative) {
            return Integer.MAX_VALUE;
        } else if (quotient == (1L << 31) && isNegative) {
            return Integer.MIN_VALUE;
        } else {
            return isNegative ? (int) -quotient : (int) quotient;
        }
    }
}
