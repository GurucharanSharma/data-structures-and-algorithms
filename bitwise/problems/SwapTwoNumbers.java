package bitwise.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Swap given two numbers and print them. (Try to do it without a temporary variable.) and return it.
 */
public class SwapTwoNumbers {

    public static List<Integer> get(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        return Arrays.asList(a, b);
    }
}
