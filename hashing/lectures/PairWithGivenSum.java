package hashing.lectures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

  public static void main(String[] args) {
    testIsPair();
    testIsPair1();
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static boolean isPair(int[] arr, int sum) {
    Set<Integer> set = new HashSet<>();

    for (int i : arr) {
      if (set.contains(sum - i)) {
        return true;
      } else {
        set.add(i);
      }
    }

    return false;
  }

  private static boolean isPair1(int[] arr, int sum) {
    HashMap<Integer, Integer> indexLookup = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (indexLookup.containsKey(sum - arr[i])) {
        System.out.println(arr[indexLookup.get(sum - arr[i])] + " + " + arr[i]);
        return true;
      }

      indexLookup.put(arr[i], i);
    }

    return false;
  }

  // Better Approach
  private static void isPair2(int[] arr, int sum) {
    Arrays.sort(arr);

    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      if (arr[i] + arr[j] == sum) {
        System.out.print(arr[i] + " + " + arr[j]);
        System.out.println();
        i++;
        j--;
      } else if (arr[i] + arr[j] > sum) {
        j--;
      } else {
        i++;
      }
    }
  }

  // Naive Approach
  private static void isPair3(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == sum) {
          System.out.print(arr[i] + " + " + arr[j]);
          System.out.println();
        }
      }
    }
  }

  private static void testIsPair() {
    int[] arr = {8, 3, 4, 2, 5};

    System.out.println(isPair(arr, 6));
    System.out.println();
    System.out.println(isPair1(arr, 6));
    System.out.println();
  }

  private static void testIsPair1() {
    int[] arr = {8, 3, 4, 2, 5};

    System.out.println(isPair(arr, 16));
    System.out.println();
    System.out.println(isPair1(arr, 16));
    System.out.println();
  }
}
