package sorting.lectures;

import java.util.Arrays;

public class CycleSort {

  public static void main(String[] args) {

    int[] arr = {20, 40, 50, 10, 30};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    // Iterate through the array, starting from the first element and going up to the second-to-last element.
    for (int start = 0; start < arr.length - 1; start++) {
      // 'item' is the value to be placed at the correct position.
      int item = arr[start];
      // 'index' represents the correct position where 'item' should be placed.
      int index = start;

      // Count the number of elements smaller than 'item' in the array, to find the correct position of 'item'.
      // 'i' is initialised to 'start + 1' because 'index' is initialised to start. We find the position to the
      // right of start that we have to move the item to put it in its right place. All the elements before the
      // index 'index' are already in their right place.
      for (int i = start + 1; i < arr.length; i++) {
        if (arr[i] < item) {
          index++;
        }
      }

      // Swap 'item' with the element at its correct position.
      // After the swap, 'item' will hold the value that was at the position where 'item' was placed.
      item = swap(arr, index, item);

      // If the item was already at the correct position, move to the next iteration.
      while (index != start) {
        // Reset index to start position.
        index = start;
        // Again count the number of elements smaller than the current 'item' to find its correct position.
        for (int i = start + 1; i < arr.length; i++) {
          if (arr[i] < item) {
            index++;
          }
        }

        // Swap 'item' with the element at its correct position.
        item = swap(arr, index, item);
      }
    }
  }

  // Method to swap the current 'item' with the element at its correct position.
  // Returns the value that was at the position where 'item' was placed.
  private static int swap(int[] arr, int index, int item) {
    int temp = arr[index];
    arr[index] = item;
    return temp;
  }

}
