package hashing.lectures;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfArrayElements {

  public static void main(String[] args) {
    testPrintFrequencies();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(n)
   */
  private static void printFrequencies(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          break;
        }
      }

      if (flag) {
        continue;
      }

      int freq = 1;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] == arr[i]) {
          freq++;
        }
      }

      System.out.println(arr[i] + " " + freq);
    }
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static void printFrequencies1(int[] arr) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i : arr) {
      hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
    }

    System.out.println(hashMap);
  }

  /**
   * Printing elements in the same order as they appear in the array <br> Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  static void printFrequencies2(int[] arr) {
    Map<Integer, Integer> mp = new HashMap<>();

    // Traverse through array elements and count frequencies
    for (int element : arr) {
      mp.put(element, mp.getOrDefault(element, 0) + 1);
    }

    // To print elements according to first occurrence, traverse array one more time.
    // Print the frequencies of elements and mark frequencies as -1 so that same element is not printed multiple times.
    for (int element : arr) {
      if (mp.get(element) != -1) {
        System.out.println(element + " " + mp.get(element));
        mp.put(element, -1);
      }
    }
  }

  private static void testPrintFrequencies() {
    int[] arr = {10, 12, 12, 20, 10, 20, 10, 10};

    System.out.println("Naive");
    printFrequencies(arr);

    System.out.println("\nOptimised");
    printFrequencies1(arr);

    System.out.println("\nOptimised - Same Order");
    printFrequencies2(arr);
  }
}
