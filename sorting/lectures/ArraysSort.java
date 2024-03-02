package sorting.lectures;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {

  public static void main(String[] args) {
    Integer[] arr1 = {5, 20, 10, 3, 12};
    Arrays.sort(arr1, new EvenComparator());
    System.out.println(Arrays.toString(arr1));

    Integer[] arr2 = {5, 20, 10, 3, 12};
    Arrays.sort(arr2, new EvenComparator().reversed());
    System.out.println(Arrays.toString(arr2));
  }
}

class EvenComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
    return o1 % 2 - o2 % 2;
  }

  @Override
  public Comparator<Integer> reversed() {
    return Comparator.super.reversed();
  }
}
