package searching.lectures;

public class CeilingOfANumber {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The ceiling method is used to find the smallest element in a sorted array that is greater than or equal to a given number (num). It utilizes a
   * binary search approach to efficiently locate the ceiling value within the array. The method initializes start as the start index of the array and
   * end as the end index of the array. It also initializes a variable ceil to store the ceiling value, which is initially set to 0. The search
   * continues as long as the start index is less than or equal to the end index, ensuring that the search range is valid. Inside the loop, it
   * calculates the middle index, mid, by averaging the start and end indices. It checks if the element at the mid index is equal to the specified
   * number. If a match is found, the method immediately returns this element as the ceiling value. If the element at the mid index is greater than
   * the specified number, it updates the ceil value to this element and adjusts the end index to search for smaller elements on the left side of the
   * array. If the element at the mid index is smaller than the specified number, it adjusts the start index to search for larger elements on the
   * right side of the array. This process continues, repeatedly narrowing down the search range based on whether the element at the middle index is
   * greater or smaller than the specified number. The method returns the ceil value, which is the smallest element in the array that is greater than
   * or equal to the specified number.
   */
  public static void main(String[] args) {

    int[] arr = new int[]{12, 67, 90, 100, 300, 399};
    System.out.println(ceiling(arr, 95));

  }

  /**
   * Finds the smallest element in the array that is greater than or equal to the given number.
   *
   * @param arr The input sorted array in which to find the ceiling value.
   * @param num The number for which to find the ceiling value.
   * @return The ceiling value, i.e., the smallest element greater than or equal to the specified number.
   */
  private static int ceiling(int[] arr, int num) {
    int start = 0;              // Initialize the start index for the array.
    int end = arr.length - 1;   // Initialize the end index for the array.
    int ceil = 0;               // Initialize a variable to store the ceiling value.

    // Continue searching as long as the start index is less than or equal to the end index.
    while (start <= end) {
      int mid = (start + end) / 2;  // Calculate the middle index within the array.

      if (arr[mid] == num) {
        return arr[mid];  // If the element at the middle index is equal to the specified number, return it as the ceiling value.
      } else if (arr[mid] > num) {
        ceil = arr[mid];    // If the element at the middle index is greater than the specified number, update the ceiling value.
        end = mid - 1;       // Adjust the end index to search for smaller elements on the left side of the array.
      } else {
        start = mid
            + 1;     // If the element at the middle index is smaller than the specified number, adjust the start index to search on the right side.
      }
    }

    return ceil;  // Return the ceiling value, which is the smallest element greater than or equal to the specified number.
  }

}
