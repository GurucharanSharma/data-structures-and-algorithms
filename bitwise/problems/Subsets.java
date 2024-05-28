package bitwise.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        int size = (1 << nums.length);

        List<List<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // Checking whether jth bit is set or not
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }

            sets.add(list);
        }

        return sets;
    }
}
