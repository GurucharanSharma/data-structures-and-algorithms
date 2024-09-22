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

    int medianIndex = (max + min + 1) / 2;
    while (min < max) {
      int mid = (max + min) / 2;
      int midIndex = 0;

      for (int[] arr : matrix) {
        int position = Arrays.binarySearch(arr, mid) + 1;
        midIndex += Math.abs(position);
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
