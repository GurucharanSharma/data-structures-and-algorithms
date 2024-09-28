package hashing.problems;

import java.util.Arrays;
import java.util.List;

public class FilterByDigits {

  public static void main(String[] args) {
//    int[] arr = {4, 6, 7};
    int[] arr = {1, 2, 13, 4};

    System.out.println(filterByDigits(Arrays.stream(arr).boxed().toList()));
  }

  private static List<Integer> filterByDigits(List<Integer> arr) {
    return arr.stream().filter(FilterByDigits::containsDigits).toList();
  }

  private static boolean containsDigits(int num) {
    while (num > 0) {
      int digit = num % 10;
      if (!(digit == 1 || digit == 2 || digit == 3)) {
        return false;
      }

      num = num / 10;
    }

    return true;
  }
}
