package recursion.problems;

import java.util.ArrayList;

/**
 * Problem statement
 * <p>
 * You are given ‘k’ and ‘n’ and you have to do the following:-
 * <p>
 * Return all possible combinations of arrays whose elements sum is equal to ‘n’, and you can use only elements in the range '1' to '9' inclusive, and
 * you can use each element at most once, and the size of the combination should be exactly ‘k’.
 * <p>
 * If there is no combination, return an empty array.
 * <p>
 * It should be noted that the 2-D array should be returned in sorted order, meaning the lexicographically smaller array should come first.
 * <p>
 * Also, at each index of the 2-D array, the elements present in the array present at that index should be in sorted order.
 * <p>
 * Note: Two combinations are called different if an element is in one combination and not in another.
 * <p>
 * Also, in the output, you will see the 2-D array returned by you.
 */
public class CombinationSumIII {

    /**
     * Approach 1
     */
    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        findCombination(input, k, n, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private static void findCombination(int[] input, int k, int n, int i, int s, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
        if (curr.size() == k) {
            if (s == n) {
                result.add(new ArrayList<>(curr));
                return;
            }

            return;
        }

        if (i >= input.length || s > n || curr.size() > k) {
            return;
        }

        curr.add(input[i]);
        findCombination(input, k, n, i + 1, s + input[i], curr, result);

        if (!curr.isEmpty()) {
            curr.remove(curr.size() - 1);
        }
        findCombination(input, k, n, i + 1, s, curr, result);
    }

    /**
     * Approach 2
     */
    public static ArrayList<ArrayList<Integer>> combinationSum3_1(int k, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findCombination(0, k, n, 0, new ArrayList<>(), result);
        return result;
    }

    static void findCombination(int i, int k, int n, int last, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {

        // If we have reached the last element then we can not add any more elements so check.
        // The sum of elements in temp is equal to 'n' or not.
        // If it is then add it to the answer.
        if (i == k) {
            if (n == 0) {
                result.add(new ArrayList<>(curr));
            }
        }

        // We can use every element once only so we will use the element greater than the previous elements.
        // So for 'j' in range [last+1, 9]
        for (int j = last + 1; j < 10; j++) {

            // If 'j' is greater than 'n' then we can not add it to 'curr'.
            if (n - j < 0) {
                break;
            }

            // Add the current element to 'temp' and call the create function with n-curr.
            curr.add(j);
            findCombination(i + 1, k, n - j, j, curr, result);

            // Backtrack.
            if (!curr.isEmpty()) {
                curr.remove(curr.size() - 1);
            }
        }
    }
}
