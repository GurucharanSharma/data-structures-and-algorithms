package sorting.lectures;

public class CountInversionsInArray {

  public static void main(String[] args) {

    int[] arr = {2, 5, 8, 11, 3, 6, 9, 13};
    System.out.println(count(arr, 0, arr.length - 1));
  }

  private static int count(int[] arr, int start, int end) {
    int res = 0;
    if (end > start) {
      int mid = (start + end) / 2;
      res += count(arr, start, mid);
      res += count(arr, mid + 1, end);
      res += countAndMerge(arr, start, mid, end);
    }

    return res;
  }

  // Method to count inversions and merge two sorted halves of an array.
  // An inversion is when a[i] > a[j] but i < j.
  private static int countAndMerge(int[] arr, int start, int mid, int end) {
    // Calculate the sizes of the two halves to be merged.
    int n = mid - start + 1; // Size of the left half
    int m = end - mid; // Size of the right half

    // Create temporary arrays to hold the two halves.
    int[] left = new int[n];
    int[] right = new int[m];

    // Copy the elements from the array into the respective temporary arrays.
    System.arraycopy(arr, start, left, 0, n); // Copying left half
    System.arraycopy(arr, mid + 1, right, 0, m); // Copying right half

    // Initialize pointers for the left half (i), right half (j), and merged array (k).
    int i = 0, j = 0, k = start;
    // Initialize a variable to store the count of inversions.
    int res = 0;

    // Merge the two halves while counting inversions.
    while (i < n && j < m) {
      if (left[i] <= right[j]) {
        // If the current element of left half is smaller, no inversion is formed.
        // Here no inversion is possible because if ith element on the left is less than jth element on the right,
        // then the ith element will always be less than the j + 1 th, j + 2 nd elements and so on.
        arr[k++] = left[i++];
      } else {
        // If the current element of left half is greater, an inversion is formed.
        // Count the number of inversions. Each remaining element in the left half
        // forms an inversion with the current element of the right half.
        res = res + (n - i);
        arr[k++] = right[j++];
      }
    }

    // Copy any remaining elements of the left half back into the original array.
    while (i < n) {
      arr[k++] = left[i++];
    }

    // Copy any remaining elements of the right half back into the original array.
    while (j < m) {
      arr[k++] = right[j++];
    }

    // Return the count of inversions.
    return res;
  }

}
