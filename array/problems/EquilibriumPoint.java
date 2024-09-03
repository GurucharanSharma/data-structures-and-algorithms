package array.problems;

public class EquilibriumPoint {

  public static void main(String[] args) {
    long[] arr = {1, 3, 5, 2, 2};

    System.out.println(equilibriumPoint(arr));
  }

  // arr: input array
  // Function to find equilibrium point in the array.
  public static int equilibriumPoint(long[] arr) {
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
}
