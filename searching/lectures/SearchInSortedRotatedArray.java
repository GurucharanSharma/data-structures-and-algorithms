package searching.lectures;

public class SearchInSortedRotatedArray {

  /**
   * <strong>Explanation</strong><br>
   * This method efficiently searches for a specified number in a sorted and rotated integer array using a modified binary search. It initializes the
   * start and end indices for the search. It enters a while loop that continues as long as the start index is less than or equal to the end index. It
   * calculates the middle index to check if the number at the middle index matches the specified number. If it does, the method returns the index. If
   * the left half is sorted (no rotation in the left half), it checks if the specified number falls within the range of the left half. If yes, it
   * updates the 'end' index to search in the left half; otherwise, it updates the 'start' index to search in the right half. If the right half is
   * sorted (no rotation in the right half), it checks if the specified number falls within the range of the right half. If yes, it updates the
   * 'start' index to search in the right half; otherwise, it updates the 'end' index to search in the left half. If the number is not found in the
   * array, the method returns -1. This approach efficiently handles the search in a rotated sorted array.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{10, 20, 40, 60, 5, 8};
    System.out.println(search(arr, 5));
    System.out.println(search(arr, 10));
    System.out.println(search(arr, 8));
    System.out.println(search(arr, 60));
    System.out.println(search(arr, 1));
  }

  /**
   * Searches for a specified number in a sorted and rotated integer array.
   *
   * @param arr The sorted and rotated array in which to search.
   * @param num The number to search for.
   * @return The index of the specified number in the array, or -1 if the number is not found.
   */
  static int search(int[] arr, int num) {
    int start = 0;                       // Initialize the start index for the search.
    int end = arr.length - 1;            // Initialize the end index for the search.

    // Continue searching as long as the start index is less than or equal to the end index.
    while (start <= end) {
      int mid = (start + end) / 2;     // Calculate the middle index of the current search range.

      // If the number at the middle index matches the specified number, return the index.
      if (arr[mid] == num) {
        return mid;
      }

      if (arr[start] <= arr[mid]) {
        // If the left half is sorted (no rotation in the left half):
        // Check if the specified number falls within the range of the left half.
        if (num >= arr[start] && num < arr[mid]) {
          end = mid - 1;              // Update the 'end' index to search in the left half.
        } else {
          start = mid + 1;            // Update the 'start' index to search in the right half.
        }
      } else {
        // If the right half is sorted (no rotation in the right half):
        // Check if the specified number falls within the range of the right half.
        if (num > arr[mid] && num <= arr[end]) {
          start = mid + 1;            // Update the 'start' index to search in the right half.
        } else {
          end = mid - 1;              // Update the 'end' index to search in the left half.
        }
      }
    }

    // If the number is not found in the array, return -1.
    return -1;
  }

}
