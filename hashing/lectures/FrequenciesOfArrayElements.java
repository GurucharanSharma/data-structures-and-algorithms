package hashing.lectures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

  /**
   * Printing elements in the same order as they appear in the array <br> Time Complexity: O(n) <br> Auxiliary Space: O(n)
   * <p>
   * Note: Uses a TreeMap to preserve the order
   */
  private static void printFrequencies4(int[] arr) {
    Map<Integer, Integer> lookup = new TreeMap<>();

    for (int j : arr) {
      lookup.put(j, lookup.getOrDefault(j, 0) + 1);
    }

    System.out.println(lookup);
  }

  /**
   * Sorting the array and then counting the occurrences of each element in the array.
   * <p>
   * Time Complexity: O(n * log(n))
   * <p>
   * Auxiliary Space: O(1)
   */
  private static void printFrequencies3(int[] arr) {
    int n = arr.length;

    Arrays.sort(arr);

    for (int i = 0; i < n - 1; i++) {
      int count = 1;
      while (i < n - 1 && arr[i] == arr[i + 1]) {
        count++;
        i++;
      }

      System.out.println(arr[i] + " = " + count);
    }

    if (arr[n - 1] != arr[n - 2]) {
      System.out.println(arr[n - 1] + " = " + 1);
    }
  }

  private static void testPrintFrequencies() {
    int[] arr = {10, 12, 12, 20, 10, 20, 10, 10};

    System.out.println("Naive");
    printFrequencies(arr);

    System.out.println("\nBetter");
    printFrequencies3(arr);

    System.out.println("\nOptimised");
    printFrequencies1(arr);

    System.out.println("\nOptimised - Same Order");
    printFrequencies2(arr);
  }
}
