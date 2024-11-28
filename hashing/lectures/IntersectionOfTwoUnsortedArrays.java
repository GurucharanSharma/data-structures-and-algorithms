package hashing.lectures;

import java.util.Arrays;
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

  // Efficient Approach: Using HashMap with flag
  private static void intersect3(int[] arr, int[] brr) {
    HashMap<Integer, Boolean> lookup = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      lookup.put(arr[i], true);
    }

    for (int i = 0; i < brr.length; i++) {
      if (lookup.getOrDefault(brr[i], false)) {
        System.out.print(brr[i] + " ");
        lookup.put(brr[i], false);
      }
    }
  }

  private static void intersect4(int[] arr, int[] brr) {
    Arrays.sort(arr);
    Arrays.sort(brr);

    int i = 0;
    int j = 0;

    while (i < arr.length && j < brr.length) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        i++;
        continue;
      }

      if (j > 0 && brr[j] == brr[j - 1]) {
        j++;
        continue;
      }

      if (arr[i] == brr[j]) {
        System.out.println(arr[i]);
        i++;
        j++;
      } else if (arr[i] < brr[j]) {
        i++;
      } else {
        j++;
      }
    }
  }

  private static void intersect5(int[] arr, int[] brr) {
    Arrays.sort(arr);
    Arrays.sort(brr);

    int i = 0;
    int j = 0;
    while (i < arr.length - 1 && j < brr.length - 1) {
      if (arr[i] == arr[i + 1]) {
        i++;
        continue;
      }

      if (brr[j] == brr[j + 1]) {
        j++;
        continue;
      }

      if (arr[i] == brr[j]) {
        System.out.println(arr[i]);
        i++;
        j++;
      } else if (arr[i] < brr[j]) {
        i++;
      } else {
        j++;
      }
    }

    if (arr[arr.length - 1] != arr[arr.length - 2] && brr[brr.length - 1] != brr[brr.length - 2] && arr[arr.length - 1] == brr[brr.length - 1]) {
      System.out.println(arr[arr.length - 1]);
    }
  }

  private static void testIntersect() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    intersect(arr, brr);
    System.out.println();
    intersect1(arr, brr);
    System.out.println();
    intersect2(arr, brr);
    System.out.println();
    intersect3(arr, brr);
    System.out.println();
    intersect4(arr, brr);
    System.out.println();
    intersect5(arr, brr);
  }
}
