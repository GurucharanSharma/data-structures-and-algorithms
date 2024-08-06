package array.problems;

public class KadanesAlgorithm {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, -2, 5};
//    int[] arr = {-1, -2, -3, -4};
//    int[] arr = {5, 4, 7};
    int[] arr = {-9626};

    System.out.println(maxSubarraySum(arr));
  }

  // arr: input array
  // Function to find the sum of contiguous subarray with maximum sum.
  static long maxSubarraySum(int[] arr) {
    long sum = 0;
    long res = arr[0];

    for (int i = 0; i < arr.length; i++) {
      sum = Math.max(arr[i], sum + arr[i]);
      res = Math.max(res, sum);
    }

    return res;
  }
}
