package array.problems;

public class MaximumCircularSubArraySum {

  public static void main(String[] args) {
//    int[] arr = {8, -8, 9, -9, 10, -11, 12};
    int[] arr = {10, -3, -4, 7, 6, 5, -4, -1};

    System.out.println(circularSubarraySum(arr, arr.length));
  }

  // a: input array
  // n: size of array
  //Function to find maximum circular subarray sum.
  static int circularSubarraySum(int[] a, int n) {
    int normalSubArraySum = getMaxSubArraySum(a, n);
    if (normalSubArraySum < 0) {
      return normalSubArraySum;
    }

    int arraySum = 0;
    for (int i = 0; i < n; i++) {
      arraySum += a[i];
      a[i] = -a[i];
    }

    int circularSubArraySum = arraySum + getMaxSubArraySum(a, n);
    return Math.max(circularSubArraySum, normalSubArraySum);
  }

  static int getMaxSubArraySum(int[] a, int n) {
    int sum = a[0];
    int max = a[0];

    for (int i = 1; i < n; i++) {
      sum = Math.max(a[i] + sum, a[i]);
      max = Math.max(max, sum);
    }

    return max;
  }
}
