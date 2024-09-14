package array.problems;

public class LongestEvenOffSubArray {

  public static void main(String[] args) {
//    int[] a = {10, 12, 14, 7, 8};
    int[] a = {4, 6};

    System.out.println(maxEvenOdd(a, a.length));
  }

  /**
   * Approach 1
   */
  // arr[]: input array
  // n: size of array
  //Function to find the length of longest subarray of even and odd numbers.
  public static int maxEvenOdd(int[] arr, int n) {
    boolean curr;
    boolean prev = arr[0] % 2 != 0;
    int currLen = 1;
    int maxLen = 0;

    for (int i = 1; i < n; i++) {
      curr = arr[i] % 2 != 0;

      if (prev != curr) {
        currLen++;
        maxLen = Math.max(currLen, maxLen);
      } else {
        currLen = 1;
      }

      prev = curr;
    }

    maxLen = Math.max(currLen, maxLen);
    return maxLen;
  }

  /**
   * Approach 2
   */
  // arr[]: input array
  // n: size of array
  //Function to find the length of longest subarray of even and odd numbers.
  public static int maxEvenOdd1(int[] arr, int n) {
    int length = 1;
    int result = 1;
    for (int i = 1; i < n; i++) {
      if ((isEven(arr[i - 1]) && !isEven(arr[i])) || (!isEven(arr[i - 1]) && isEven(arr[i]))) {
        length++;
        result = Math.max(result, length);
      } else {
        length = 1;
      }
    }

    return result;
  }

  public static boolean isEven(int n) {
    return n % 2 == 0;
  }
}