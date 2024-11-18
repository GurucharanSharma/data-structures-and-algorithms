package array.lectures;

public class PrefixSum {

  public static void main(String[] args) {
    int[] arr = {2, 8, 3, 9, 6, 5, 4};
    int start = 1, end = 3;

    int[] prefixSum = getPrefixSumArray(arr);
    System.out.println(getSum(prefixSum, start, end));

    int[] prefixSum1 = getPrefixSumArray1(arr);
    System.out.println(getSum(prefixSum1, start, end));
  }

  // Efficient Approach
  private static int[] getPrefixSumArray(int[] arr) {
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    return prefixSum;
  }

  // Naive Approach
  private static int[] getPrefixSumArray1(int[] arr) {
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int sum = 0;
      for (int j = 0; j <= i; j++) {
        sum += arr[j];
      }

      prefixSum[i] = sum;
    }

    return prefixSum;
  }

  private static int getSum(int[] prefixSum, int l, int r) {
    return prefixSum[r] - prefixSum[l - 1];
  }
}
