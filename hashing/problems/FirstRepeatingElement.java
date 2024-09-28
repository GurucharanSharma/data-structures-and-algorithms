package hashing.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstRepeatingElement {

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 4, 3, 5, 6};
//    int[] arr = {1, 2, 3, 4};

    System.out.println(firstRepeated(arr));
    System.out.println();
    System.out.println(firstRepeated1(arr));
    System.out.println();
    System.out.println(firstRepeated2(arr));
  }

  private static int firstRepeated(int[] arr) {
    // Nested loop to check for repeating elements
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // If a repeating element is found, return its index
        if (arr[i] == arr[j]) {
          return (i + 1);
        }
      }
    }

    // If no repeating element is found, return -1
    return -1;
  }

  // Function to return the position of the first repeating element.
  private static int firstRepeated1(int[] arr) {
    Map<Integer, Integer> freqLookup = new HashMap<>();
    Map<Integer, Integer> indexLookup = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      freqLookup.put(arr[i], freqLookup.getOrDefault(arr[i], 0) + 1);
      indexLookup.put(arr[i], Math.min(indexLookup.getOrDefault(arr[i], Integer.MAX_VALUE), (i + 1)));
    }

    int minIndex = Integer.MAX_VALUE;
    for (int j : arr) {
      int currIndex = indexLookup.get(j);
      if (freqLookup.get(j) > 1 && currIndex < minIndex) {
        minIndex = currIndex;
      }
    }

    if (minIndex == Integer.MAX_VALUE) {
      return -1;
    } else {
      return minIndex;
    }
  }

  // Function to return the position of the first repeating element.
  private static int firstRepeated2(int[] arr) {
    HashSet<Integer> lookup = new HashSet<>();
    int minIndex = Integer.MAX_VALUE;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (lookup.contains(arr[i])) {
        minIndex = (i + 1);
      }

      lookup.add(arr[i]);
    }

    return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
  }
}
