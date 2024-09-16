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

  static int getMaximumSubArraySum(int[] array) {
    int res = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      max = Math.max(array[i] + max, array[i]);
      res = Math.max(max, res);
    }

    return res;
  }

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
}
