package searching.problems;

public class SmallestPositiveMissingNumber {

  public static void main(String[] args) {
    int[] arr = {0, -10, 1, 3, -20};
    System.out.println(missingNumber(arr, arr.length));
  }

  /**
   * Approach 1
   */
  //Function to find the smallest positive number missing from the array.
  static int missingNumber(int[] arr, int size) {
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

  /**
   * Approach 2
   */
  static int missingNumber1(int[] arr, int size) {
    for (int i = 0; i < size; i++) {
      int index = arr[i];

      while (index > 0 && index < size && arr[index - 1] != index) {
        swap(arr, index - 1, i);
        index = arr[i];
      }
    }

    for (int i = 0; i < size; i++) {
      if (arr[i] != (i + 1)) {
        return i + 1;
      }
    }

    return size + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
