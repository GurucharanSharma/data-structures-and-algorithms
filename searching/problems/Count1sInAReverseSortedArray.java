package searching.problems;

public class Count1sInAReverseSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 1, 0, 0, 0, 0, 0, 0};
    System.out.println(countOnes(arr, arr.length));
  }

  // Function to count number of ones in the binary array
  // N: size of array
  // arr[]: input array
  public static int countOnes(int[] arr, int N) {
    return lastIndexOf1(arr, N) + 1;
  }

  private static int lastIndexOf1(int[] arr, int N) {
    int start = 0;
    int end = N - 1;
    int index = -1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == 1) {
        if (mid == end || arr[mid + 1] != arr[mid]) {
          return mid;
        } else {
          index = mid;
          start = mid + 1;
        }
      } else if (arr[mid] < 1) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return index;
  }
}
