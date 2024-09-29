package hashing.lectures;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfTwoUnsortedArrays {

  public static void main(String[] args) {
    testIntersect();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>)
   * <p>
   * Auxiliary Space: O(1)
   */
  private static void intersect(int[] arr, int[] brr) {
    // Below code handles repetitions in the array, if any.

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

      for (int j = 0; j < brr.length; j++) {
        if (arr[i] == arr[j]) {
          System.out.print(arr[i] + " ");
          break;
        }
      }
    }
  }

  /**
   * Time Complexity: θ(arr.length + brr.length)
   * <p>
   * Auxiliary Space: θ(arr.length / brr.length)
   */
  private static void intersect1(int[] arr, int[] brr) {
    HashSet<Integer> hashSet = new HashSet<>();

    if (arr.length < brr.length) {
      for (int i : arr) {
        hashSet.add(i);
      }

      for (int i : brr) {
        if (hashSet.contains(i)) {
          hashSet.remove(i);      // In case brr contains duplicates
          System.out.println(i);
        }
      }
    } else {
      for (int i : brr) {
        hashSet.add(i);
      }

      for (int i : arr) {
        if (hashSet.contains(i)) {
          hashSet.remove(i);      // In case arr contains duplicates
          System.out.println(i);
        }
      }
    }
  }

  /**
   * Efficient approach: Using HashMap
   */
  private static void intersect2(int[] arr, int[] brr) {
    HashMap<Integer, Integer> freqLookup = new HashMap<>();
    for (int n : arr) {
      freqLookup.put(n, freqLookup.getOrDefault(n, 0) + 1);
    }

    for (int n : brr) {
      if (freqLookup.containsKey(n)) {
        System.out.print(n + " ");
        freqLookup.remove(n);
      }
    }
  }

  private static void testIntersect() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    System.out.println();
    intersect(arr, brr);
    System.out.println();
    intersect1(arr, brr);
    System.out.println();
    intersect2(arr, brr);
  }
}
