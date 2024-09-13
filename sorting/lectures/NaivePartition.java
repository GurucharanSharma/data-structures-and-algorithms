package sorting.lectures;

import java.util.Arrays;

public class NaivePartition {

  public static void main(String[] args) {
    testNaivePartition();
    testNaivePartition1();
  }

  private static int partition(int[] arr, int low, int high) {

    int[] temp = new int[high - low + 1];
    int pivot = arr[high];
    int index = 0;

    // Copying all the elements less than pivot in the temp array
    for (int i = low; i <= high; i++) {
      if (arr[i] < pivot) {
        temp[index++] = arr[i];
      }
    }

    // Storing the position of the pivot element
    int position = index;

    // Copying the pivot element into the temp array
    temp[index++] = pivot;

    // Copying all the elements greater than pivot in the temp array
    for (int i = low; i <= high; i++) {
      if (arr[i] > pivot) {
        temp[index++] = arr[i];
      }
    }

    // copying the elements from temp array back to the original array arr.
    if (high + 1 - low >= 0) {
      System.arraycopy(temp, 0, arr, low, high + 1 - low);
    }

    return position;
  }

  private static void testNaivePartition() {
    int[] numbers = {3, 2, 1, 78, 9798, 97};
    int position = partition(numbers, 0, numbers.length - 1);
    System.out.println(Arrays.toString(numbers));
    System.out.println("Pivot position: " + position);
  }

  private static void testNaivePartition1() {
    int[] numbers = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
    int position = partition(numbers, 0, numbers.length - 1);
    System.out.println(Arrays.toString(numbers));
    System.out.println("Pivot position: " + position);
  }
}
