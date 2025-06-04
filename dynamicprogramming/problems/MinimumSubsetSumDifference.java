package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MinimumSubsetSumDifference {

    public int minimumDifference(int[] arr) {
        int n = arr.length;
        int range = 0;

        if (n == 1) {
            return arr[0];
        }

        if (n == 2) {
            return Math.abs(arr[0] - arr[1]);
        }

        for (int i : arr) {
            range += i;
        }

        boolean[][] table = subsetSum(arr, range);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= range / 2; i++) {
            if (table[n][i]) {
                min = Math.min(min, Math.abs(range - 2 * i));
            }
        }

        return min;
    }

    private boolean[][] subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] table = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = false;
        }

        for (int i = 0; i <= n; i++) {
            table[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] >= 0 && arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] || table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table;
    }

    @Nested
    class MinimumSubsetSumDifferenceTest {

        MinimumSubsetSumDifference solver = new MinimumSubsetSumDifference();

        @Test
        public void testBasicCase() {
            int[] arr = {1, 6, 11, 5};
            Assertions.assertEquals(1, solver.minimumDifference(arr)); // Partition: {1, 6, 5} and {11}
        }

        @Test
        public void testAllElementsEqual() {
            int[] arr = {10, 10, 10, 10};
            Assertions.assertEquals(0, solver.minimumDifference(arr)); // Equal halves possible
        }

        @Test
        public void testSingleElement() {
            int[] arr = {7};
            Assertions.assertEquals(7, solver.minimumDifference(arr)); // Only one subset
        }

        @Test
        public void testTwoElements() {
            int[] arr = {2, 4};
            Assertions.assertEquals(2, solver.minimumDifference(arr)); // {2}, {4} → diff = 2
        }

        @Test
        public void testEmptyArray() {
            int[] arr = {};
            Assertions.assertEquals(0, solver.minimumDifference(arr)); // No elements, difference is 0
        }

        @Test
        public void testZeros() {
            int[] arr = {0, 0, 0, 0};
            Assertions.assertEquals(0, solver.minimumDifference(arr)); // All zeros, split trivially
        }

        @Test
        public void testLargeNumbers() {
            int[] arr = {100, 200, 300, 400, 500};
            Assertions.assertEquals(100, solver.minimumDifference(arr)); // Try all subset combos
        }

        @Test
        public void testNegativeNumbersIgnored() {
            int[] arr = {1, 2, -3, 4}; // Method doesn't handle negatives, but should ignore them or fail cleanly
            assertDoesNotThrow(() -> solver.minimumDifference(arr)); // Optional: test resilience
        }
    }
}
