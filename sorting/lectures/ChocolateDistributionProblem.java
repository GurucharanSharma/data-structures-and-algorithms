package sorting.lectures;

import java.util.Arrays;

public class ChocolateDistributionProblem {

  /**
   * <strong>Problem:</strong>
   * Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of
   * chocolates. There are m students, the task is to distribute chocolate packets such that:
   * <ul>
   *   <li>Each student gets one packet.</li>
   *   <li>The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum
   *  chocolates given to the students is minimum.</li>
   * </ul>
   * <p>
   * Note: All the packets are not distributed. Only m packets are distributed among m students. There can/will be undistributed packets left.
   *
   * @param args
   */
  public static void main(String[] args) {

    int[] arr = {7, 3, 1, 8, 9, 12, 56};
    System.out.println(minimumDifference(arr, 3));
  }

  // Efficient Approach 1
  private static int minimumDifference(int[] arr, int m) {
    // Check if there are enough packets for all students. If not, return -1.
    if (m > arr.length) {
      return -1;
    }

    // Sort the array in non-decreasing order.
    // This will help to easily find the minimum difference.
    Arrays.sort(arr);

    // Initialize 'res' (result) with the maximum possible integer value.
    // This will be used to find the minimum difference.
    int res = Integer.MAX_VALUE;

    // Loop through the array to find the minimum difference.
    // The loop goes up to 'arr.length - m' because we are looking at a window of size 'm'.
    // Going beyond 'arr.length - m' would cause index out of bounds.
    for (int i = 0; i <= arr.length - m; i++) {
      // Calculate the difference between the current maximum and minimum in this window.
      // 'arr[i + m - 1]' is the maximum chocolate in the current window of size 'm',
      // and 'arr[i]' is the minimum chocolate in the current window.
      // Math.abs is used for absolute difference, but it's not necessary here as the array is sorted.
      // res = Math.min(res, Math.abs(arr[i] - arr[i + m - 1]));
      res = Math.min(res, arr[i + m - 1] - arr[i]);
    }

    // Return the minimum difference found.
    return res;
  }

  // Efficient Approach 2
  private static int minimumDifference1(int[] arr, int m) {
    Arrays.sort(arr);

    int minDiff = arr[m - 1] - arr[0];
    for (int i = m; i < arr.length; i++) {
      int currDiff = arr[i] - arr[i - m + 1];
      minDiff = Math.min(minDiff, currDiff);
    }

    return minDiff;
  }

  // Naive Approach
  private static int minimumDifference2(int[] arr, int m) {
    Arrays.sort(arr);

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.length - m; i++) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int j = i; j < i + m; j++) {
        min = Math.min(min, arr[j]);
        max = Math.max(max, arr[j]);
      }

      minDiff = Math.min(minDiff, max - min);
    }

    return minDiff;
  }
}
