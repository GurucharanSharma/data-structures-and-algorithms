package sorting.problems;

import java.util.Arrays;

public class ThreeWayPartitioning {

  public static void main(String[] args) {
    testThreeWayPartitioning1();
    testThreeWayPartitioning2();
  }

  //Function to partition the array around the range such
  //that array is divided into three parts.
  private static void threeWayPartition(int[] array, int a, int b) {
    // code here
    int start = 0, mid = 0, end = array.length - 1;

    while (mid <= end) {
      if (array[mid] < a) {
        swap(array, start, mid);
        start++;
        mid++;
      } else if (array[mid] >= a && array[mid] <= b) {
        mid++;
      } else {
        swap(array, mid, end);
        end--;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void testThreeWayPartitioning1() {
    int[] A = {1, 2, 3, 3, 4};
    threeWayPartition(A, 1, 2);
    System.out.println(Arrays.toString(A));
  }

  private static void testThreeWayPartitioning2() {
    int[] A = {1, 4, 3, 6, 2, 1};
    threeWayPartition(A, 1, 3);
    System.out.println(Arrays.toString(A));
  }
}
