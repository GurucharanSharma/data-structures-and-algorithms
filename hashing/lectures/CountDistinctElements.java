package hashing.lectures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
      System.out.print(arr[i] + " ");

      // Move the index ahead while there are duplicates
      while (i < arr.length - 1 && arr[i].intValue() == arr[i + 1].intValue()) {
        i++;
      }

      res++;
    }
    System.out.println();

    return res;
  }

  /**
   * Time Complexity: O(n)
   * <p>
   * Auxiliary Space: O(n)
   * <p>
   * NOTE: Sorts the elements of the array
   */
  private static int countDistinct2(Integer[] arr) {
    HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(arr));
//    HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new))); // In case of an int[] as input

    System.out.println(hashSet);
    return hashSet.size();
  }

  /**
   * Time Complexity: O(n)
   * <p>
   * Auxiliary Space: O(n)
   * <p>
   * NOTE: Preserves the order of elements in the arr
   */
  private static int countDistinct3(Integer[] arr) {
    Set<Integer> hashSet = new LinkedHashSet<>(Arrays.asList(arr));

    System.out.println(hashSet);
    return hashSet.size();
  }

  private static void testCountDistinct1() {
    Integer[] arr = {10, 12, 12, 20, 10, 20, 10, 10};

    System.out.println(countDistinct(arr));
    System.out.println(countDistinct1(arr));
    System.out.println(countDistinct2(arr));
    System.out.println(countDistinct3(arr));
  }
}
