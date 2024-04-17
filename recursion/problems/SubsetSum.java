package recursion.problems;

import java.util.ArrayList;

/**
 * Problem statement
 * <p>
 * You are given an array 'nums' of ‘n’ integers.
 * <p>
 * Return all subset sums of 'nums' in a non-decreasing order.
 * <p>
 * Note: Here subset sum means sum of all elements of a subset of 'nums'. A subset of 'nums' is an array formed by removing some (possibly zero or
 * all) elements of 'nums'.
 */
public class SubsetSum {

    public static ArrayList<Integer> subsetSum(int[] num) {
        ArrayList<Integer> result = new ArrayList<>();
        findSubsetSum(num, 0, 0, result);

        result.sort(Integer::compareTo);

        return result;
    }

    private static void findSubsetSum(int[] num, int s, int i, ArrayList<Integer> result) {
        if (i >= num.length) {
            result.add(s);
            return;
        }

        findSubsetSum(num, s, i + 1, result);
        findSubsetSum(num, s + num[i], i + 1, result);
    }
}
