package sorting.lectures;

import java.util.Arrays;

public class LomutoPartition {

  /**
   * <strong>Explanation</strong>
   * The Lomuto partition algorithm is a technique used in QuickSort to rearrange elements in an array such that elements less than a chosen pivot are
   * moved to the left of the pivot and elements greater than the pivot are moved to the right. The pivot is usually chosen as the last element of the
   * subarray.
   * <p>
   * This implementation involves iterating over the array with two pointers: one (i) that tracks the end of the region of elements less than the
   * pivot, and another (j) that iterates through the array. When a smaller element than the pivot is found, the i pointer is moved forward, and that
   * element is swapped into the correct position. After the iteration, the pivot element is swapped into its correct position, which is immediately
   * after the last element less than the pivot. The method then returns the index of the pivot element, which is now correctly placed, and this index
   * is used to further divide the array into subarrays for subsequent QuickSort iterations.
   * </p>
   * <p>
   * <strong>NOTE</strong>
   * If we get a scenario to pivot around an element which is not the last element in the array. In this case, first swap the ith element with the
   * last element and then use the last element as the pivot element.
   * </p>
   *
   * @param args
   */
  public static void main(String[] args) {

    int[] arr = {10, 80, 30, 90, 40, 50, 70};
    System.out.println(partition(arr, 0, arr.length - 1));
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {70, 60, 80, 40, 30};
    System.out.println(partition(arr1, 0, arr1.length - 1));
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {30, 40, 20, 50, 80};
    System.out.println(partition(arr2, 0, arr2.length - 1));
    System.out.println(Arrays.toString(arr2));
  }

  // Method to partition an array using the Lomuto partition scheme.
  private static int partition(int[] arr, int low, int high) {
    // Select the last element as the pivot.
    int pivot = arr[high];
    // 'i' is used to track the index of the smaller element.
    // It is initially set to one position before the start of the subarray.
    int i = low - 1;

    // Iterate over the subarray, excluding the pivot element.
    // We exclude the last element at position high because that is the pivot element and the if condition would
    // always be false for it. Hence, no need to run the loop for it.
    for (int j = low; j < high; j++) {
      // If the current element is smaller than the pivot,
      // increment 'i' and swap the elements at 'i' and 'j'.
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    // After the loop, 'i' is at the position of the last element smaller than the pivot.
    // Swap the pivot with the element at 'i + 1', placing the pivot at its correct sorted position.
    swap(arr, i + 1, high);

    // Return the index of the pivot element, now placed at its correct sorted position.
    return i + 1;
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
