package sorting.problems;

import java.util.Arrays;

public class MergeWithoutExtraSpace {

  public static void main(String[] args) {
    long[] arr1 = {1, 3, 5, 7};
    long[] arr2 = {0, 2, 6, 8, 9};

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    merge2(arr1, arr2, arr1.length, arr2.length);
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
  }

  /**
   * Approach 1: Function to merge the arrays.
   */
  public static void merge(long[] arr1, long[] arr2, int n, int m) {
    int i = n - 1;
    int j = 0;

    while (i >= 0 && j < m) {
      if (arr1[i] > arr2[j]) {
        long temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
      } else {
        break;
      }

      i--;
      j++;
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }

  /**
   * Approach 2: Function to merge the arrays.
   */
  public static void merge1(long[] arr1, long[] arr2, int n, int m) {
    int i = 0;
    int j = 0;
    int k = n - 1;

    while (i < k) {
      if (arr1[i] < arr2[j]) {
        i++;
      } else {
        long temp = arr1[k];
        arr1[k] = arr2[j];
        arr2[j] = temp;
        k--;
        j++;
      }
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }

  /**
   * Approach 3: Using gap method
   */
  static void merge2(long[] arr1, long[] arr2, int n, int m) {
    // len of the imaginary single array:
    int len = n + m;

    // Initial gap:
    int gap = (len / 2) + (len % 2); // ceil((size of arr1[] + size of arr2[]) / 2)

    while (gap > 0) {
      // Place 2 pointers:
      int left = 0;
      int right = left + gap;

      while (right < len) {
        // case 1: left in arr1[] and right in arr2[]:
        if (left < n && right >= n) {
          swapIfGreater(arr1, arr2, left, right - n);
        }
        // case 2: both pointers in arr2[]:
        else if (left >= n) {
          swapIfGreater(arr2, arr2, left - n, right - n);
        }
        // case 3: both pointers in arr1[]:
        else {
          swapIfGreater(arr1, arr1, left, right);
        }

        left++;
        right++;
      }

      // break if iteration gap=1 is completed:
      if (gap == 1) {
        break;
      }

      // Otherwise, calculate new gap:
      gap = (gap / 2) + (gap % 2);
    }
  }

  static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
    if (arr1[ind1] > arr2[ind2]) {
      long temp = arr1[ind1];
      arr1[ind1] = arr2[ind2];
      arr2[ind2] = temp;
    }
  }
}
