package array.problems;

public class TrappingRainWater {

  public static void main(String[] args) {
//    int[] arr = {3, 0, 0, 2, 0, 4};
//    int[] arr = {7, 4, 0, 9};
    int[] arr = {6, 9, 9};

    System.out.println(trappingWater(arr, arr.length));
  }

  // arr: input array
  // n: size of array
  // Function to find the trapped water between the blocks.
  static long trappingWater(int[] arr, int n) {
    int[] lMax = new int[n];
    int[] rMax = new int[n];

    lMax[0] = arr[0];
    for (int i = 1; i < n; i++) {
      lMax[i] = Math.max(lMax[i - 1], arr[i]);
    }

    rMax[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rMax[i] = Math.max(rMax[i + 1], arr[i]);
    }

    long res = 0;
    for (int i = 0; i < n; i++) {
      res += (Math.min(lMax[i], rMax[i]) - arr[i]);
    }

    return res;
  }
}
