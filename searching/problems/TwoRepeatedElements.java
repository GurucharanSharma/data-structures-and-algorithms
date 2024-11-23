package searching.problems;

import java.util.Arrays;

public class TwoRepeatedElements {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The twoRepeated method takes an array arr of integers and its size N as input and returns an array containing the two repeated elements. It
   * initializes an array repeats of size 2 to store the two repeated elements, and fills it with -1 to indicate that the elements haven't been found
   * yet. The method iterates through the array, considering (N + 2) elements to account for two repeated elements. For each element at index i, it
   * checks whether the element at the absolute value of arr[i] is positive. If positive, it means the element has not been encountered before, so it
   * negates the element by making it negative. If negative, it means the element has already been encountered, indicating a repetition. It then
   * stores the first repeated element in repeats[0] and the second in repeats[1]. The loop breaks after finding both repeated elements. Finally, the
   * method returns the repeats array containing the two repeated elements. Note: This approach assumes that the array contains exactly two repeated
   * elements. If there are more than two repeated elements, this method may not provide accurate results.
   */
  public static void main(String[] args) {

    int[] array1 = {1, 2, 1, 3, 4, 3};
//    System.out.println(Arrays.toString(twoRepeated(array1, 4)));
    System.out.println(Arrays.toString(twoRepeated1(array1, 4)));

    int[] array2 = {1, 2, 2, 1};
//    System.out.println(Arrays.toString(twoRepeated(array2, 2)));
    System.out.println(Arrays.toString(twoRepeated1(array2, 2)));
  }

  // Naive Approach: Using a visited array to track the visited elements
  private static int[] twoRepeated1(int[] arr, int N) {
    boolean[] visited = new boolean[N + 2];

    int[] repeats = new int[2];
    Arrays.fill(repeats, -1);

    for (int i = 0; i < (N + 2); i++) {
      if (visited[arr[i]]) {
        if (repeats[0] == -1) {
          repeats[0] = arr[i];
        } else {
          repeats[1] = arr[i];
          break;
        }
      } else {
        visited[arr[i]] = true;
      }
    }

    return repeats;
  }

  // Efficient Approach: Using the original array itself to track the visited elements
  private static int[] twoRepeated(int[] arr, int N) {
    int[] repeats = new int[2]; // Array to store the two repeated elements.
    Arrays.fill(repeats, -1);   // Initialize the repeats array with -1.

    // Iterate through the array, considering (N + 2) elements.
    for (int i = 0; i < (N + 2); i++) {
      if (arr[Math.abs(arr[i])] > 0) {
        // If the element at the absolute value of arr[i] is positive, make it negative.
        arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i])];
      } else {
        // If the element at the index is negative, then it has been visited before, and it means that the element has been repeated.
        // Store the first repeated element in repeats[0] and the second in repeats[1].
        if (repeats[0] == -1) {
          repeats[0] = Math.abs(arr[i]);
        } else {
          repeats[1] = Math.abs(arr[i]);
          break; // Break the loop after finding both repeated elements.
        }
      }
    }

    return repeats; // Return the array containing the two repeated elements.
  }

}
