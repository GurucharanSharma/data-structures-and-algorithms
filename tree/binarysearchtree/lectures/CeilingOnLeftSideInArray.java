package tree.binarysearchtree.lectures;

import java.util.TreeSet;

public class CeilingOnLeftSideInArray {

  public static void execute(int[] arr) {
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

  public static void execute1(int[] arr) {
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
}
