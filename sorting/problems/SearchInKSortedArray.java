package sorting.problems;

public class SearchInKSortedArray {

  public static void main(String[] args) {
    int[] arr = {3, 2, 10, 4, 40};
    int x = 3;

    System.out.println(closer(arr, arr.length, x));
    System.out.println(search(arr, arr.length, x, 1));
  }

  // n: size of array
  // x: element to find
  // Function to find index of element x in the array if it is present.
  // NOTE: Here k is at most 1
  static long closer(int[] arr, int n, long x) {
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (mid > start && arr[mid - 1] == x) {
        return mid - 1;
      } else if (mid < end && arr[mid + 1] == x) {
        return mid + 1;
      } else if (arr[mid] < x) {
        start = mid + 2;
      } else {
        end = mid - 2;
      }
    }

    return -1;
  }

  static long search(int[] arr, int n, long x, int k) {
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (mid > start && arr[mid - 1] == x) {
        return mid - 1;
      } else if (mid < end && arr[mid + 1] == x) {
        return mid + 1;
      } else if (arr[mid] < x) {
        start = mid + (k + 1);
      } else {
        end = mid - (k + 1);
      }
    }

    return -1;
  }
}
