package array.problems;

import java.util.Arrays;

public class RearrangeAnArray {

  public static void main(String[] args) {
//    long[] arr = {1, 0};
    long[] arr = {4, 0, 2, 1, 3};
    System.out.println(Arrays.toString(arr));
    arrange(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  // arr: input array
  // n: size of array
  //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
  //with O(1) extra space.
  private static void arrange(long arr[], int n) {
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] + (arr[(int) arr[i]] % n) * n;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] / n;
    }
  }
}
