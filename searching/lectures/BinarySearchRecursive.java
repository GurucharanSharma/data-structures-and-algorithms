package searching.lectures;

public class BinarySearchRecursive {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(search(arr, 0, 0, arr.length - 1));
  }

  static int search(int[] arr, int num, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = (start + end) / 2;
    if (arr[mid] == num) {
      return mid;
    } else if (arr[mid] > num) {
      return search(arr, num, start, mid - 1);
    } else {
      return search(arr, num, mid + 1, end);
    }
  }
}
