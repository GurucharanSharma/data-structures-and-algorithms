package sorting.problems;

import java.util.ArrayList;

public class MergeThreeSortedArrays {

  public static void main(String[] args) {
    testMergeThreeSortedArrays1();
    testMergeThreeSortedArrays2();
  }

  // A[], B[], C[]: input arrays
  //Function to merge three sorted lists into a single list.
  static ArrayList<Integer> merge3sorted(int[] A, int[] B, int[] C) {
    // add your code here
    int i = 0, j = 0, k = 0;
    ArrayList<Integer> result = new ArrayList<>(A.length + B.length + C.length);

    while (i < A.length || j < B.length || k < C.length) {
      int a = Integer.MAX_VALUE;
      int b = Integer.MAX_VALUE;
      int c = Integer.MAX_VALUE;

      if (i < A.length) {
        a = A[i];
      }
      if (j < B.length) {
        b = B[j];
      }
      if (k < C.length) {
        c = C[k];
      }

      if (a <= b && a <= c) {
        result.add(a);
        i++;
      } else if (b <= a && b <= c) {
        result.add(b);
        j++;
      } else {
        result.add(c);
        k++;
      }
    }

    return result;
  }

  private static void testMergeThreeSortedArrays1() {
    int[] A = {1, 2, 3, 4};
    int[] B = {1, 2, 3, 4, 5};
    int[] C = {1, 2, 3, 4, 5, 6};

    System.out.println(merge3sorted(A, B, C));
  }

  private static void testMergeThreeSortedArrays2() {
    int[] A = {1, 2};
    int[] B = {2, 3, 4};
    int[] C = {4, 5, 6, 7};

    System.out.println(merge3sorted(A, B, C));
  }
}
