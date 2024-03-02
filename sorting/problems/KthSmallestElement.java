package sorting.problems;

public class KthSmallestElement {

  public static void main(String[] args) {
    testKthSmallestElement1();
    testKthSmallestElement2();
  }

  //Function to find the kth smallest element in the array.
  private static int kthSmallest(int[] arr, int n, int k) {
    // Your code here
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int pivot = partition(arr, low, high);
      if (pivot == k - 1) {
        return arr[pivot];
      } else if (pivot < k - 1) {
        low = pivot + 1;
      } else {
        high = pivot - 1;
      }
    }

    return -1;
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, end);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void testKthSmallestElement1() {
    int[] arr = {3, 5, 4, 2, 9};
    System.out.println(kthSmallest(arr, arr.length, 3));
  }

  private static void testKthSmallestElement2() {
    int[] arr = {4, 3, 7, 6, 5};
    System.out.println(kthSmallest(arr, arr.length, 5));
  }
}
