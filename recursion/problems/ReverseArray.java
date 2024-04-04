package recursion.problems;

/**
 * <p>
 * Reverse an Array
 * </p>
 * Given an array 'arr' of size 'n'.
 * <p>
 * Return an array with all the elements placed in reverse order.
 * <p>
 * Note: You don’t need to print anything. Just implement the given function. Example: Input: n = 6, arr = [5, 7, 8, 1, 6, 3]
 * <p>
 * Output: [3, 6, 1, 8, 7, 5]
 * <p>
 * Explanation: After reversing the array, it looks like this [3, 6, 1, 8, 7, 5].
 */
public class ReverseArray {

    public static int[] reverseArray(int n, int[] nums) {
        if (n == 0 || n == 1) {
            return nums;
        }

        reverseNums(nums, 0, n - 1);
        return nums;
    }

    private static void reverseNums(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverseNums(nums, start + 1, end - 1);
    }
}
