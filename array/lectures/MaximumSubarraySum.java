package array.lectures;

/**
 * Kadane's Algorithm
 */
public class MaximumSubarraySum {

  public static void main(String[] args) {
    int[] array = new int[]{-5, 1, -2, 3, -1, 2, -2};
    System.out.println(getMaximumSubArraySum(array));
    System.out.println(getMaximumSubArraySum1(array));
  }

  // Efficient Approach: Only finding the max sum
  static int getMaximumSubArraySum(int[] array) {
    int res = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      max = Math.max(array[i] + max, array[i]);
      res = Math.max(max, res);
    }

    return res;
  }

  // Efficient Approach 1: Finding the max sum along with the start and end indexes.
  static int getMaximumSubArraySum1(int[] arr) {
    int sum = 0;
    int res = 0;
    int start = 0;
    int end = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] + sum > arr[i]) {
        sum = arr[i] + sum;
        end++;
      } else {
        sum = arr[i];
        start = end = i;
      }

      res = Math.max(res, sum);
    }

    for (int i = start; i < end; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    return res;
  }

  // Efficient Approach 2: Finding the max sum along with the start and end indexes.
  private static void getMaximumSubArraySum2(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    int start = 0;
    int end = -1;
    int res = arr[0];
    int sum = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (sum + arr[i] > arr[i]) {
        sum = sum + arr[i];
      } else {
        sum = arr[i];
        start = i;
      }

      if (res < sum) {
        res = sum;
        end = i;
      }
    }

    for (int i = start; i <= end; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  // Naive Approach: Finding the max sum along with the start and end indexes.
  private static void getMaximumSubArraySum3(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    int start = 0;
    int end = 0;
    int res = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int sum = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        sum = sum + arr[j];
        if (res < sum) {
          res = sum;
          start = i;
          end = j;
        }
      }
    }

    for (int i = start; i <= end; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
