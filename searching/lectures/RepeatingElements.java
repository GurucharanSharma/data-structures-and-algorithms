package searching.lectures;

import java.util.Arrays;

public class RepeatingElements {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The findRepeatingWith0 method is designed to find the repeating number in an array where the numbers in the array start with 0. It uses the
   * Floyd's Tortoise and Hare algorithm to detect a cycle or loop in the array. The method initializes both the 'slow' and 'fast' pointers to the
   * value at the first index plus 1. In the loop, the 'slow' pointer moves one step at a time (by adding 1 to the value at the current index), while
   * the 'fast' pointer moves two steps at a time (by adding 1 to the value at the index pointed by the 'fast' pointer). The loop continues until the
   * 'slow' and 'fast' pointers meet within the loop, indicating the presence of a cycle. After detecting the loop, the 'slow' pointer is reset to the
   * value at the first index plus 1, and both the 'slow' and 'fast' pointers are moved one step at a time. The point at which they meet again
   * represents the entrance to the loop and is the index of the repeating number in the array. To obtain the actual repeating number, the value at
   * the 'slow' pointer is subtracted by 1. The method returns the repeating number as its result.
   * </p>
   * <p>
   * The findRepeatingWith1 method is used to find the repeating number in an array where the numbers start with 1. Similar to the previous method, it
   * employs the Floyd's Tortoise and Hare algorithm to detect a cycle or loop in the array. The method initializes both the 'slow' and 'fast'
   * pointers to the value at the first index. In the loop, the 'slow' pointer moves one step at a time by following the value at the current index,
   * while the 'fast' pointer moves two steps at a time by following the value at the index pointed to by the 'fast' pointer. The loop continues until
   * the 'slow' and 'fast' pointers meet within the loop, indicating the presence of a cycle. After detecting the loop, the 'slow' pointer is reset to
   * the value at the first index, and both the 'slow' and 'fast' pointers move one step at a time. The point at which they meet again represents the
   * entrance to the loop and is the index of the repeating number in the array. The method returns the repeating number as its result. Unlike the
   * previous method, in this case, there's no need to subtract 1 from the result because the numbers in the array start with 1.
   * </p>
   */
  public static void main(String[] args) {
    // When the array contains numbers beginning with 0
    int[] arr1 = {0, 2, 1, 3, 5, 4, 6, 2};
    System.out.println(findRepeating(arr1));
    System.out.println(findRepeating1(arr1));
    System.out.println(findRepeating2(arr1));
    System.out.println(findRepeatingWith0(arr1));

    // When the array contains numbers beginning with 1
    int[] arr2 = {1, 3, 2, 4, 6, 5, 7, 3};
    System.out.println(findRepeating(arr2));
    System.out.println(findRepeating1(arr2));
    System.out.println(findRepeating2(arr2));
    System.out.println(findRepeatingWith1(arr2));
  }

  /**
   * Naive Solution
   * <p>Time Complexity: O(n<sup>2</sup>)</p>
   * <p>Auxiliary Space: O(1)</p>
   */
  static int findRepeating(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] == arr[i]) {
          return arr[i];
        }
      }
    }

    return -1;
  }

  /**
   * Better Solution
   * <p>Time Complexity: O(n * log(n))</p>
   * <p>Auxiliary Space: O(1)</p>
   */
  static int findRepeating1(int[] arr) {
    Arrays.sort(arr);

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        return arr[i];
      }
    }

    return -1;
  }

  /**
   * Better Approach
   * <p>Time Complexity: O(n)</p>
   * <p>Auxiliary Space: O(n)</p>
   */
  static int findRepeating2(int[] arr) {
    boolean[] visited = new boolean[arr.length];

    for (int i = 0; i < arr.length; i++) {
      if (visited[arr[i]]) {
        return arr[i];
      }

      visited[arr[i]] = true;
    }

    return -1;
  }

  /**
   * Finds the repeating number in an array where the numbers in the array start with 0.
   *
   * @param arr The input array in which to find the repeating number.
   * @return The repeating number in the array.
   */
  static int findRepeatingWith0(int[] arr) {
    int slow = arr[0] + 1; // Initialize the 'slow' pointer to the value at the first index plus 1.
    int fast = arr[0] + 1; // Initialize the 'fast' pointer to the value at the first index plus 1.

    // Perform a cycle detection using Floyd's Tortoise and Hare algorithm to find a loop.
    do {
      slow = arr[slow] + 1;         // Move the 'slow' pointer one step.
      fast = arr[arr[fast] + 1] + 1;    // Move the 'fast' pointer two steps.
    } while (slow != fast);  // Continue until the 'slow' and 'fast' pointers meet within the loop.

    // Reset the 'slow' pointer to the value at the first index plus 1 and find the entrance to the loop.
    slow = arr[0] + 1;
    while (slow != fast) {
      slow = arr[slow] + 1; // Move the 'slow' pointer one step.
      fast = arr[fast] + 1; // Move the 'fast' pointer one step.
    }

    // The value at 'slow' represents the repeating number, so subtract 1 to obtain the actual repeating number.
    return slow - 1;
  }

  /**
   * Finds the repeating number in an array where the numbers in the array start with 1.
   *
   * @param arr The input array in which to find the repeating number.
   * @return The repeating number in the array.
   */
  static int findRepeatingWith1(int[] arr) {
    int slow = arr[0];  // Initialize the 'slow' pointer to the value at the first index.
    int fast = arr[0];  // Initialize the 'fast' pointer to the value at the first index.

    // Perform a cycle detection using Floyd's Tortoise and Hare algorithm to find a loop.
    do {
      slow = arr[slow];             // Move the 'slow' pointer one step.
      fast = arr[arr[fast]];        // Move the 'fast' pointer two steps.
    } while (slow != fast);  // Continue until the 'slow' and 'fast' pointers meet within the loop.

    // Reset the 'slow' pointer to the value at the first index and find the entrance to the loop.
    slow = arr[0];
    while (slow != fast) {
      slow = arr[slow];  // Move the 'slow' pointer one step.
      fast = arr[fast];  // Move the 'fast' pointer one step.
    }

    // The value at 'slow' represents the repeating number.
    return slow;
  }

}
