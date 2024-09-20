package searching.problems;

public class CountOnlyRepeated {

  public static void main(String[] args) {
    long[] arr = {1L, 2L, 3L, 4L, 5L, 5L};

    Pair pair = findRepeating2(arr, arr.length);
    System.out.println(pair.x + " " + pair.y);
  }

  //Function to find repeated element and its frequency.
  private static Pair findRepeating(long[] arr, int n) {
    if ((n - (arr[n - 1] - arr[0])) == 1) {
      return new Pair(-1L, -1L);
    }

    int start = 0;
    int end = n - 1;

    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] >= (mid + arr[0])) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return new Pair(arr[start], (n - (arr[n - 1] - arr[0])));
  }

  private static Pair findRepeating1(long[] arr, int n) {
    if ((arr[n - 1] - arr[0]) == (n - 1)) { // no repetitions in the array
      return new Pair(-1, -1);
    }

    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] - arr[0] >= mid) { // no repetition on the left side as all the indexes are in order
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    // Finally, the start will contain the element which is a duplicate
    return new Pair(arr[start], lastIndex(arr, n, arr[start]) - firstIndex(arr, n, arr[start]) + 1);
  }

  static int firstIndex(long[] arr, int n, Long num) {
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] == num) {
        if (mid == 0 || arr[mid - 1] != arr[mid]) {
          return mid;
        }

        end = mid - 1;
      } else if (arr[mid] > num) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }

  static int lastIndex(long[] arr, int n, Long num) {
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] == num) {
        if (mid == n - 1 || arr[mid + 1] != arr[mid]) {
          return mid;
        }

        start = mid + 1;
      } else if (arr[mid] < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return -1;
  }

  // Function to find repeated element and its frequency.
  static Pair findRepeating2(long[] arr, int n) {
    int start = 0;
    int end = n - 1;

    if ((end) == (arr[end] - arr[0])) {
      // no repetition
      return new Pair(-1, -1);
    }

    while (start <= end) {

      int mid = start + (end - start) / 2;

      if ((mid) == (arr[mid] - arr[0])) {
        // No repetition in the left half
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return new Pair(arr[start], n - (arr[n - 1] - arr[0]));
  }

  // Pair Class
  private static class Pair {

    long x;
    long y;

    Pair(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

}
