package hashing.problems;

import java.util.HashMap;
import java.util.Map;

public class CountNonRepeatedElements {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7};
//    int[] arr = {10, 20, 30, 40, 10};

    System.out.println(countNonRepeated(arr, arr.length));
    System.out.println(countNonRepeated1(arr, arr.length));
  }

  // arr[]: input array
  // n: size of array
  //Function to return the count of non-repeated elements in the array.
  static long countNonRepeated(int[] arr, int n) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int i = 0; i < n; i++) {
      lookup.put(arr[i], lookup.getOrDefault(arr[i], 0) + 1);
    }

    int count = 0;
    for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
      if (entry.getValue() == 1) {
        count++;
      }
    }

    return count;
  }

  static long countNonRepeated1(int[] arr, int n) {
    int count = 0;

    for (int i = 0; i < n; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (arr[j] == arr[i]) {
          flag = true;
          break;
        }
      }

      if (flag) {
        continue;
      }

      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        count++;
      }
    }

    return count;
  }

  static int countNonRepeated1(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      boolean repeated = false;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j] && i != j) {
          repeated = true;
          break;
        }
      }

      if (!repeated) {
        count++;
      }
    }

    return count;
  }

  static int countNonRepeated(int[] arr) {
    Map<Integer, Boolean> lookup = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (lookup.containsKey(arr[i])) {
        lookup.put(arr[i], true);
      } else {
        lookup.put(arr[i], false);
      }
    }

    int count = 0;
    for (Map.Entry<Integer, Boolean> entry : lookup.entrySet()) {
      if (!entry.getValue()) {
        count++;
      }
    }

    return count;
  }
}
