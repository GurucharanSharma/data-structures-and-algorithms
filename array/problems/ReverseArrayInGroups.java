package array.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroups {

  public static void main(String[] args) {
    ArrayList<Long> arr = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
    int k = 3;
//    ArrayList<Long> arr = new ArrayList<Long>(Arrays.asList(5L, 6L, 8L, 9L));
//    int k = 5

    System.out.println(arr);
    reverseInGroups(arr, k);
    System.out.println(arr);
    System.out.println();

    System.out.println(arr);
    reverseInGroups1(arr, k);
    System.out.println(arr);

    System.out.println(arr);
    reverseInGroups2(arr, k);
    System.out.println(arr);
  }

  // Function to reverse every sub-array group of size k.
  private static void reverseInGroups(ArrayList<Long> arr, int k) {
    if (k >= arr.size()) {
      reverse(arr, 0, arr.size() - 1);
      return;
    }

    for (int i = 0; i < arr.size(); i = i + k) {
      int end = (i + k) - 1 >= arr.size() ? arr.size() - 1 : (i + k) - 1;
      reverse(arr, i, end);
    }
  }

  static void reverseInGroups1(ArrayList<Long> arr, int k) {
    int n = arr.size();

    for (int i = 0; i < n; i = i + k) {
      if (i + k < n) {
        reverse(arr, i, i + k - 1);
      } else {
        reverse(arr, i, n - 1);
      }
    }
  }

  private static void reverse(ArrayList<Long> arr, int start, int end) {
    while (start < end) {
      long temp = arr.get(start);
      arr.set(start, arr.get(end));
      arr.set(end, temp);

      start++;
      end--;
    }
  }

  private static void reverseInGroups2(ArrayList<Long> arr, int k) {
    if (arr.size() < k) {
      reverse(arr, 0, arr.size() - 1);
    }

    int start = 0;
    int counter = 1;
    for (int i = 0; i < arr.size(); i++) {
      if (counter < k) {
        counter++;
      } else {
        reverse(arr, start, start + counter - 1);
        start += counter;
        counter = 1;
      }
    }

    if (start < arr.size()) {
      reverse(arr, start, arr.size() - 1);
    }
  }

  private static void reverseInGroups3(int[] arr, int k) {
    int start = 0;
    for (int i = k; i < arr.length; i = i + k) {
      reverseArray(arr, start, i - 1);
      start = i;
    }

    if (start < arr.length) {
      reverseArray(arr, start, arr.length - 1);
    }
  }

  private static void reverseInGroups4(int[] arr, int k) {
    for (int i = 0; i < arr.length; i = i + k) {
      int end = Math.min(i + k - 1, arr.length - 1);
      reverseArray(arr, i, end);
    }
  }

  public static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }
}
