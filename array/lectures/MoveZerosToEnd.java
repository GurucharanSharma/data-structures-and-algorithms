package array.lectures;

import java.util.Arrays;

public class MoveZerosToEnd {

  public static void main(String[] args) {
    int[] array = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};

    moveZerosToEnd3(array);
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

  // Naive Approach 2: We move the 0s to the right and insert the non-zero at its correct position.
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

  // Naive Approach 6: Opposite of Naive Approach 2.
  // In Naive Approach 2, we move the 0s to the right and insert the non-zero at its correct position.
  // Here we move the non-zero to the left and then insert the 0 at its correct position.
  private static void moveZerosToEnd6(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        int j = i;
        while (j > 0 && arr[j - 1] == 0) {
          swap(arr, j, j - 1);
          j--;
        }

        arr[i] = 0;
      }
    }

    System.out.println(Arrays.toString(arr));
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

  // Efficient Approach: Does not maintain the order of non-zero elements
  private static void moveZerosToEnd5(int[] arr) {
    int lastPos = arr.length - 1;

    for (int i = 0; i < arr.length; i++) {
      if (i > lastPos) {
        break;
      }

      if (arr[i] == 0) {
        swap(arr, i, lastPos);

        while (lastPos >= 0 && arr[lastPos] == 0) {
          lastPos--;
        }
      }
    }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
