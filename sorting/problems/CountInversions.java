package sorting.problems;

public class CountInversions {

  public static void main(String[] args) {
    testInversionCount1();
    testInversionCount2();
    testInversionCount3();
  }

  // arr[]: Input Array
  // N : Size of the Array arr[]
  //Function to count inversions in the array.
  private static long inversionCount(long[] arr, long N) {
    // Your Code Here
    return count(arr, 0, (int) (N - 1));
  }

  private static long count(long[] arr, int start, int end) {
    long res = 0;
    if (start < end) {
      int mid = start + (end - start) / 2;
      res += count(arr, start, mid);
      res += count(arr, mid + 1, end);
      res += countAndMerge(arr, start, mid, end);
    }

    return res;
  }

  private static long countAndMerge(long[] arr, int start, int mid, int end) {
    int n = mid - start + 1;
    int m = end - mid;

    long[] left = new long[n];
    long[] right = new long[m];

    System.arraycopy(arr, start, left, 0, n);
    System.arraycopy(arr, mid + 1, right, 0, m);

    int i = 0, j = 0, k = start;
    long res = 0;

    while (i < n && j < m) {
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        res += (n - i);
        arr[k++] = right[j++];
      }
    }

    while (i < n) {
      arr[k++] = left[i++];
    }

    while (j < m) {
      arr[k++] = right[j++];
    }

    return res;
  }

  private static void testInversionCount1() {
    long[] arr = {2, 4, 1, 3, 5};
    System.out.println(inversionCount(arr, arr.length));
  }

  private static void testInversionCount2() {
    long[] arr = {2, 3, 4, 5, 6};
    System.out.println(inversionCount(arr, arr.length));
  }

  private static void testInversionCount3() {
    long[] arr = {10, 10, 10};
    System.out.println(inversionCount(arr, arr.length));
  }
}
