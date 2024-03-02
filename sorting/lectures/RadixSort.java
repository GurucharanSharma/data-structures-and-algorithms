package sorting.lectures;

import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) {
    testRadixSort1();
  }

  private static void sort(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }

    for (int exp = 1; max / exp > 0; exp = exp * 10) {
      countingSort(arr, exp);
    }
  }

  private static void countingSort(int[] arr, int exp) {
    int[] count = new int[10];
    Arrays.fill(count, 0);

    for (int j : arr) {
      count[(j / exp) % 10]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }

    // Going from n - 1 to 0 to maintain order and make it stable.
    int[] output = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    System.arraycopy(output, 0, arr, 0, arr.length);
  }

  private static void testRadixSort1() {
    int[] arr = {319, 212, 6, 8, 100, 50};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
