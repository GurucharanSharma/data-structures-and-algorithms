package recursion.problems;

import java.util.Arrays;

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

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(arr));

    reverseArray(arr, arr.length);
    System.out.println(Arrays.toString(arr));

    reverseArray1(arr, 0);
    System.out.println(Arrays.toString(arr));
  }

  public static void reverseArray(int[] arr, int n) {
    if (n == 0 || n == 1) {
      return;
    }

    reverseNums(arr, 0, n - 1);
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

  private static void reverseArray1(int[] arr, int index) {
    if (index >= arr.length / 2) {
      return;
    }

    int temp = arr[index];
    arr[index] = arr[arr.length - index - 1];
    arr[arr.length - index - 1] = temp;

    reverseArray1(arr, index + 1);
  }
}
