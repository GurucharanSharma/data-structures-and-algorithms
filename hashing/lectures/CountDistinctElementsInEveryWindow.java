package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {

  public static void main(String[] args) {
    testPrintDistinctWindow();
  }

  /**
   * Time Complexity: O((n - k) * k * k) <br> Auxiliary Space: O(1)
   */
  private static void printDistinctWindow(int[] arr, int k) {
    for (int i = 0; i <= arr.length - k; i++) {
      int count = 0;
      for (int j = 0; j < k; j++) {
        boolean flag = false;
        for (int p = 0; p < j; p++) {
          if (arr[i + j] == arr[i + p]) {
            flag = true;
            break;
          }
        }

        if (!flag) {
          count++;
        }
      }

      System.out.println(count);
    }
  }

  /**
   * Time Complexity: O((n - k) * k * k)
   * <p>
   * Auxiliary Space: O(1)
   */
  private static void printDistinctWindow1(int[] arr, int k) {
    for (int i = 0; i <= arr.length - k; i++) {
      int count = 0;
      for (int j = i; j < i + k; j++) {
        int p = i;
        while (p < j) {
          if (arr[j] == arr[p]) {
            break;
          }

          p++;
        }

        if (p == j) {
          count++;
        }
      }

      System.out.println(count);
    }
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(k)
   */
  private static void printDistinctWindow2(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < k; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    System.out.println(map.size());

    for (int i = k; i < arr.length; i++) {
      map.put(arr[i - k], map.get(arr[i - k]) - 1);
      if (map.get(arr[i - k]) <= 0) {
        map.remove(arr[i - k]);
      }

      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      System.out.println(map.size());
    }
  }

  /**
   * Time Complexity: O(n)
   * <p>
   * Auxiliary Space: O(k)
   */
  private static void printDistinctWindow3(int[] arr, int k) {
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (i < k) {
        freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
      } else {
        System.out.println(freqMap.size());

        freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        freqMap.put(arr[i - k], freqMap.getOrDefault(arr[i - k], 0) - 1);
        if (freqMap.get(arr[i - k]) <= 0) {
          freqMap.remove(arr[i - k]);
        }
      }
    }

    System.out.println(freqMap.size());
  }

  private static void testPrintDistinctWindow() {
    int[] arr = {10, 10, 5, 3, 20, 5};
    int k = 4;

    System.out.println("Naive - 1:");
    printDistinctWindow(arr, k);

    System.out.println("Naive - 2:");
    printDistinctWindow1(arr, k);

    System.out.println("\nOptimised - 1:");
    printDistinctWindow2(arr, k);

    System.out.println("\nOptimised - 2:");
    printDistinctWindow3(arr, k);
  }
}
