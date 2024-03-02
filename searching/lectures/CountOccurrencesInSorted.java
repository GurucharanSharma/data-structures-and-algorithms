package searching.lectures;

public class CountOccurrencesInSorted {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 1, 1, 1, 1};
    int num = 1;
    System.out.println(countOccurrences(arr, num));
  }

  /**
   * Counts the number of occurrences of a specified number in a sorted integer array.
   *
   * @param arr The sorted array in which to count occurrences.
   * @param num The number to count occurrences of.
   * @return The count of occurrences of the specified number in the array.
   */
  private static int countOccurrences(int[] arr, int num) {
    // Find the index of the first occurrence of the number using a binary search.
    int firstOcc = IndexOfFirstOccurrenceInSorted.searchRecursive(arr, num, 0, arr.length - 1);

    // If the number is not found in the array, there are no occurrences, so return 0.
    if (firstOcc == -1) {
      return 0;
    }

    // Find the index of the last occurrence of the number using a binary search.
    int lastOcc = IndexOfLastOccurrenceInSorted.searchRecursive(arr, num, 0, arr.length - 1);

    // Calculate the count of occurrences by subtracting the index of the first occurrence
    // from the index of the last occurrence and adding 1 (to include both the first and last occurrences).
    return lastOcc - firstOcc + 1;
  }
}
