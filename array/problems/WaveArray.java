package array.problems;

import java.util.Arrays;

public class WaveArray {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5};
    int[] arr = {2, 4, 7, 8, 9, 10};

    System.out.println(Arrays.toString(arr));
    convertToWave(arr.length, arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void convertToWave(int n, int[] arr) {
    for (int i = 0; i < n; i = i + 2) {
      if (i + 1 >= n) {
        break;
      }

      swap(arr, i, i + 1);
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
