package tree.binarysearchtree.lectures;

import java.util.Objects;
import java.util.TreeSet;

public class CeilingOnLeftSideInArray {

  public static void main(String[] args) {
    int[] arr = {2, 8, 30, 15, 25, 12};

    System.out.println("Approach 1: ");
    execute(arr);

    System.out.println("Approach 2: ");
    execute1(arr);
  }

  // Naive approach:
  // Time Complexity: O(n^2)
  // Auxiliary Space: O(1)
  public static void execute(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    System.out.print("-1 ");
    for (int i = 1; i < arr.length; i++) {
      int res = Integer.MAX_VALUE;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > arr[i] && arr[j] < res) {
          res = arr[j];
        }
      }
      System.out.print((res == Integer.MAX_VALUE ? -1 : res) + " ");
    }
    System.out.println();
  }

  // Efficient Approach: Using a self-balancing BST (TreeSet in Java)
  // Time Complexity: O(n * log(n))
  // Auxiliary Space: O(n)
  public static void execute1(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    TreeSet<Integer> set = new TreeSet<>();
    set.add(arr[0]);
    System.out.print(-1 + " ");

    for (int i = 1; i < arr.length; i++) {
      Integer ceiling = set.ceiling(arr[i]);
      if (ceiling != null) {
        System.out.print(ceiling + " ");
      } else {
        System.out.print(-1 + " ");
      }

      set.add(arr[i]);
    }
    System.out.println();
  }

  // Approach 3
  private static void ceilingOnLeftSide(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    TreeSet<Integer> treeSet = new TreeSet<>();
    treeSet.add(arr[0]);
    System.out.print(-1 + " ");

    for (int i = 1; i < arr.length; i++) {
      System.out.print(Objects.requireNonNullElse(treeSet.ceiling(arr[i]), -1) + " ");
      treeSet.add(arr[i]);
    }
  }
}
