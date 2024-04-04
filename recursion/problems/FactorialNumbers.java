package recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <b>Factorial Numbers Not Greater Than N</b>
 * <p>
 * Problem statement You are given an integer ’n’.
 * <p>
 * Your task is to return a sorted array (in increasing order) containing all the factorial numbers which are less than or equal to ‘n’.
 * <p>
 * The factorial number is a factorial of a positive integer, like 24 is a factorial number, as it is a factorial of 4.
 * <p>
 * Note: In the output, you will see the array returned by you. Example: Input: ‘n’ = 7
 * <p>
 * Output: 1 2 6
 * <p>
 * Explanation: Factorial numbers less than or equal to ‘7’ are ‘1’, ‘2’, and ‘6’.
 */
public class FactorialNumbers {

    public static List<Long> factorialNumbers(long n) {
        List<Long> nums = new ArrayList<>();

        long i = 1;
        for (long fact = 1; fact <= n; fact = fact * ++i) {
            nums.add(fact);
        }

        return nums;
    }
}
