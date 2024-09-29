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

  private static void union1(int[] arr, int[] brr) {
    // Printing the elements in arr, which are not in brr
    for (int i = 0; i < arr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          break;
        }
      }

      if (flag) {
        continue;
      }

      for (int n : brr) {
        if (arr[i] == n) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.print(arr[i] + " ");
      }
    }

    // Printing all the elements of brr
    for (int i = 0; i < brr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (brr[i] == brr[j]) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.print(brr[i] + " ");
      }
    }
  }

  private static void testUnion() {
    int[] arr = {10, 20, 30};
    int[] brr = {30, 10};

    union(arr, brr);
    System.out.println();
    union1(arr, brr);
    System.out.println();
  }

  private static void testUnion1() {
    int[] arr = {10, 30, 10, 40};
    int[] brr = {40, 5, 10, 15};

    union(arr, brr);
    System.out.println();
    union1(arr, brr);
    System.out.println();
  }
}
