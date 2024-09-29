package hashing.lectures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class MoreThanNByKOccurrences {

  public static void main(String[] args) {
    testPrintNByK();
  }

  /**
   * Time Complexity: O(n * log(n)) <br> Auxiliary Space: O(1)
   */
  private static void printNByK(int[] arr, int k) {
    Arrays.sort(arr);
    int i = 1, count = 1;

    while (i < arr.length) {
      while (i < arr.length && arr[i] == arr[i - 1]) {
        count++;
        i++;
      }

      if (count > (arr.length / k)) {
        System.out.println(arr[i - 1]);
      }

      count = 1;
      i++;
    }
  }

  /**
   * Time Complexity: O(n * log(n)) <br> Auxiliary Space: O(1)
   */
  private static void printNByK1(int[] arr, int k) {
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

      int count = 1;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] == arr[i]) {
          count++;
        }
      }

      if (count > arr.length / k) {
        System.out.println(arr[i] + " ");
      }
    }
  }

  /**
   * Time Complexity: θ(n) <br> Auxiliary Space: O(n/k) <br>
   * <b>NOTE:</b> If k is very small and n is very large, the required auxiliary space would be very large
   */
  private static void printNByK2(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > (arr.length / k)) {
        System.out.println(entry.getKey());
      }
    }
  }

  /**
   * Boyer-Moore Majority Vote Algorithm
   * <b>Explanation of the Approach:</b>
   * HashMap Usage: The hashmap m is used to keep track of elements and their frequencies in the array.
   * <p>
   * First Pass (Lines 4-19):
   * <p>
   * For each element in the array, we check if it's already in the hashmap. If it is, we increment its count. If the element is not in the hashmap
   * and the size of the hashmap is less than k-1, we add the element with a count of 1. If the hashmap has k-1 elements, we decrement the count of
   * every element in the hashmap. If any count reaches zero, we remove that element from the hashmap. This step ensures that we only keep track of
   * potential candidates that may occur more than n/k times.
   * <p>
   * Second Pass (Lines 20-31):
   * <p>
   * After the first pass, the hashmap contains elements that are potential candidates to appear more than n/k times. We then iterate over each entry
   * in the hashmap, counting the actual occurrences of these elements in the array. If an element's actual count is greater than n/k, it is printed
   * as a result.
   * <p>
   * Time Complexity: O(nk) <br> Auxiliary Space: O(n/k) <br>
   * </p>
   */
  private static void printNByK3(int[] arr, int k) {
    // HashMap to store elements and their counts
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    // Iterate over each element in the array
    for (int value : arr) {
      // If the element is already in the map, increment its count
      if (freqMap.containsKey(value)) {
        freqMap.put(value, freqMap.get(value) + 1);
      }
      // If the map size is less than k-1, add the new element with count 1
      else if (freqMap.size() < k - 1) {
        freqMap.put(value, 1);
      }
      // If map size is equal to k-1, reduce count of all elements by 1
      else {
        for (Entry<Integer, Integer> entry : freqMap.entrySet()) {
          freqMap.put(entry.getKey(), entry.getValue() - 1);
          // Remove the element if its count becomes 0
          if (freqMap.get(entry.getKey()) == 0) {
            freqMap.remove(entry.getKey());
          }
        }
      }
    }

    // Second pass to check actual counts of elements in the map
    for (Entry<Integer, Integer> x : freqMap.entrySet()) {
      int count = 0;
      // Count the occurrences of each element in the array
      for (int j : arr) {
        if (x.getKey() == j) {
          count++;
        }
      }
      // Print the element if it occurs more than n/k times
      if (count > arr.length / k) {
        System.out.print(x.getKey() + " ");
      }
    }
  }

  private static void testPrintNByK() {
    int[] arr = {10, 20, 30, 10, 10, 20};
    int k = 3;

    System.out.println("Naive - 1:");
    printNByK(arr, k);

    System.out.println("Naive - 2:");
    printNByK1(arr, k);

    System.out.println("Optimised");
    printNByK2(arr, k);

    System.out.println("Boyer-Moore");
    printNByK3(arr, k);
  }
}
