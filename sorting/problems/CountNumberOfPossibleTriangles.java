package sorting.problems;

import java.util.Arrays;

public class CountNumberOfPossibleTriangles {

  public static void main(String[] args) {
//    testFindNumberOfTriangles1();
//    testFindNumberOfTriangles2();
    testFindNumberOfTriangles3();
  }

  //Function to count the number of possible triangles.
  static int findNumberOfTriangles(int[] arr, int n) {
    Arrays.sort(arr);

    int count = 0;

    // code here
    for (int i = n - 1; i >= 2; i--) {
      int l = 0;
      int r = i - 1;

      while (l < r) {
        if (arr[l] + arr[r] > arr[i]) {
          count += (r - l);
          r--;
        } else {
          l++;
        }
      }
    }

    return count;
  }

  private static void testFindNumberOfTriangles1() {
    int[] arr = {3, 5, 4};
    System.out.println(findNumberOfTriangles(arr, arr.length));
  }

  private static void testFindNumberOfTriangles2() {
    int[] arr = {6, 4, 9, 7, 8};
    System.out.println(findNumberOfTriangles(arr, arr.length));
  }

  private static void testFindNumberOfTriangles3() {
    int[] arr = {26, 9, 27, 22, 16, 27};
    System.out.println(findNumberOfTriangles(arr, arr.length));
  }
}
