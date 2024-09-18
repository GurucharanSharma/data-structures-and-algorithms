package array.problems;

import java.util.Arrays;

public class FrequencyCount {

  public static void main(String[] args) {
//    int[] arr = {2, 3, 2, 3, 5};
//    int p = 5;

//    int[] arr = {3, 3, 3, 3};
//    int p = 3;

//    int[] arr = {1};
//    int p = 10;

//    int[] arr = {8, 9};
//    int p = 9;

    int[] arr = {4, 5, 6, 7, 8};
    int p = 1000;

    frequencyCount1(arr, arr.length, p);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Approach 1
   */
  //Function to count the frequency of all elements from 1 to N in the array.
  public static void frequencyCount(int[] arr, int N, int P) {
    int d = P + 1;
    for (int i = 0; i < N; i++) {
      int index = (arr[i] % d) - 1;
      if (index < N) {
        arr[index] = (arr[index] + d);
      }
    }

    for (int i = 0; i < N; i++) {
      arr[i] = arr[i] / d;
    }
  }

  /**
   * Approach 2
   */
  //Function to count the frequency of all elements from 1 to N in the array.
  public static void frequencyCount1(int[] arr, int N, int P) {
    for (int i = 0; i < N; i++) {
      arr[i] = arr[i] - 1;
    }

    for (int i = 0; i < N; i++) {
      int index = arr[i] % (P + 1);
      if (index < N) {
        arr[index] = arr[index] + (P + 1);
      }
    }

    for (int i = 0; i < N; i++) {
      arr[i] = arr[i] / (P + 1);
    }
  }
}
