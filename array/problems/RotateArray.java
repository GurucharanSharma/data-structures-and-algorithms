package array.problems;

import java.util.Arrays;

public class RotateArray {

  public static void main(String[] args) {
//    int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}; // 8 10 12 14 16 18 20 2 4 6
//    int[] arr = {1, 2, 3, 4, 5}; // 3 4 5 1 2
    int[] arr = {25, 6, 20, 55, 69, 5, 50, 63, 61, 41, 87, 80, 2, 96, 77, 70, 12, 43, 31, 8, 64, 41, 68, 18, 95, 79, 52, 74, 1, 98, 3, 26, 3, 74, 32,
        23, 79, 81, 37, 39, 21, 24, 18, 22, 71, 47, 44};
    int d = 77;

    System.out.println(Arrays.toString(arr));
//    rotateArr1(arr, d, arr.length);
    rotateArr2(arr, d, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  // Function to rotate an array by d elements in counter-clockwise direction.
  private static void rotateArr1(int[] arr, int d, int n) {
    int[] temp = new int[d];

    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }

    for (int i = d; i < n; i++) {
      arr[i - d] = arr[i];
    }

    for (int i = n - d; i < n; i++) {
      arr[i] = temp[i - (n - d)];
    }
  }

  private static void rotateArr2(int[] arr, int d, int n) {
    while (d > n) {
      d = d % n;
    }

    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    reverse(arr, 0, n - 1);
  }

  private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }
}
