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

    public static int divide(int dividend, int divisor) {
        boolean flag = false;
        if ((divisor < 0 && dividend >= 0) || (divisor >= 0 && dividend < 0)) {
            divisor = Math.abs(divisor);
            flag = true;
        }

        int sum = divisor;
        int count = 0;

        while (sum < dividend) {
            count++;
            sum = sum + divisor;
        }

        return flag ? -count : count;
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }

        boolean flag = false;
        if ((divisor < 0 && dividend >= 0) || (divisor >= 0 && dividend < 0)) {
            divisor = Math.abs(divisor);
            dividend = Math.abs(dividend);
            flag = true;
        }
    }
}
