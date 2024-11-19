package searching.lectures;

public class TripletInASortedArray {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The isTriplet method aims to find a triplet of elements in the array arr whose sum equals the specified number num. It uses a loop to consider
   * each element as a potential first element of the triplet. For each potential first element, it calls the isPair method to check if there is a
   * pair in the remaining elements of the array that sums up to (num - arr[i]). If a valid pair is found, it indicates the presence of a triplet, and
   * the method returns true. If no triplet is found during the loop, the method returns false.
   * </p>
   * <p>
   * The isPair method is used to check if there is a pair of elements in the array arr whose sum equals the specified number num, starting from a
   * specified index start. It uses a two-pointer approach with start and end indices, and it continues searching as long as start is less than end.
   * If the sum of elements at indices start and end equals num, it indicates a valid pair, and the method returns true. If the sum is greater than
   * num, it means that the sum needs to be reduced, so the end index is decremented to consider smaller values. If the sum is less than num, it means
   * that the sum needs to be increased, so the start index is incremented to consider larger values. If no valid pair is found during the search, the
   * method returns false. The isPair method is used by isTriplet to find pairs within the remaining elements of the array to identify triplets.
   * </p>
   */
  public static void main(String[] args) {
    int[] arr = new int[]{2, 4, 8, 9, 11, 12, 20, 30};

    System.out.println(isTriplet(arr, 1));
    System.out.println(isTriplet(arr, 50));
    System.out.println(isTriplet(arr, 14));
    System.out.println(isTriplet(arr, 62));
    System.out.println(isTriplet(arr, 26));
  }

  // Naive Approach
  private static boolean isTriplet1(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          int curr = arr[i] + arr[j] + arr[k];
          if (curr == sum) {
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * Checks if there is a triplet of elements in the array that sums up to the specified number.
   *
   * @param arr The input array in which to search for a triplet.
   * @param num The target sum to be matched.
   * @return True if a triplet of elements is found that sums up to 'num,' false otherwise.
   */
  static boolean isTriplet(int[] arr, int num) {
    // Iterate through the array with a loop to consider each element as the potential first element of the triplet.
    for (int i = 0; i < arr.length - 2; i++) {
      // Check if there is a pair in the remaining elements of the array that sums up to (num - arr[i]).
      // we only consider the elements beginning from i + 1 because earlier elements would have already
      // been covered.
      if (isPair(arr, num - arr[i], i + 1)) {
        return true; // Return true if a triplet is found.
      }
    }
    return false; // Return false if no triplet is found.
  }


  /**
   * Checks if there is a pair of elements in the array that sums up to the specified number.
   *
   * @param arr   The input array in which to search for a pair.
   * @param num   The target sum to be matched.
   * @param start The index from which to start searching for the pair.
   * @return True if a pair of elements is found that sums up to 'num,' false otherwise.
   */
  static boolean isPair(int[] arr, int num, int start) {
    int end = arr.length - 1; // Initialize the end index to the last element.

    // Continue searching as long as the start index is less than the end index.
    while (start < end) {
      // If the sum of elements at indices 'start' and 'end' equals the specified number, it indicates a valid pair.
      if (arr[start] + arr[end] == num) {
        return true; // Return true to indicate the presence of a valid pair.
      } else if (arr[start] + arr[end] > num) {
        end--; // If the sum is greater than 'num,' decrement the 'end' index to reduce the sum.
      } else {
        start++; // If the sum is less than 'num,' increment the 'start' index to increase the sum.
      }
    }
    return false; // Return false if no valid pair is found.
  }

}
