package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubArrays {

  public static void main(String[] args) {
    long[] arr = {0, 0, 5, 5, 0, 0};
//    long[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

    System.out.println(findSubarray(arr, arr.length));
    System.out.println();
    System.out.println(findSubarray1(arr, arr.length));
    System.out.println();
    System.out.println(findSubarray2(arr, arr.length));
  }

  //Function to count subarrays with sum equal to 0.
  public static long findSubarray(long[] arr, int n) {
    HashMap<Long, List<Integer>> indexLookup = new HashMap<>();
    List<Pair> pairs = new ArrayList<>();

    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == 0) {
        pairs.add(new Pair(0, i));
      }

      List<Integer> list = new ArrayList<>();
      if (indexLookup.containsKey(sum)) {
        list.addAll(indexLookup.get(sum));
        for (Integer element : list) {
          pairs.add(new Pair(element + 1, i));
        }
      }

      list.add(i);
      indexLookup.put(sum, list);
    }

    System.out.println(indexLookup);
    return pairs.size();
  }

  public static long findSubarray1(long[] arr, int n) {
    HashMap<Long, List<Integer>> indexLookup = new HashMap<>();
    // The map to hold the sum and all the indexes where the sum is found in the array

    int count = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == 0) {
        count++;
      }

      // Here, if you look closely, the same pair will be counted multiple times. The reason is that if 0 occurs
      // at index 2 and then again at index 4, then zero will also occur if we consider from 0 to 4. So, it is
      // counted multiple times to account for the overlapping sub arrays.
      List<Integer> list = new ArrayList<>();
      if (indexLookup.containsKey(sum)) {  // Look for any earlier occurrences of sum in the array
        list.addAll(indexLookup.get(sum));
        count += list.size();
      }

      list.add(i);
      indexLookup.put(sum, list);
    }

    return count;
  }

  static int findSubarray2(long[] arr, int n) {
    HashMap<Long, Integer> freqLookup = new HashMap<>();
    freqLookup.put(0L, 1);
    // Here the hashmap stores the number of times the prefix sum was encountered in the array

    int res = 0;
    long sum = 0;

    for (long j : arr) {
      sum += j;
      if (freqLookup.containsKey(sum)) {
        res += freqLookup.get(sum);
      }

      freqLookup.put(sum, freqLookup.getOrDefault(sum, 0) + 1);
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
