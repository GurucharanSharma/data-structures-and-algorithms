package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PositiveNegativePair {

  public static void main(String[] args) {
    int[] arr = {1, 3, 6, -2, -1, -3, 2, 7};
//    int[] arr = {3, 2, 1};

    System.out.println(findPairs(arr, arr.length));
    System.out.println();
    System.out.println(findPairs1(arr, arr.length));
    System.out.println();
    System.out.println(findPairs2(arr, arr.length));
  }

  /**
   * Using Naive approach
   */
  public static ArrayList<Integer> findPairs(int[] arr, int n) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    // For each element of array.
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (Math.abs(arr[i]) == Math.abs(arr[j])) {
          list.add(Math.abs(arr[i]));
        }
      }
    }

    return list;
  }

  /**
   * Using ArrayList approach
   */
  //Function to return list containing all the pairs having both
  //negative and positive values of a number in the array.
  public static ArrayList<Integer> findPairs1(int[] arr, int n) {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> pairs = new ArrayList<>();

    for (int num : arr) {
      if (num != 0 && list.contains(-num)) {
        pairs.add(num > 0 ? -num : num);
        pairs.add(num > 0 ? num : -num);

        list.remove(Integer.valueOf(num));
      } else {
        list.add(num);
      }
    }

    return pairs;
  }

  /**
   * Using HashMap approach
   */
  public static ArrayList<Integer> findPairs2(int[] arr, int n) {
    Map<Integer, Integer> lookup = new HashMap<>();
    ArrayList<Integer> pairs = new ArrayList<>();

    for (int num : arr) {
      if (lookup.containsKey(Math.abs(num))) {
        pairs.add(-Math.abs(num));
        pairs.add(Math.abs(num));
      } else {
        lookup.put(Math.abs(num), 1);
      }
    }

    return pairs;
  }
}
