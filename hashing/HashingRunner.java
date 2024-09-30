package hashing;

import java.util.HashMap;

/**
 * Practice Session
 */
public class HashingRunner {

  public static void main(String[] args) {
//    long[] arr = {0, 0, 5, 5, 0, 0};
    long[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

    System.out.println(findSubarray(arr, arr.length));
  }

  //Function to count subarrays with sum equal to 0.
  public static long findSubarray(long[] arr, int n) {
    HashMap<Long, Integer> freqLookup = new HashMap<>();
    freqLookup.put(0L, 1);

    long sum = 0;
    int count = 0;
    for (long e : arr) {
      sum += e;
      if (freqLookup.containsKey(sum)) {
        count += freqLookup.get(sum);
      }

      freqLookup.put(sum, freqLookup.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}
