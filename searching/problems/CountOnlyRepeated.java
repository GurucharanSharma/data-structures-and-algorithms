package searching.problems;

public class CountOnlyRepeated {

  public static void main(String[] args) {
    Long[] arr = {1L, 2L, 3L, 4L, 5L, 5L};

    Pair pair = findRepeating(arr, arr.length);
    System.out.println(pair.x + " " + pair.y);
  }

  //Function to find repeated element and its frequency.
  private static Pair findRepeating(Long[] arr, int n) {
    int start = 0;
    int end = n - 1;

    if ((arr.length - (arr[arr.length - 1] - arr[0])) == 1) {
      return new Pair(-1L, -1L);
    }

    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] >= (mid + arr[0])) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return new Pair(arr[start], (arr.length - (arr[arr.length - 1] - arr[0])));
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
