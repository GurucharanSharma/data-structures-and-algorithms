package hashing.lectures;

import java.util.HashSet;

public class IntersectionOfTwoUnsortedArrays {

  public static void main(String[] args) {
    testIntersect();
  }

  /**
   * Time Complexity: θ(arr.length + brr.length) <br> Auxiliary Space: θ(arr.length / brr.length)
   */
  private static void intersect(int[] arr, int[] brr) {
    HashSet<Integer> hashSet = new HashSet<>();

    if (arr.length < brr.length) {
      for (int i : arr) {
        hashSet.add(i);
      }

      for (int i : brr) {
        if (hashSet.contains(i)) {
          System.out.println(i);
        }
      }
    } else {
      for (int i : brr) {
        hashSet.add(i);
      }

      for (int i : arr) {
        if (hashSet.contains(i)) {
          System.out.println(i);
        }
      }
    }
  }

  private static void testIntersect() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    intersect(arr, brr);
  }
}
