package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayInGroups {

  public static void main(String[] args) {
//    ArrayList<Long> arr = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
    ArrayList<Long> arr = new ArrayList<Long>(Arrays.asList(5L, 6L, 8L, 9L));

    System.out.println(arr);
    reverseInGroups(arr, 5);
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

  private static void reverse(ArrayList<Long> arr, int start, int end) {
    while (start < end) {
      long temp = arr.get(start);
      arr.set(start, arr.get(end));
      arr.set(end, temp);

      start++;
      end--;
    }
  }
}
