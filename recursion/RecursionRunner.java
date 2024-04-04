package recursion;

import java.util.Arrays;
import recursion.problems.FactorialNumbers;
import recursion.problems.ReverseArray;

public class RecursionRunner {

    public static void main(String[] args) {
        System.out.println(FactorialNumbers.factorialNumbers(7));

        int[] nums = {5, 7, 8, 1, 6, 3};
        System.out.println(Arrays.toString(ReverseArray.reverseArray(nums.length, nums)));
    }
}
