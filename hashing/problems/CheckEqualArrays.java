package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckEqualArrays {

  public static void main(String[] args) {
//    int[] arr1 = {1, 2, 5, 4, 0};
//    int[] arr2 = {2, 4, 5, 0, 1};

    int[] arr1 = {1, 2, 5};
    int[] arr2 = {2, 4, 15};

    System.out.println(check(arr1, arr2));
  }

  /**
   * Using ArrayList
   */
  // Function to check if two arrays are equal or not.
  public static boolean check(int[] arr1, int[] arr2) {
    ArrayList<Integer> lookup = new ArrayList<>(arr1.length);
    for (int num : arr1) {
      lookup.add(num);
    }

    for (int num : arr2) {
      if (lookup.contains(num)) {
        lookup.remove(Integer.valueOf(num));
      } else {
        return false;
      }
    }

    return lookup.isEmpty();
  }

  /**
   * Using HashMap
   */
  // Function to check if two arrays are equal or not.
  public static boolean check1(int[] arr1, int[] arr2) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int num : arr1) {
      lookup.put(num, lookup.getOrDefault(num, 0) + 1);
    }

    for (int num : arr2) {
      if (lookup.containsKey(num)) {
        lookup.put(num, lookup.get(num) - 1);
      } else {
        return false;
      }
    }

    for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }

    return true;
  }
}
