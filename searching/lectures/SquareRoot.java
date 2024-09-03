package searching.lectures;

public class SquareRoot {

  public static void main(String[] args) {
    System.out.println(squareRootIterative(-1));
    System.out.println(squareRootIterative(0));
    System.out.println(squareRootIterative(1));
    System.out.println(squareRootIterative(16));
    System.out.println(squareRootIterative(65536));
    System.out.println(squareRootIterative(4));
    System.out.println(squareRootIterative(10));

    System.out.println(squareRootRecursive(-1, -1, 0, -1));
    System.out.println(squareRootRecursive(0, -1, 0, 0));
    System.out.println(squareRootRecursive(1, -1, 0, 1));
    System.out.println(squareRootRecursive(16, -1, 0, 16));
    System.out.println(squareRootRecursive(65536, -1, 0, 65536));
    System.out.println(squareRootRecursive(4, -1, 0, 4));
    System.out.println(squareRootRecursive(10, -1, 0, 10));
  }

  /**
   * Iteratively calculates the integer square root of a given number.
   *
   * @param num The number for which to find the square root.
   * @return The integer square root of the given number.
   */
  static int squareRootIterative(int num) {
    int start = 0;  // Initialize the starting point for the search.
    int end = num;  // Initialize the ending point for the search.
    int ans = -1;   // Initialize the variable to store the result.

    // While the search range is valid (start index doesn't exceed the end index):
    while (start <= end) {
      // Calculate the middle value of the current search range.
      int mid = (start + end) / 2;
      int sqr = mid * mid; // Calculate the square of the middle value.

      // If the square of the middle value is greater than the given number,
      // update the 'end' index to search in the left half of the range.
      if (sqr > num) {
        end = mid - 1;
      }
      // If the square of the middle value is less than the given number:
      else if (sqr < num) {
        // Update the 'ans' variable to store the current candidate for the square root,
        // and update the 'start' index to search in the right half of the range.
        // This is done because if the number is not a perfect square, then we want to capture
        // the number having maximum square less than 'num'.
        ans = mid;
        start = mid + 1;
      }
      // If the square of the middle value matches the given number, return the middle value
      // as it represents the integer square root.
      else {
        return mid;
      }
    }

    // Return the calculated integer square root, which is stored in the 'ans' variable.
    return ans;
  }

  /**
   * Recursive approach
   */
  static int squareRootRecursive(int N, int root, int start, int end) {
    if (start > end) {
      return root;
    }

    int mid = (start + end) / 2;
    if (mid * mid == N) {
      return mid;
    } else if (mid * mid > N) {
      end = mid - 1;
    } else {
      root = mid;
      start = mid + 1;
    }

    return squareRootRecursive(N, root, start, end);
  }
}
