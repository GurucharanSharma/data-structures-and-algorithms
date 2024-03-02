package searching.lectures;

public class IndexOfFirstOccurrenceInSorted {

  public static void main(String[] args) {
    int[] arr = new int[]{5, 10, 10, 15, 20, 20, 20};
    int num = 0;
    System.out.println(searchIterative(arr, num));
    System.out.println(searchRecursive(arr, num, 0, arr.length - 1));
  }

  /**
   * Iteratively searches for the first occurrence of a specified number in a sorted integer array.
   *
   * @param arr The sorted array in which to search.
   * @param num The number to search for.
   * @return The index of the first occurrence of the specified number in the array, or -1 if the number is not found.
   */
  static int searchIterative(int[] arr, int num) {
    // Initialize start and end indices to cover the entire array.
    int start = 0;
    int end = arr.length - 1;

    // While the search range is valid (start index doesn't exceed the end index):
    while (start <= end) {
      // Calculate the middle index of the current search range.
      int mid = (start + end) / 2;

      // If the middle element matches the desired number:
      if (arr[mid] == num) {
        // Check if it's the first occurrence by comparing with the previous element.
        // If it's the first occurrence, return its index.
        // Otherwise, continue searching in the left half of the array by updating the 'end' index.
        if (mid == start || arr[mid - 1] != arr[mid]) {
          return mid;
        } else {
          end = mid - 1;
        }
      }
      // If the middle element is less than the desired number, search in the right half
      // by updating the 'start' index to mid + 1.
      else if (arr[mid] < num) {
        start = mid + 1;
      }
      // If the middle element is greater than the desired number, search in the left half
      // by updating the 'end' index to mid - 1.
      else {
        end = mid - 1;
      }
    }

    // If the number is not found, return -1.
    return -1;
  }

  /**
   * Recursively searches for the first occurrence of a specified number in a sorted integer array.
   *
   * @param arr   The sorted array in which to search.
   * @param num   The number to search for.
   * @param start The index where the search begins (initially 0 for the entire array).
   * @param end   The index where the search ends (initially the last index of the array).
   * @return The index of the first occurrence of the specified number in the array, or -1 if the number is not found.
   */
  static int searchRecursive(int[] arr, int num, int start, int end) {
    // Base case: If the start index is greater than the end index, the number is not found.
    if (start > end) {
      return -1;
    }

    // Calculate the middle index of the current search range.
    int mid = (start + end) / 2;

    // If the middle element matches the desired number:
    if (arr[mid] == num) {
      // Check if it's the first occurrence by comparing with the previous element.
      // If it's the first occurrence, return its index.
      // Otherwise, continue searching in the left half of the array.
      if (mid == start || arr[mid] != arr[mid - 1]) {
        return mid;
      } else {
        return searchRecursive(arr, num, start, mid - 1);
      }
    }
    // If the middle element is less than the desired number, search in the right half.
    else if (arr[mid] < num) {
      return searchRecursive(arr, num, mid + 1, end);
    }
    // If the middle element is greater than the desired number, search in the left half.
    else {
      return searchRecursive(arr, num, start, mid - 1);
    }
  }
}
