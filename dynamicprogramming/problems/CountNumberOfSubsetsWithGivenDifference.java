package dynamicprogramming.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Given an array Arr[] and a difference diff, find the number of subsets that array can be divided so that each the difference between the two subset
 * is the given diff.
 * <p>
 * Example1: Input: Arr[] : 1,1,2,3 diff: 1 Output: 3 .
 */
@RunWith(Enclosed.class)
public class CountNumberOfSubsetsWithGivenDifference {

    public int countSubsetsWithDiff(int[] arr, int diff) {
        int total = 0;

        for (int i : arr) {
            total += i;
        }

        int sum = (Math.abs(diff) + total) / 2; // To handle the negative difference

//        return countSubsets(arr, sum, 0, new HashMap<>());
        return countSubsets(arr, sum);
    }

    /// Recursive + Memoization
    private int countSubsets(int[] arr, int sum, int index, Map<String, Integer> memory) {
        if (index == arr.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (index > arr.length || sum < 0) {
            return 0;
        }

        String key = index + "-" + sum;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        memory.put(key, countSubsets(arr, sum, index + 1, memory) + countSubsets(arr, sum - arr[index], index + 1, memory));
        return memory.get(key);
    }

    /// Tabulation
    private int countSubsets(int[] arr, int sum) {
        int n = arr.length;
        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] + table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        // Print the table
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(table[i]));
        }

        return table[n][sum];
    }

    public static class CountNumberOfSubsetsWithGivenDifferenceTest {

        CountNumberOfSubsetsWithGivenDifference solver = new CountNumberOfSubsetsWithGivenDifference();

        @Test
        public void testBasicExample() {
            int[] arr = {1, 1, 2, 3};
            int diff = 1;
            assertEquals(3, solver.countSubsetsWithDiff(arr, diff));
        }

        @Test
        public void testNoValidSubset() {
            int[] arr = {1, 2, 7};
            int diff = 10;
            assertEquals(1, solver.countSubsetsWithDiff(arr, diff));
        }

        @Test
        public void testEmptyArray() {
            int[] arr = {};
            int diff = 0;
            assertEquals(1, solver.countSubsetsWithDiff(arr, diff));
        }

        @Test
        public void testSingleElementMatchingDiff() {
            int[] arr = {3};
            int diff = 3;
            assertEquals(1, solver.countSubsetsWithDiff(arr, diff));
        }

        @Test
        public void testNegativeDiff() {
            int[] arr = {1, 2, 3};
            int diff = -1;
            assertEquals(2, solver.countSubsetsWithDiff(arr, diff));
        }

        @Test
        public void testAllZerosZeroDiff() {
            int[] arr = {0, 0, 0};
            int diff = 0;
            assertEquals(8, solver.countSubsetsWithDiff(arr, diff)); // 2^3 subsets all sum to 0
        }
    }
}
