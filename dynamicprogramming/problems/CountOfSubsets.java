package dynamicprogramming.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X. Example:
 * <p>
 * Input: arr[] = {1, 2, 3, 3}, X = 6 Output: 3 All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
 */
@RunWith(Enclosed.class)
public class CountOfSubsets {

    public int subsetCount(int[] arr, int sum) {
        if (arr.length == 0) {
            return 0;
        }

        return subsetCount(arr, sum, 0);
    }

    private int subsetCount(int[] arr, int sum, int index) {
        if (sum == 0) {
            return 1;
        }

        if (sum < 0 || index >= arr.length) {
            return 0;
        }

        return subsetCount(arr, sum - arr[index], index + 1) + subsetCount(arr, sum, index + 1);
    }

    public static class CountOfSubsetsTest {

        CountOfSubsets counter = new CountOfSubsets();

        @Test
        public void testBasicSubsetMatch() {
            int[] arr = {1, 2, 3, 3};
            int sum = 6;
            assertEquals(3, counter.subsetCount(arr, sum)); // {1,2,3}, {1,2,3}, {3,3}
        }

        @Test
        public void testNoSubsetMatch() {
            int[] arr = {2, 4, 6};
            int sum = 5;
            assertEquals(0, counter.subsetCount(arr, sum));
        }

        @Test
        public void testEmptyArraySumZero() {
            int[] arr = {};
            int sum = 0;
            assertEquals(0, counter.subsetCount(arr, sum)); // defined behavior: no subset (edge case)
        }

        @Test
        public void testSingleElementMatch() {
            int[] arr = {5};
            int sum = 5;
            assertEquals(1, counter.subsetCount(arr, sum));
        }

        @Test
        public void testSingleElementNoMatch() {
            int[] arr = {5};
            int sum = 3;
            assertEquals(0, counter.subsetCount(arr, sum));
        }

        @Test
        public void testMultipleCombinations() {
            int[] arr = {1, 1, 1, 1};
            int sum = 2;
            assertEquals(6, counter.subsetCount(arr, sum)); // choose any two 1s: 4C2 = 6
        }

        @Test
        public void testAllZerosSumZero() {
            int[] arr = {0, 0, 0};
            int sum = 0;
            assertEquals(1, counter.subsetCount(arr, sum)); // Only 1 empty subset counts
        }

        @Test
        public void testAllZerosSumNonZero() {
            int[] arr = {0, 0, 0};
            int sum = 1;
            assertEquals(0, counter.subsetCount(arr, sum));
        }
    }
}
