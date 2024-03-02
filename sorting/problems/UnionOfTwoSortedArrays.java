package sorting.problems;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {

  public static void main(String[] args) {
    testUnionOfTwoSortedArrays1();
    testUnionOfTwoSortedArrays2();
    testUnionOfTwoSortedArrays3();
  }

  //Function to return a list containing the union of the two arrays.
  public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
    // add your code here
    int i = 0, j = 0;
    ArrayList<Integer> result = new ArrayList<>();

    while (i < n && j < m) {
      if (i > 0 && arr1[i] == arr1[i - 1]) {
        i++;
        continue;
      }

      if (j > 0 && arr2[j] == arr2[j - 1]) {
        j++;
        continue;
      }

      if (arr1[i] < arr2[j]) {
        result.add(arr1[i++]);
      } else if (arr1[i] > arr2[j]) {
        result.add(arr2[j++]);
      } else {
        result.add(arr1[i]);
        i++;
        j++;
      }
    }

    while (i < n) {
      if (i == 0 || (i > 0 && arr1[i] != arr1[i - 1])) {
        result.add(arr1[i++]);
      } else {
        i++;
      }
    }

    while (j < m) {
      if (j == 0 || (j > 0 && arr2[j] != arr2[j - 1])) {
        result.add(arr2[j++]);
      } else {
        j++;
      }
    }

    return result;
  }

  private static void testUnionOfTwoSortedArrays1() {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {1, 2, 3};

    System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
  }

  private static void testUnionOfTwoSortedArrays2() {
    int[] arr1 = {2, 2, 3, 4, 5};
    int[] arr2 = {1, 1, 2, 3, 4};

    System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
  }

  private static void testUnionOfTwoSortedArrays3() {
    int[] arr1 = {1, 1, 1, 1, 1};
    int[] arr2 = {2, 2, 2, 2, 2};

    System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
  }
}
