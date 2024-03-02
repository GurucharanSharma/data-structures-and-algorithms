package searching.problems;

public class MinimumNumberInSortedRotatedArray {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The minNumber method is designed to find the minimum element in a sorted and rotated array. It employs a binary search approach to efficiently
   * locate the minimum element within the array. The method takes three parameters: the input array arr, the starting index low, and the ending index
   * high, which define the search range. It initializes the min variable to a high value (Integer.MAX_VALUE) to ensure that the initial minimum value
   * can be updated during the search. The loop continues as long as the low index is less than or equal to the high index, ensuring that the search
   * range is valid. Inside the loop, the method calculates the middle index, mid, which represents the midpoint of the current search range. It
   * checks if the left half of the search range (from low to mid) is sorted. If so, it updates the min value with the minimum of the current min
   * value and the element at the low index, representing the minimum element in the left half. The low index is then adjusted to mid + 1 to focus the
   * search on the right half of the array. If the right half of the search range (from mid + 1 to high) is sorted, the method updates the min value
   * with the minimum of the current min value and the element at the mid index, representing the minimum element in the right half. The high index is
   * adjusted to mid - 1 to focus the search on the left half of the array. This process continues, with the search range being narrowed down based on
   * whether the left or right half is sorted. The method returns the min value, which represents the minimum element in the sorted and rotated
   * array.
   */
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(minNumber(arr, 0, arr.length - 1));
  }

  /**
   * Finds the minimum element in a sorted and rotated array.
   *
   * @param arr  The input sorted rotated array in which to find the minimum element.
   * @param low  The starting index of the search range.
   * @param high The ending index of the search range.
   * @return The minimum element in the sorted rotated array.
   */
  private static int minNumber(int[] arr, int low, int high) {
    int min = Integer.MAX_VALUE; // Initialize a variable to store the minimum element, initially set to a high value.

    // Continue searching as long as the 'low' index is less than or equal to the 'high' index.
    while (low <= high) {
      int mid = (low + high) / 2; // Calculate the middle index within the search range.

      if (arr[low] <= arr[mid]) {
        // Left half is sorted
        min = Math.min(min, arr[low]); // Update the minimum value with the minimum of the current minimum and the element at 'low'.
        low = mid + 1; // Adjust the 'low' index to search in the right half.
      } else {
        // Right half is sorted
        min = Math.min(min, arr[mid]); // Update the minimum value with the minimum of the current minimum and the element at 'mid'.
        high = mid - 1; // Adjust the 'high' index to search in the left half.
      }
    }

    return min; // Return the minimum element in the sorted and rotated array.
  }

}
