package searching.lectures;

public class Count1sInASortedBinaryArray {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 1, 1, 1, 1, 1};
    System.out.println(arr.length - firstIndexOf1(arr, 1, 0, arr.length - 1));
  }

  /**
   * Recursively finds the index of the first occurrence of a specified number in a sorted integer array.
   *
   * @param arr   The sorted array in which to search.
   * @param num   The number to search for.
   * @param start The index where the search begins (initially 0 for the entire array).
   * @param end   The index where the search ends (initially the last index of the array).
   * @return The index of the first occurrence of the specified number in the array, or -1 if the number is not found.
   */
  static int firstIndexOf1(int[] arr, int num, int start, int end) {
    // Base case: If the start index is greater than the end index, the number is not found.
    if (start > end) {
      return -1;
    }

    // Calculate the middle index of the current search range.
    int mid = (start + end) / 2;

    // If the middle element is greater than the desired number, search in the left half
    // by updating the 'end' index to mid - 1.
    if (arr[mid] > num) {
      return firstIndexOf1(arr, num, start, mid - 1);
    }
    // If the middle element is less than the desired number, search in the right half
    // by updating the 'start' index to mid + 1.
    else if (arr[mid] < num) {
      return firstIndexOf1(arr, num, mid + 1, end);
    }
    // If the middle element matches the desired number:
    else {
      // Check if it's the first occurrence by comparing with the previous element.
      // If it's the first occurrence, return its index.
      // Otherwise, continue searching in the left half of the array by updating the 'end' index.
      if (mid == start || arr[mid - 1] != num) {
        return mid;
      } else {
        return firstIndexOf1(arr, num, start, mid - 1);
      }
    }
  }
}
