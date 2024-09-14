package sorting.lectures;

import java.util.Arrays;

public class CountingSort {

  public static void main(String[] args) {

    testCountingSortNaive1();
    testCountingSortNaive2();
    testCountingSortOptimised1();
    testCountingSortOptimised2();
  }

  private static void sortNaive(int[] arr, int k) {
    // k is max element in arr + 1.

    int[] count = new int[k];
    Arrays.fill(count, 0);

    for (int i = 0; i < arr.length; i++) {
      count[arr[i]]++;
    }

    int index = 0;
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i]; j++) {
        arr[index++] = i;
      }
    }
  }

  private static void sortOptimised(int[] arr, int k) {

    int[] count = new int[k];
    Arrays.fill(count, 0);

    for (int value : arr) {
      count[value]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }

    // If you run the loop from 0 to n - 1, then the algorithm is unstable.
    // If you run the loop from n - 1 to 0, then the algorithm is stable.
    int[] output = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      output[count[arr[i]] - 1] = arr[i];
      count[arr[i]]--;
    }

    System.arraycopy(output, 0, arr, 0, arr.length);
  }

  private static void testCountingSortNaive1() {
    int[] arr = {1, 4, 4, 1, 0, 1};
    sortNaive(arr, 5);
    System.out.println(Arrays.toString(arr));
  }

  private static void testCountingSortNaive2() {
    int[] arr = {5, 6, 5, 2};
    sortNaive(arr, 7);
    System.out.println(Arrays.toString(arr));
  }

  private static void testCountingSortOptimised1() {
    int[] arr = {1, 4, 4, 1, 0, 1};
    sortOptimised(arr, 5);
    System.out.println(Arrays.toString(arr));
  }

  private static void testCountingSortOptimised2() {
    int[] arr = {5, 6, 5, 2};
    sortOptimised(arr, 7);
    System.out.println(Arrays.toString(arr));
  }
}
