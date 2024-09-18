package array.lectures;

import java.util.Arrays;

public class MoveZerosToEnd {

  public static void main(String[] args) {
    int[] array = new int[]{8, 5, 0, 10, 0, 20};

    moveZerosToEnd2(array);
    System.out.println(Arrays.toString(array));
  }

  /**
   * Naive approach 1
   */
  static void moveZerosToEnd1(int[] array) {
    int lastZeroIndex = array.length - 1;

    for (int i = 0; i < array.length; ) {
      if (array[i] == 0 && i < lastZeroIndex) {
        for (int j = i; j < array.length - 1; j++) {
          swap(array, j, j + 1);
        }

        array[lastZeroIndex--] = 0;
      } else {
        i++;
      }
    }
  }

  /**
   * Naive approach 2
   */
  static void moveZerosToEnd3(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        int num = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] == 0) {
          arr[j + 1] = arr[j];
          j--;
        }

        arr[j + 1] = num;
      }
    }
  }

  /**
   * Naive approach 3
   */
  static void moveZerosToEnd4(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        int j = i + 1;
        while (j < n && arr[j] == 0) {
          j++;
        }

        if (j < n) {
          swap(arr, i, j);
        }
      }
    }
  }

  /**
   * Efficient approach
   */
  static void moveZerosToEnd2(int[] array) {
    int count = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        swap(array, count, i);
        count++;
      }
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
