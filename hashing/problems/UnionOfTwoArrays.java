package hashing.problems;

import java.util.HashSet;

public class UnionOfTwoArrays {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5};
//    int[] brr = {1, 2, 3};

//    int[] arr = {85, 25, 1, 32, 54, 6};
//    int[] brr = {85, 2};

    int[] arr = {1, 2, 1, 1, 2};
    int[] brr = {2, 2, 1, 2, 1};

    System.out.println(doUnion(arr, brr));
  }

  public static int doUnion(int[] arr1, int[] arr2) {
    HashSet<Integer> lookup = new HashSet<>();
    for (int num : arr1) {
      lookup.add(num);
    }

    for (int num : arr2) {
      lookup.add(num);
    }

    return lookup.size();
  }
}
