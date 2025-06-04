package dynamicprogramming.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SubsetSumProblem {

    /// Recursion
    private static boolean subsetSum(int[] arr, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        if (index >= arr.length || sum < 0) {
            return false;
        }

        return subsetSum(arr, sum, index + 1) || subsetSum(arr, sum - arr[index], index + 1);
    }

    /// Recursion + Memoization
    private static boolean subsetSumMemo(int[] arr, int sum, int index, Map<String, Boolean> memory) {
        if (sum == 0) {
            return true;
        }

        if (index >= arr.length || sum < 0) {
            return false;
        }

        String key = index + "-" + sum;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        memory.put(key, subsetSumMemo(arr, sum, index + 1, memory) || subsetSumMemo(arr, sum - arr[index], index + 1, memory));
        return memory.get(key);
    }

    /// Tabulation
    private static boolean subsetSumTab(int[] arr, int sum) {
        int N = arr.length;
        boolean[][] table = new boolean[N + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = false;
        }

        for (int i = 0; i <= N; i++) {
            table[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] || table[i - 1][j - arr[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[N][sum];
    }

    public static class SubsetSumProblemTest {

        @Test
        public void testSubsetExists() throws Exception {
            int[] arr = {3, 34, 4, 12, 5, 2};
            int sum = 9;
            assertTrue(subsetSum(arr, sum, 0));
            assertTrue(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertTrue(subsetSumTab(arr, sum));
        }

        @Test
        public void testSubsetDoesNotExist() throws Exception {
            int[] arr = {3, 34, 4, 12, 5, 2};
            int sum = 30;
            assertFalse(subsetSum(arr, sum, 0));
            assertFalse(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertFalse(subsetSumTab(arr, sum));
        }

        @Test
        public void testEmptyArrayZeroSum() throws Exception {
            int[] arr = {};
            int sum = 0;
            assertTrue(subsetSum(arr, sum, 0));
            assertTrue(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertTrue(subsetSumTab(arr, sum));
        }

        @Test
        public void testEmptyArrayNonZeroSum() throws Exception {
            int[] arr = {};
            int sum = 10;
            assertFalse(subsetSum(arr, sum, 0));
            assertFalse(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertFalse(subsetSumTab(arr, sum));
        }

        @Test
        public void testSingleElementMatch() throws Exception {
            int[] arr = {5};
            int sum = 5;
            assertTrue(subsetSum(arr, sum, 0));
            assertTrue(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertTrue(subsetSumTab(arr, sum));
        }

        @Test
        public void testSingleElementNoMatch() throws Exception {
            int[] arr = {5};
            int sum = 10;
            assertFalse(subsetSum(arr, sum, 0));
            assertFalse(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertFalse(subsetSumTab(arr, sum));
        }

        @Test
        public void testAllZerosSumZero() throws Exception {
            int[] arr = {0, 0, 0};
            int sum = 0;
            assertTrue(subsetSum(arr, sum, 0));
            assertTrue(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertTrue(subsetSumTab(arr, sum));
        }

        @Test
        public void testAllZerosSumPositive() throws Exception {
            int[] arr = {0, 0, 0};
            int sum = 1;
            assertFalse(subsetSum(arr, sum, 0));
            assertFalse(subsetSumMemo(arr, sum, 0, new HashMap<>()));
            assertFalse(subsetSumTab(arr, sum));
        }
    }
}
