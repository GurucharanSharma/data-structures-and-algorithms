package recursion.problems;

/**
 * Problem statement
 * <p>
 * You are given an sorted integer array of size 'n'.
 * <p>
 * Your task is to find and return all the unique subsets of the input array.
 * <p>
 * Subsets are arrays of length varying from 0 to 'n', that contain elements of the array. But the order of elements should remain the same as in the
 * input array.
 * <p>
 * Note: The order of subsets is not important. You can return the subsets in any order. However, in the output, you will see the subsets in
 * lexicographically sorted order.
 */
public class UniqueSubsets {

    public static void printSubsets(int[] input) {
        generateSubsets(input, 0, "");
    }

    private static void generateSubsets(int[] input, int i, String curr) {
        System.out.println(curr);

        for (int j = i; j < input.length; j++) {
            if (j > i && input[j] == input[j - 1]) {
                continue;
            }

            generateSubsets(input, j + 1, curr + input[j] + " ");
        }
    }
}
