package hashing.lectures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArrays {

  public static void main(String[] args) {
    testUnion();
    testUnion1();
  }

  /**
   * <p>Efficient Approach</p>
   * <p>
   * Time Complexity: θ(arr.length + brr.length)<br>
   * Auxiliary Space: O(arr.length + brr.length)
   * </p>
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

  // Naive Approach
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

  // Better Approach
  private static void union2(int[] arr, int[] brr) {
    Arrays.sort(arr);
    Arrays.sort(brr);

    int i = 0;
    int j = 0;

    while (i < arr.length && j < brr.length) {
      while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
        i++;
      }

      while (j < brr.length - 1 && brr[j] == brr[j + 1]) {
        j++;
      }

      if (arr[i] < brr[j]) {
        System.out.print(arr[i] + " ");
        i++;
      } else if (arr[i] > brr[j]) {
        System.out.print(brr[j] + " ");
        j++;
      } else {
        System.out.print(arr[i] + " ");
        i++;
        j++;
      }
    }

    while (i < arr.length) {
      if (arr[i] != arr[i - 1]) {
        System.out.print(arr[i] + " ");
      }
      i++;
    }

    while (j < brr.length) {
      if (brr[j] != brr[j - 1]) {
        System.out.print(brr[j] + " ");
      }
      j++;
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
