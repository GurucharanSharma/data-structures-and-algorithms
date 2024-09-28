package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubArrays {

  public static void main(String[] args) {
//    long[] arr = {0, 0, 5, 5, 0, 0};
    long[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

    System.out.println(findSubarray(arr, arr.length));
    System.out.println();
    System.out.println(findSubarray1(arr, arr.length));
    System.out.println();
    System.out.println(findSubarray2(arr, arr.length));
  }

  //Function to count subarrays with sum equal to 0.
  public static long findSubarray(long[] arr, int n) {
    HashMap<Long, List<Integer>> lookup = new HashMap<>();
    List<Pair> pairs = new ArrayList<>();

    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == 0) {
        pairs.add(new Pair(0, i));
      }

      List<Integer> list = new ArrayList<>();
      if (lookup.containsKey(sum)) {
        list.addAll(lookup.get(sum));
        for (Integer element : list) {
          pairs.add(new Pair(element + 1, i));
        }
      }

      list.add(i);
      lookup.put(sum, list);
    }

    System.out.println(pairs);
    return pairs.size();
  }

  public static long findSubarray1(long[] arr, int n) {
    HashMap<Long, List<Integer>> lookup = new HashMap<>();

    int count = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == 0) {
        count++;
      }

      List<Integer> list = new ArrayList<>();
      if (lookup.containsKey(sum)) {
        list.addAll(lookup.get(sum));
        count += list.size();
      }

      list.add(i);
      lookup.put(sum, list);
    }

    return count;
  }

  static int findSubarray2(long[] arr, int n) {
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

  private static class Pair {

    int first, second;

    Pair(int a, int b) {
      first = a;
      second = b;
    }
  }
}
