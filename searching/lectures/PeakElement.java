package searching.lectures;

public class PeakElement {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The method searches for a peak element in an array, which is an element that is greater than or equal to its neighboring elements. It initializes
   * the start and end indices for the search, covering the entire array. It enters a while loop that continues as long as the start index is less
   * than or equal to the end index. It calculates the middle index of the current search range. It checks if the element at the middle index is a
   * peak element by comparing it to its neighboring elements. If the middle element is a peak element, the method returns its index. If the element
   * at the middle index is less than its left neighbor, it updates the 'end' index to search in the left half, as the peak element is expected to be
   * on the left side. Otherwise, it updates the 'start' index to search in the right half. If no peak element is found during the search, the method
   * returns -1. This approach efficiently identifies a peak element in the array using a binary search-like approach.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{1, 7, 5, 9, 2, 3};

    System.out.println(peakElement(arr));
    System.out.println();
    System.out.println(peakElement1(arr));
  }

  // Naive Approach
  private static int peakElement1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 && arr[i] > arr[i + 1]) {
        return arr[i];
      }

      if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
        return arr[i];
      }

      if (i > 0 && i < arr.length - 1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        return arr[i];
      }
    }

    return -1;
  }

  // Efficient Approach
  static int peakElement(int[] arr) {
    int start = 0;                // Initialize the start index for the search.
    int end = arr.length - 1;     // Initialize the end index for the search.

    // Continue searching as long as the start index is less than or equal to the end index.
    while (start <= end) {
      int mid = (start + end) / 2;  // Calculate the middle index of the current search range.

      // Check if the element at the middle index is a peak element by comparing it to its neighbors.
      if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == end || arr[mid + 1] <= arr[mid])) {
        return mid;  // If it's a peak element, return its index.
      }

      // If the element at the middle index is less than its left neighbor, update 'end' to search in the left half.
      if (mid > 0 && arr[mid - 1] >= arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;  // Otherwise, update 'start' to search in the right half.
      }
    }

    // If no peak element is found in the array, return -1.
    return -1;
  }
}
