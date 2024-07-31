package array.problems;

import java.util.Arrays;

public class RearrangeArrayAlternately {

  public static void main(String[] args) {
    long[] arr = {1, 2, 3, 4, 5, 6}; // 6 1 5 2 4 3
//    long[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110}; // 110 10 100 20 90 30 80 40 70 50 60

    System.out.println(Arrays.toString(arr));
    rearrange(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  // temp: input array
  // n: size of array
  //Function to rearrange  the array elements alternately.
  public static void rearrange(long[] arr, int n) {
    int minIndex = 0;
    int maxIndex = n - 1;
    long d = arr[maxIndex] + 1;

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        arr[i] = arr[i] + (arr[maxIndex--] % d) * d;
      } else {
        arr[i] = arr[i] + (arr[minIndex++] % d) * d;
      }
    }

    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] / d;
    }
  }
}
