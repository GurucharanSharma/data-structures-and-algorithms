package array.lectures;

public class SlidingWindowTechnique {

  public static void main(String[] args) {
    int[] array = new int[]{2, 3};
    int window = 3;

    System.out.println(getMaximumSumInWindow(array, window));
    System.out.println(getMaximumSumInWindow1(array, window));
  }

  /**
   * Efficient approach <br> Time Complexity is O(n) <br> Auxiliary Space:  O(1)
   */
  static int getMaximumSumInWindow(int[] array, int window) {
    if (window > array.length) {
      return -1;
    }

    int result = 0;
    int sum = 0;

    for (int i = 0; i < array.length; i++) {
      if (i < window) {
        sum += array[i];
        result = sum;
      } else {
        sum += array[i] - array[i - window];
        result = Math.max(sum, result);
      }
    }

    return result;
  }

  // Efficient Approach 2
  static int getMaximumSumInWindow1(int[] arr, int k) {
    int n = arr.length;
    int sum = 0;

    if (n < k) {
      return -1;
    }

    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    int max = sum;

    for (int i = k; i < n; i++) {
      sum = sum - arr[i - k] + arr[i];
      max = Math.max(sum, max);
    }

    return max;
  }

  // Naive Approach
  private static int getMaximumSumInWindow2(int[] arr, int k) {
    if (arr.length < k) {
      return -1;
    }

    int res = 0;
    for (int i = 0; i <= arr.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += arr[j];
      }

      res = Math.max(res, sum);
    }

    return res;
  }
}
