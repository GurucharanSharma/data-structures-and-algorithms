package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintNonRepeatedElements {

  public static void main(String[] args) {
//    int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7};
    int[] arr = {10, 20, 40, 30, 10};

    System.out.println(printNonRepeated(arr, arr.length));
  }

  //Function to return non-repeated elements in the array.
  static ArrayList<Integer> printNonRepeated(int[] arr, int n) {
    Map<Integer, Integer> lookup = new HashMap<>();

    for (int i = 0; i < n; i++) {
      lookup.put(arr[i], lookup.getOrDefault(arr[i], 0) + 1);
    }

    ArrayList<Integer> list = new ArrayList<>();
    for (int num : arr) {
      if (lookup.get(num) == 1) {
        list.add(num);
      }
    }

    return list;
  }
}
