package hashing.problems;

import java.util.HashMap;

public class SubArrayRangeWithGivenSum {

  public static void main(String[] args) {
    int[] arr = {10, 2, -2, -20, 10};
    int tar = -10;

//    int[] arr = {1, 4, 20, 3, 10, 5};
//    int tar = 33;

    System.out.println(subArraySum(arr, tar));
  }

  // Function to count the number of subarrays which adds to the given sum.
  static int subArraySum(int[] arr, int tar) {
    HashMap<Integer, Integer> lookup = new HashMap<>();
    lookup.put(0, 1);
    int res = 0;
    int sum = 0;

    for (int j : arr) {
      sum += j;
      if (lookup.containsKey(sum - tar)) {
        res += lookup.get(sum - tar);
      }

      lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
    }

    return res;
  }
}
