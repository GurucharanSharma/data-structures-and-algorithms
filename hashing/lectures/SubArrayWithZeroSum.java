package hashing.lectures;

import java.util.HashSet;

public class SubArrayWithZeroSum {

  public static void main(String[] args) {
    testIs0SubArray();
    System.out.println();

    testIs0SubArray1();
    System.out.println();

  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static boolean is0SubArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];

        if (sum == 0) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static boolean is0SubArray1(int[] arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    int sum = 0;

    for (int i : arr) {
      sum += i;

      if (i == 0 || sum == 0 || hashSet.contains(sum)) {
        return true;
      } else {
        hashSet.add(sum);
      }
    }

    return false;
  }

  private static void testIs0SubArray() {
    int[] arr = {-3, 4, -3, -1, 1};

    System.out.println(is0SubArray(arr));
    System.out.println(is0SubArray1(arr));
  }

  private static void testIs0SubArray1() {
    int[] arr = {-3, 2, 3, 1, 6};

    System.out.println(is0SubArray(arr));
    System.out.println(is0SubArray1(arr));
  }
}
