package array.problems;

public class MinimumAdjacentDifferenceInCircularArray {

  public static void main(String[] args) {
//    int[] Arr = {8, -8, 9, -9, 10, -11, 12};
    int[] Arr = {10, -3, -4, 7, 6, 5, -4, -1};

    System.out.println(minAdjDiff(Arr, Arr.length));
  }

  //Function to find minimum adjacent difference in a circular array.
  // arr[]: input array
  // n: size of array
  public static int minAdjDiff(int[] arr, int n) {
    int diff = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int index = (i + 1) % n;
      diff = Math.min(diff, Math.abs(arr[index] - arr[i]));
    }

    return diff;
  }
}
