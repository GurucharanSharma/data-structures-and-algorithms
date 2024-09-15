package sorting;

import java.util.Arrays;

public class SortingRunner {

  public static void main(String[] args) {
    int[] arr = {4, 9, 2, 5, 8, 10, 6, 2, 3, 10, 9, 9, 6};
    threeWayPartition(arr, 7, 8);
  }

  static void threeWayPartition(int[] array, int a, int b) {
    int start = 0;
    int mid = 0;
    int end = array.length - 1;

    while (mid <= end) {
      if (array[mid] < a) {
        swap(array, start, mid);
        start++;
        mid++;
      } else if (array[mid] >= a && array[mid] <= b) {
        mid++;
      } else {
        swap(array, mid, end);
        end--;
      }
    }

    System.out.println(Arrays.toString(array));
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
