package dynamicprogramming.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 * Examples:
 * <p>
 * arr[] = {1, 5, 11, 5} Output: true The array can be partitioned as {1, 5, 5} and {11}
 */
@RunWith(Enclosed.class)
public class EqualSumPartitionProblem {

    public static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            return subsetSum(arr, sum / 2, 0, new HashMap<>());
        }
    }

    private static boolean subsetSum(int[] arr, int sum, int index, Map<String, Boolean> memory) {
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

        memory.put(key, subsetSum(arr, sum, index + 1, memory) || subsetSum(arr, sum - arr[index], index + 1, memory));
        return memory.get(key);
    }

    public static class EqualSumPartitionProblemTest {

        @Test
        public void testPartitionExists() throws Exception {
            int[] arr = {1, 5, 11, 5};
            assertTrue(equalSumPartition(arr));
        }

        @Test
        public void testPartitionNotPossibleOddSum() throws Exception {
            int[] arr = {1, 2, 3, 5}; // sum = 11, can't split evenly
            assertFalse(equalSumPartition(arr));
        }

        @Test
        public void testEmptyArray() throws Exception {
            int[] arr = {};
            assertTrue(equalSumPartition(arr)); // two empty subsets
        }

        @Test
        public void testSingleElement() throws Exception {
            int[] arr = {1};
            assertFalse(equalSumPartition(arr));
        }

        @Test
        public void testAllZeros() throws Exception {
            int[] arr = {0, 0, 0};
            assertTrue(equalSumPartition(arr));
        }

        @Test
        public void testNegativeAndPositive() throws Exception {
            int[] arr = {1, -1, 2, -2};
            assertTrue(equalSumPartition(arr));
        }

        @Test
        public void testLargeInputPartitionable() throws Exception {
            int[] arr = {2, 2, 1, 1, 5, 6, 7, 8, 10, 15}; // sum = 67, not divisible by 2
            assertFalse(equalSumPartition(arr));
        }

        @Test
        public void testLargeInputEvenSumPartitionable() throws Exception {
            int[] arr = {1, 1, 2, 3, 5, 8};
            assertTrue(equalSumPartition(arr));
        }
    }
}
