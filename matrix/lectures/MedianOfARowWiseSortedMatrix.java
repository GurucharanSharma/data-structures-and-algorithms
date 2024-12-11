package matrix.lectures;

import java.util.Arrays;

public class MedianOfARowWiseSortedMatrix {

  public static void main(String[] args) {
//    int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

//    int[][] arr = {{5, 10, 20, 30, 40}, {1, 2, 3, 4, 6}, {11, 13, 15, 17, 19}};

    int[][] arr = {{1, 3, 4}, {2, 5, 6}, {7, 8, 9}};

    System.out.println(median(arr));
    System.out.println();
    System.out.println(median1(arr));
  }

  // Naive Approach
  private static int median(int[][] matrix) {
    int[] arr = new int[matrix.length * matrix[0].length];

    int index = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        arr[index++] = matrix[i][j];
      }
    }

    Arrays.sort(arr);

    index = (matrix.length * matrix[0].length + 1) / 2;
    return arr[index - 1];
  }

  // Efficient Approach
  private static int median1(int[][] matrix) {
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
