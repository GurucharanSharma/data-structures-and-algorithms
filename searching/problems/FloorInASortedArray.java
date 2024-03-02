package searching.problems;

public class FloorInASortedArray {

  public static void main(String[] args) {

    long[] arr = new long[]{1, 2, 8, 10, 11, 12, 19};
    System.out.println(findFloor(arr, arr.length, 5));
  }

  // Function to find floor of x
  // arr: input array
  // n is the size of array
  private static int findFloor(long[] arr, int n, long x) {
    int start = 0;
    int end = n - 1;
    int res = -1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] > x) {
        end = mid - 1;
      } else {
        res = mid;
        start = mid + 1;
      }
    }

    return res;
  }
}
