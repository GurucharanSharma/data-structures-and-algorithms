package searching.lectures;

public class AllocateMinimumPages {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The minimumPages method aims to allocate a minimum number of pages to 'n' students while ensuring that no student receives more pages than a
   * specified maximum ('mid'). It first calculates the total number of pages in all the books and finds the book with the maximum number of pages.
   * The method then performs a binary search to find the minimum number of pages to allocate while meeting the criteria. The isPossible method checks
   * if it's possible to allocate pages to students based on the current 'mid' value. It iterates through the array, allocating pages to students and
   * checking if the criteria are met. If the criteria are met, the minimumPages method updates the result and narrows the binary search range
   * accordingly. The binary search continues until the start and end ranges meet. The result represents the minimum number of pages that need to be
   * allocated to each student, minimizing the maximum number of pages allocated to any student. This approach efficiently determines the minimum
   * pages to allocate, taking into account the constraints and optimizing the allocation for 'n' students.
   */
  public static void main(String[] args) {
    int[] arr = new int[]{12, 34, 67, 90};

    System.out.println(minimumPages(arr, 5));
  }

  /**
   * Allocates minimum pages to 'n' students while minimizing the maximum number of pages allocated to any student.
   *
   * @param arr An array containing the number of pages in each book.
   * @param n   The number of students available to read the books.
   * @return The minimum number of pages that need to be allocated to each student.
   */
  static int minimumPages(int[] arr, int n) {
    int sum = 0;         // Initialize a variable to calculate the total number of pages.
    int max = -1;        // Initialize a variable to find the book with the maximum number of pages.

    // Iterate through the array to calculate the total number of pages and find the maximum number of pages.
    for (int j : arr) {
      sum += j;
      max = Math.max(max, j);
    }

    int res = -1;           // Initialize a result variable to store the minimum number of pages to allocate.
    int start = max;       // Set the start range for binary search as the maximum number of pages.
    // Minimum number of pages someone has to read is the maximum pages amongst all the books.
    int end = sum;         // Set the end range for binary search as the total number of pages.

    // Perform binary search to find the minimum number of pages to allocate while meeting the criteria.
    while (start <= end) {
      int mid = (start + end) / 2;  // Calculate the middle value for the binary search.

      // Check if it's possible to allocate pages such that no student gets more than 'mid' pages.
      if (isFeasible(arr, n, mid)) {
        res = mid;       // Update the result to the current middle value.
        end = mid - 1;   // Adjust the end range for binary search to the left.
      } else {
        start = mid + 1;  // Adjust the start range for binary search to the right.
      }
    }

    return res;  // Return the minimum number of pages to allocate to each student.
  }

  /**
   * Checks if it's possible to allocate pages to students in a way that no student gets more than 'mid' pages.
   *
   * @param arr The array containing the number of pages in each book.
   * @param n   The number of students available to read the books.
   * @param mid The maximum number of pages that can be allocated to any student.
   * @return True if it's possible to allocate pages as per the criteria, false otherwise.
   */
  private static boolean isFeasible(int[] arr, int n, int mid) {
    int student = 1;    // Initialize a variable to count the number of students.
    int pages = 0;      // Initialize a variable to keep track of the pages allocated to the current student.

    // Iterate through the array to check if it's possible to allocate pages according to the criteria.
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] + pages <= mid) {
        pages += arr[i];  // Allocate the pages to the current student.
      } else {
        student++;    // Move to the next student.
        if (student > n || arr[i] > mid) {
          return false;  // If the number of students exceeds the available students or a book has more pages than 'mid,' it's not possible.
        }

        pages = arr[i];  // Start allocating pages to the next student with the current book.
      }
    }

    return (student <= n);  // Return true if it's possible to allocate pages as per the criteria.
  }

}
