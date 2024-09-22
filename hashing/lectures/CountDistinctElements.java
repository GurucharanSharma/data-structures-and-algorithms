package hashing.lectures;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElements {

  public static void main(String[] args) {
    testCountDistinct1();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static int countDistinct(Integer[] arr) {
    int res = 1;

    // Pick all elements one by one
    for (int i = 1; i < arr.length; i++) {
      int j = 0;
      for (; j < i; j++) {
        if (arr[i].intValue() == arr[j].intValue()) {
          break;
        }
      }

      // If not printed earlier, then print it
      if (i == j) {
        res++;
      }
    }

    return res;
  }

  /**
   * Time Complexity: O(n * log(n)) <br> Auxiliary Space: O(1)
   */
  private static int countDistinct1(Integer[] arr) {
    // First sort the array so that all occurrences become consecutive
    Arrays.sort(arr);

    // Traverse the sorted array
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      // Move the index ahead while there are duplicates
      while (i < arr.length - 1 && arr[i].intValue() == arr[i + 1].intValue()) {
        i++;
      }

      res++;
    }

    return res;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static int countDistinct2(Integer[] arr) {
    HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(arr));
    return hashSet.size();
  }

  private static void testCountDistinct1() {
    Integer[] arr = {10, 12, 12, 20, 10, 20, 10, 10};

    System.out.println(countDistinct(arr));
    System.out.println(countDistinct1(arr));
    System.out.println(countDistinct2(arr));
  }
}
