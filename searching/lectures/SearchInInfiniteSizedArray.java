package searching.lectures;

/**
 * Unbounded Binary Search
 */
public class SearchInInfiniteSizedArray {

  /**
   * <strong>Explanation</strong><br>
   * The method begins by checking if the specified number is present at the first index of the infinite array. If it is, the method returns 0. If the
   * number is not found at the first index, the method enters a loop where it tries to determine a range for a binary search. It doubles the start
   * index until it finds a point where the value at infinite[start * 2] is greater than the specified number. Once this range is determined, it
   * breaks out of the loop. After the range is established, the method proceeds to perform a binary search within this range. It calculates the
   * middle index as (start + end) / 2 and compares the element at the middle index with the specified number. If the middle element matches the
   * specified number, the method returns the index. If the middle element is less than the specified number, it searches in the right half by
   * updating the start index. If the middle element is greater than the specified number, it searches in the left half by updating the end index. If
   * the number is not found within the range, the method returns -1 to indicate that the number is not present in the array.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 18, 20, 22, 28, 30};

    System.out.println("Naive");
    System.out.println(searchNaive(arr, 5));
    System.out.println(searchNaive(arr, 10));
    System.out.println(searchNaive(arr, 1));
    System.out.println(searchNaive(arr, 0));
    System.out.println(searchNaive(arr, 12));

    System.out.println("Efficient");
    System.out.println(searchEfficient(arr, 5));
    System.out.println(searchEfficient(arr, 10));
    System.out.println(searchEfficient(arr, 1));
    System.out.println(searchEfficient(arr, 0));
    System.out.println(searchEfficient(arr, 12));
  }

  /**
   * Searches for a specified number in an infinite array.
   *
   * @param infinite An infinite array in which to search.
   * @param num      The number to search for.
   * @return The index of the specified number in the infinite array, or -1 if the number is not found.
   */
  static int searchNaive(int[] infinite, int num) {
    int i = 0; // Initialize the index to 0.

    // Continue searching indefinitely (since 'infinite' is an infinite array).
    while (true) {
      // If the element at the current index matches the specified number, return the index.
      if (infinite[i] == num) {
        return i;
      }
      // If the element at the current index is greater than the specified number,
      // return -1, as it indicates that the number is not present in the array.
      if (infinite[i] > num) {
        return -1;
      }
      // Move to the next index to continue searching in the infinite array.
      i++;
    }
  }

  /**
   * Efficiently searches for a specified number in an infinite array.
   *
   * @param infinite An infinite array in which to search.
   * @param num      The number to search for.
   * @return The index of the specified number in the infinite array, or -1 if the number is not found.
   */
  static int searchEfficient(int[] infinite, int num) {
    // Check if the first element of the array matches the specified number.
    if (infinite[0] == num) {
      return 0;
    }

    int start = 1;  // Initialize the 'start' variable for binary search.
    int end;        // Initialize the 'end' variable.

    // Search for an appropriate range for binary search by doubling 'start'.
    while (true) {
      if (infinite[start * 2] <= num) {
        start = start * 2;
      } else {
        end = start * 2;
        break;
      }
    }

    // Perform binary search within the determined range.
    while (start <= end) {
      int mid = (start + end) / 2;
      if (infinite[mid] == num) {
        return mid;       // If the middle element matches the specified number, return its index.
      } else if (infinite[mid] < num) {
        start = mid + 1;  // If the middle element is less than the specified number, search in the right half.
      } else {
        end = mid - 1;    // If the middle element is greater than the specified number, search in the left half.
      }
    }

    return -1; // If the number is not found in the array, return -1.
  }

}
