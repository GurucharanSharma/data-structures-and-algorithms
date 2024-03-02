package sorting.lectures;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {

  public static void main(String[] args) {

    int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 0, 1, 1, 2, 2, 0, 1};
    sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 0, 1, 1, 2, 2, 0, 1};
    sort1(arr1);
    System.out.println(Arrays.toString(arr1));
  }

  private static void sort(int[] arr) {
    // Initialize three pointers: 'start', 'mid', and 'end'.
    // 'start' is used to keep track of the position to place 0s,
    // 'mid' is used to scan through the array,
    // 'end' is used to keep track of the position to place 2s.
    int start = 0;
    int mid = 0;
    int end = arr.length - 1;

    // Continue looping until 'mid' pointer crosses 'end' pointer.
    while (mid <= end) {
      // Case 1: The element at 'mid' is 0.
      if (arr[mid] == 0) {
        // Swap the element at 'mid' with the element at 'start'.
        // This moves 0 to the beginning of the array.
        swap(arr, start, mid);
        // Increment 'start' to the next position.
        start++;
        // Move 'mid' to the next element.
        mid++;
      }
      // Case 2: The element at 'mid' is 1.
      else if (arr[mid] == 1) {
        // Just move 'mid' to the next element.
        // 1s will be automatically placed in the middle.
        mid++;
      }
      // Case 3: The element at 'mid' is 2.
      else {
        // Swap the element at 'mid' with the element at 'end'.
        // This moves 2 to the end of the array.
        swap(arr, mid, end);
        // Only the end element is a surety that it is 2. We have no idea about the element
        // that has been replaced at the mid-position. Hence, we need to check the mid again
        // in the next iteration of the loop.
        // Decrement 'end' to the next position from the end.
        end--;
      }
    }
  }

  private static void sort1(int[] arr) {
    int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;

    // Count the number of 0s, 1s and 2s in the array
    for (i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case 0:
          cnt0++;
          break;
        case 1:
          cnt1++;
          break;
        case 2:
          cnt2++;
          break;
      }
    }

    // Update the array
    i = 0;

    // Store all the 0s in the beginning
    while (cnt0 > 0) {
      arr[i++] = 0;
      cnt0--;
    }

    // Then all the 1s
    while (cnt1 > 0) {
      arr[i++] = 1;
      cnt1--;
    }

    // Finally all the 2s
    while (cnt2 > 0) {
      arr[i++] = 2;
      cnt2--;
    }
  }

  // Method to swap two elements in the array.
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
