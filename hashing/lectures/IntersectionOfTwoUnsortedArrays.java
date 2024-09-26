package hashing.lectures;

import java.util.HashSet;

public class IntersectionOfTwoUnsortedArrays {

  public static void main(String[] args) {
    testIntersect();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>)
   * <p>
   * Auxiliary Space: O(1)
   */
  private static void intersect(int[] arr, int[] brr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < brr.length; j++) {
        if (arr[i] == brr[j]) {
          System.out.print(arr[i] + " ");
          break;
        }
      }
    }
  }

  /**
   * Time Complexity: θ(arr.length + brr.length)
   * <p>
   * Auxiliary Space: θ(arr.length / brr.length)
   */
  private static void intersect1(int[] arr, int[] brr) {
    HashSet<Integer> hashSet = new HashSet<>();

    if (arr.length < brr.length) {
      for (int i : arr) {
        hashSet.add(i);
      }

      for (int i : brr) {
        if (hashSet.contains(i)) {
          hashSet.remove(i);      // In case arr contains duplicates
          System.out.println(i);
        }
      }
    } else {
      for (int i : brr) {
        hashSet.add(i);
      }

      for (int i : arr) {
        if (hashSet.contains(i)) {
          hashSet.remove(i);      // In case brr contains duplicates
          System.out.println(i);
        }
      }
    }
  }

  private static void testIntersect() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    intersect(arr, brr);
    intersect1(arr, brr);
  }
}
