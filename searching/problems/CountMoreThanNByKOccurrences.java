package searching.problems;

import java.util.HashMap;
import java.util.Map;

public class CountMoreThanNByKOccurrences {

  public static void main(String[] args) {
    int[] arr = {2, 3, 3, 2};
    System.out.println(countOccurrence(arr, arr.length, 4));
    System.out.println(countOccurrence1(arr, arr.length, 4));
  }

  /**
   * Naive Approach
   */
  private static int countOccurrence(int[] arr, int n, int k) {
    int max = 1000000;
    int[] hash = new int[max + 1];

    for (int j : arr) {
      hash[j]++;
    }

    int count = 0;
    for (int j : hash) {
      if (j > n / k) {
        count++;
      }
    }

    return count;
  }

  /**
   * Efficient Approach
   */
  private static int countOccurrence1(int[] arr, int n, int k) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int i = 0; i < n; i++) {
      freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
    }

    int count = 0;
    for (Integer value : freq.values()) {
      if (value > n / k) {
        count++;
      }
    }

    return count;
  }
}
