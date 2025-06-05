package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for (int i : nums) {
            total += i;
        }

        if ((target + total) % 2 != 0) {
            return 0;
        }

        int sum = (target + total) / 2;

        return countSubsets(nums, sum, 0, new HashMap<>());
    }

    private int countSubsets(int[] nums, int sum, int index, Map<String, Integer> memory) {
        if (index == nums.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (index > nums.length || sum < 0) {
            return 0;
        }

        String key = index + "-" + sum;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        memory.put(key, countSubsets(nums, sum, index + 1, memory) + countSubsets(nums, sum - nums[index], index + 1, memory));
        return memory.get(key);
    }

    @Nested
    class TargetSumTest {

        TargetSum solver = new TargetSum();

        @Test
        public void testBasicCase() {
            int[] nums = {1, 1, 1, 1, 1};
            int target = 3;
            assertEquals(5, solver.findTargetSumWays(nums, target));
        }

        @Test
        public void testZeroTargetWithZeros() {
            int[] nums = {0, 0, 0, 0, 0};
            int target = 0;
            assertEquals(32, solver.findTargetSumWays(nums, target)); // 2^5
        }

        @Test
        public void testOddSumInvalidCase() {
            int[] nums = {1, 2, 7};
            int target = 3;
            assertEquals(0, solver.findTargetSumWays(nums, target)); // target + sum = 13, odd
        }

        @Test
        public void testAllPositiveTargetZero() {
            int[] nums = {1, 2, 3};
            int target = 0;
            assertEquals(2, solver.findTargetSumWays(nums, target)); // [+1,-2,+3] and [-1,+2,-3]
        }

        @Test
        public void testNegativeTarget() {
            int[] nums = {1, 2, 3};
            int target = -2;
            assertEquals(1, solver.findTargetSumWays(nums, target));
        }

        @Test
        public void testLargeExample() {
            int[] nums = {7, 9, 3, 8, 0, 2, 4, 8, 3, 9};
            int target = 0;
            assertEquals(0, solver.findTargetSumWays(nums, target)); // invalid: sum + target = 53, odd
        }
    }
}
