package array.problems;

import java.util.Arrays;

public class SmallestPositiveMissing {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5};
//    int[] arr = {0, -10, 1, 3, -20};
//    int[] arr = {1, 2, 3, 4, 5, 7};
    int[] arr = {-25, 38, 24, -17, 31, 43, 8, 20, 49, -33, -11, 19, 13, -28, 44, 23, -3, -19, 12, 32, 40, 42, 41, 7, -35, -29, 7, 24, 41, -3, 1,
        -19, -29, -13, -10, 4, -20, 48};

    System.out.println(Arrays.toString(arr));
    System.out.println(missingNumber1(arr, arr.length));
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Without using swap function
   */
  static int missingNumber(int[] arr, int size) {
    for (int i = 0; i < size; i++) {
      int index = arr[i] - 1;
      while (index >= 0 && index < size && arr[index] != arr[i]) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        index = arr[i] - 1;
      }
    }

    for (int i = 0; i < size; i++) {
      if (arr[i] != (i + 1)) {
        return i + 1;
      }
    }

    return size + 1;
  }

  /**
   * Using swap function
   */
  static int missingNumber1(int[] arr, int size) {
    int index = -1;

    for (int i = 0; i < size; i++) {
      index = arr[i] - 1;
      while (index >= 0 && index < size && (arr[index] != arr[i])) {
        swap(arr, i, index);
        index = arr[i] - 1;
      }
    }

    for (int i = 0; i < size; i++) {
      if (arr[i] != (i + 1)) {
        return (i + 1);
      }
    }

    return size + 1;
  }

  static int missingNumber2(int[] arr, int size) {
      for (int i = 0; i < size; i++) {
        while (arr[i] > 0 && (arr[i] - 1) < size && (i + 1) != arr[i]) {
          // To handle the scenarios when there are repeating elements in the array
          if (arr[i] == arr[arr[i] - 1]) {
            break;
          }

          swap(arr, i, arr[i] - 1);
        }
      }

      int i = 0;
      for (; i < size; i++) {
        if (i + 1 != arr[i]) {
          return i + 1;
        }
      }

      return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
