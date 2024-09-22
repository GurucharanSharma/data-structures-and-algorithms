package hashing.lectures;

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

  private static void testIsPair() {
    int[] arr = {8, 3, 4, 2, 5};
    System.out.println(isPair(arr, 6));
  }

  private static void testIsPair1() {
    int[] arr = {8, 3, 4, 2, 5};
    System.out.println(isPair(arr, 16));
  }
}
