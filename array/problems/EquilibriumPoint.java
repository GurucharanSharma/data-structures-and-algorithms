package array.problems;

public class EquilibriumPoint {

  public static void main(String[] args) {
//    long[] arr = {1, 3, 5, 2, 2};
    long[] arr = {1};

    System.out.println(equilibriumPoint(arr));
  }

  // Efficient Approach: Without precalculating prefix sum or suffix sum
  public static int equilibriumPoint(long[] arr) {
    if (arr.length == 1) {
      return 1;
    }

    long sum = 0;
    for (long l : arr) {
      sum = sum + l;
    }

    long prefixSum = arr[0];
    long suffixSum = sum;

    for (int i = 1; i < arr.length; i++) {
      prefixSum = prefixSum + arr[i];
      suffixSum = suffixSum - arr[i - 1];

      if (prefixSum == suffixSum) {
        return i;
      }
    }

    return -1;
  }


  // Efficient Approach: Only using suffix sum array
  private static int equilibriumPoint2(long[] arr) {
    long[] suffixSum = new long[arr.length];
    suffixSum[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + arr[i];
    }

    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
      if (sum == suffixSum[i]) {
        return i + 1;
      }
    }

    return -1;
  }

  // Not a very efficient solution. Uses O(n) auxiliary space.
  // Using both, suffix sum array and prefix sum array
  public static int equilibriumPoint1(long[] arr) {
    if (arr.length == 1) {
      return 1;
    }

    long[] lSum = new long[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        lSum[i] = arr[i];
      } else {
        lSum[i] = lSum[i - 1] + arr[i];
      }
    }

    long[] rSum = new long[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1) {
        rSum[i] = arr[i];
      } else {
        rSum[i] = rSum[i + 1] + arr[i];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        if (0 == rSum[i + 1]) {
          return i + 1;
        }
      } else if (i == arr.length - 1) {
        if (lSum[i - 1] == 0) {
          return i + 1;
        }
      } else if (lSum[i - 1] == rSum[i + 1]) {
        return i + 1;
      }
    }

    return -1;
  }
}
