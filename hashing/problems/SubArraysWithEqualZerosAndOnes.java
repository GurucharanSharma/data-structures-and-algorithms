package hashing.problems;

import java.util.HashMap;

public class SubArraysWithEqualZerosAndOnes {

  public static void main(String[] args) {
//    int[] A = {1, 0, 0, 1, 0, 1, 1};
    int[] A = {1, 1, 1, 1, 0};

    System.out.println(countSubarrWithEqualZeroAndOne(A, A.length));
  }

  //Function to count subarrays with 1s and 0s.
  static int countSubarrWithEqualZeroAndOne(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] == 0 ? -1 : arr[i];
    }

    HashMap<Long, Integer> lookup = new HashMap<>();
    lookup.put(0L, 1);
    int res = 0;
    long sum = 0;

    for (long j : arr) {
      sum += j;
      if (lookup.containsKey(sum)) {
        res += lookup.get(sum);
      }

      lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
    }

    return res;
  }
}
