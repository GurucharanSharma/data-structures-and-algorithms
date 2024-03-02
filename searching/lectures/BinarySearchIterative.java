package searching.lectures;

public class BinarySearchIterative {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(search(arr, 4));
  }

  static int search(int[] arr, int num) {
    int start = 0;
    int end = arr.length - 1;
    int mid = (start + end) / 2;

    while (start <= end) {
      if (arr[mid] == num) {
        return mid;
      } else if (arr[mid] > num) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }

      mid = (start + end) / 2;
    }

    return -1;
  }
}
