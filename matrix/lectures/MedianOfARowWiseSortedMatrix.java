package matrix.lectures;

import java.util.Arrays;

public class MedianOfARowWiseSortedMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };

    System.out.println(median(arr));
  }

  private static int median(int[][] matrix) {
    int min = matrix[0][0];
    int max = matrix[0][matrix[0].length - 1];

    for (int[] arr : matrix) {
      min = Math.min(min, arr[0]);
      max = Math.max(max, arr[arr.length - 1]);
    }

    int medianIndex = (matrix.length * matrix[0].length + 1) / 2; // ceil
    while (min < max) {
      int mid = (max + min) / 2;
      int midIndex = 0;

      // Find the number of elements which are smaller than mid
      for (int[] arr : matrix) {
        int pos = Arrays.binarySearch(arr, mid);
        if (pos < 0) {
          pos = Math.abs(pos + 1);
        } else {
          while (pos < arr.length && arr[pos] == mid) {
            pos++;
          }
        }

        midIndex += pos;
      }

      if (midIndex < medianIndex) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    return min;
  }
}
