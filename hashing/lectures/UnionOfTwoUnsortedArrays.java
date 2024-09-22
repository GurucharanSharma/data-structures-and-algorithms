package hashing.lectures;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArrays {

  public static void main(String[] args) {
    testUnion();
    testUnion1();
  }

  /**
   * Time Complexity: θ(arr.length + brr.length) <br> Auxiliary Space: O(arr.length + brr.length)
   */
  private static void union(int[] arr, int[] brr) {
    Set<Integer> set = new HashSet<>();

    for (int i : arr) {
      set.add(i);
    }

    for (int j : brr) {
      set.add(j);
    }

    System.out.println(set);
  }

  private static void testUnion() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    union(arr, brr);
  }

  private static void testUnion1() {
    int[] arr = {10, 30, 10, 40};
    int[] brr = {40, 5, 10, 15};

    union(arr, brr);
  }
}
