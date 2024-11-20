package sorting.lectures;

import java.util.Arrays;

public class KthSmallestElement {

  public static void main(String[] args) {

    int[] arr = {10, 3, 5, 20};

    System.out.println(kthSmallest(arr, 2));
    System.out.println();
    System.out.println(kthSmallest1(arr, 2));
  }

  // Naive Approach: Sort the array and select the (k - 1)th element.
  private static int kthSmallest(int[] arr, int k) {
    Arrays.sort(arr);
    return arr[k - 1];
  }

  // Efficient Approach: Using quick sort partition algorithm to determine the kth smallest number.
  private static int kthSmallest1(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int pivot = partition(arr, low, high); // Using Lomuto partition.
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

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
