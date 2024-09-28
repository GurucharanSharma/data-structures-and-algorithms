package hashing.problems;

import java.util.HashSet;

public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
//    int[] a = {89, 24, 75, 11, 23};
//    int[] b = {89, 2, 4};

    int[] a = {1, 2, 3, 4, 5, 6};
    int[] b = {3, 4, 5, 6, 7};

    System.out.println(NumberofElementsInIntersection(a, b, a.length, b.length));
  }

  // Function to return the count of the number of elements in
  // the intersection of two arrays.
  public static int NumberofElementsInIntersection(int[] a, int[] b, int n, int m) {
    HashSet<Integer> lookup = new HashSet<>();
    for (int num : a) {
      lookup.add(num);
    }

    int count = 0;
    for (int num : b) {
      if (lookup.contains(num)) {
        count++;
        lookup.remove(num);
      }
    }

    return count;
  }
}
