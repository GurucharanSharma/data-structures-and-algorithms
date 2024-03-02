package sorting.lectures;

import java.util.Arrays;

public class HoarePartition {

  public static void main(String[] args) {

    int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
    System.out.println(partition(arr, 0, arr.length - 1));
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {70, 60, 80, 40, 30};
    System.out.println(partition(arr1, 0, arr1.length - 1));
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {30, 40, 20, 50, 80};
    System.out.println(partition(arr2, 0, arr2.length - 1));
    System.out.println(Arrays.toString(arr2));

    int[] arr5 = {30, 40, 20, 50, 80};
    System.out.println(partition1(arr5, 0, arr5.length - 1));
    System.out.println(Arrays.toString(arr5));

    int[] arr3 = {10, 80, 30, 90, 40, 50, 70};
    System.out.println(partition(arr3, 0, arr3.length - 1));
    System.out.println(Arrays.toString(arr3));

    int[] arr4 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    System.out.println(partition1(arr4, 0, arr4.length - 1));
    System.out.println(Arrays.toString(arr4));
  }

  // Method to partition an array using the Hoare partition scheme.
  private static int partition(int[] arr, int low, int high) {
    // Select the first element as the pivot.
    int pivot = arr[low];
    // 'i' starts from the low index.
    int i = low;
    // 'j' starts from the high index.
    int j = high;

    // Continue looping until 'i' and 'j' meet or cross.
    while (i < j) {
      // Increment 'i' as long as elements are less than the pivot.
      // This loop moves 'i' to the right towards elements larger than or equal to the pivot.
      while (arr[i] < pivot) {
        i++;
      }

      // Decrement 'j' as long as elements are greater than the pivot.
      // This loop moves 'j' to the left towards elements smaller than or equal to the pivot.
      while (arr[j] > pivot) {
        j--;
      }

      // If 'i' and 'j' have not crossed, swap elements at 'i' and 'j'.
      // After swapping, increment 'i' and decrement 'j' to continue the partitioning.
      if (i < j) {
        swap(arr, i, j);
        i++;
        j--;
      }
    }

    // Return 'j' as the partition index.
    // At this point, elements to the left of 'j' are less than or equal to the pivot,
    // and elements to the right of 'j' are greater than or equal to the pivot.
    return j;
  }

  private static int partition1(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low - 1;
    int j = high + 1;

    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);

      do {
        j--;
      } while (arr[j] > pivot);

      if (i >= j) {
        return j;
      }

      swap(arr, i, j);
    }
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
