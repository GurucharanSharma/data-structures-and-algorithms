package array.lectures;

public class MoveZerosToEnd {

  public static void main(String[] args) {
    int[] array = new int[]{8, 5, 0, 10, 0, 20};

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

    moveZerosToEnd2(array);

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  /**
   * Naive approach 1
   */
  static void moveZerosToEnd1(int[] array) {
    int lastZeroIndex = array.length - 1;

    for (int i = 0; i < array.length; ) {
      if (array[i] == 0 && i < lastZeroIndex) {
        for (int j = i; j < array.length - 1; j++) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
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
        int temp = array[count];
        array[count] = array[i];
        array[i] = temp;
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
