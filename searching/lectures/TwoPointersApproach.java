package searching.lectures;

public class TwoPointersApproach {


  /**
   * <strong>Explanation</strong>
   * <p>
   * The method aims to find a pair of elements in the array arr whose sum equals the specified number num. It initializes two indices, i and j, which
   * represent the starting and ending positions of the array. The method uses a two-pointer approach with i and j, and it continues searching as long
   * as i is less than j. If the sum of elements at indices i and j is equal to num, it indicates a valid pair, and the method returns true. If the
   * sum is greater than num, it means that the sum needs to be reduced, so the j index is decremented to consider a smaller value. If the sum is less
   * than num, it means that the sum needs to be increased, so the i index is incremented to consider a larger value. If no valid pair is found during
   * the search, the method returns false. This approach efficiently checks for the existence of a pair with the specified sum in the array while
   * minimizing unnecessary comparisons.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{2, 4, 8, 9, 11, 12, 20, 30};

    System.out.println(isPair(arr, 23));
    System.out.println(isPair(arr, 2));
    System.out.println(isPair(arr, 4));
    System.out.println(isPair(arr, 32));
    System.out.println(isPair(arr, 39));
    System.out.println(isPair(arr, 50));
  }

  /**
   * Checks if there is a pair of elements in the array that sums up to the specified number.
   *
   * @param arr The input array in which to search for a pair.
   * @param num The target sum to be matched.
   * @return True if a pair of elements is found that sums up to 'num,' false otherwise.
   */
  static boolean isPair(int[] arr, int num) {
    int i = 0;                  // Initialize the 'i' index to point to the start of the array.
    int j = arr.length - 1;     // Initialize the 'j' index to point to the end of the array.

    // Continue searching as long as 'i' is less than 'j.'
    while (i < j) {
      // If the sum of elements at indices 'i' and 'j' equals the specified number, a pair is found.
      if (arr[i] + arr[j] == num) {
        return true;  // Return true to indicate the presence of a valid pair.
      } else if (arr[i] + arr[j] > num) {
        j--;  // If the sum is greater than 'num,' decrement 'j' to reduce the sum.
      } else {
        i++;  // If the sum is less than 'num,' increment 'i' to increase the sum.
      }
    }

    return false;  // Return false if no valid pair is found.
  }

}
