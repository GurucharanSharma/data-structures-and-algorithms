package searching.lectures;

public class TernarySearch {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The search method implements a ternary search algorithm to find the index of a specified number (num) in a sorted array (arr). It uses two
   * pointers, start and end, to maintain a search range within the array. The search continues as long as the start index is less than or equal to
   * the end index. Inside the loop, it calculates two midpoints, mid1 and mid2, which divide the search range into three roughly equal parts. It
   * compares the number with the elements at these midpoints to check if a match is found. If a match is found, the method returns the index of the
   * matching element. If the number is greater than the element at mid2, it adjusts the start index to mid2 + 1, effectively excluding the first
   * one-third of the search range. If the number is smaller than the element at mid1, it adjusts the end index to mid1 - 1, effectively excluding the
   * last one-third of the search range. If the number does not match either mid1 or mid2, it adjusts both start and end indices to the middle
   * one-third of the search range. The process continues in this manner, repeatedly dividing the search range into three parts and adjusting the
   * indices accordingly. If the number is not found within the search range, the method returns -1 to indicate that the number is not present in the
   * array. Ternary search is similar to binary search but divides the search range into three parts instead of two, potentially reducing the number
   * of iterations required to find the number.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{7, 12, 19, 24, 31, 48, 51, 63, 67, 73, 81, 92};

    System.out.println(search(arr, 19));
    System.out.println(search(arr, 0));
    System.out.println(search(arr, 24));
    System.out.println(search(arr, 92));
    System.out.println(search(arr, 7));
  }

  /**
   * Performs a ternary search to find the index of a specified number in a sorted array.
   *
   * @param arr The input sorted array in which to search for the number.
   * @param num The number to be searched for.
   * @return The index of the number in the array, or -1 if not found.
   */
  private static int search(int[] arr, int num) {
    int start = 0;                      // Initialize the start index for the array.
    int end = arr.length - 1;           // Initialize the end index for the array.

    // Continue the search as long as the start index is less than or equal to the end index.
    while (start <= end) {
      int mid1 = start + (end - start) / 3;   // Calculate the first one-third point within the array.
      int mid2 = end - (end - start) / 3;     // Calculate the two-thirds point within the array.

      if (num == arr[mid1]) {
        return mid1;  // If the number matches the element at mid1, return the index of mid1.
      } else if (num == arr[mid2]) {
        return mid2;  // If the number matches the element at mid2, return the index of mid2.
      } else if (num > arr[mid2]) {
        start = mid2 + 1;  // If the number is greater than the element at mid2, adjust the start index accordingly.
      } else if (num < arr[mid1]) {
        end = mid1 - 1;    // If the number is smaller than the element at mid1, adjust the end index accordingly.
      } else {
        start = mid1 + 1;  // If the number is neither greater nor smaller than elements at mid1 and mid2, adjust both start and end indices.
        end = mid2 - 1;
      }
    }

    return -1;  // Return -1 if the number is not found in the array.
  }

}
