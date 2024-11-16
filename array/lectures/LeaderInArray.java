package array.lectures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {

  public static void main(String[] args) {
    int[] array = new int[]{7, 10, 4, 10, 6, 5, 2};
    printLeaders(array);
  }

  // Does not maintain the original order of elements in the array
  static void printLeaders(int[] array) {
    int n = array.length;
    int currentLeader = array[n - 1];
    System.out.println(currentLeader);

    for (int i = n - 2; i >= 0; i--) {
      if (currentLeader < array[i]) {
        currentLeader = array[i];
        System.out.println(currentLeader);
      }
    }
  }

  // Maintains the original order of elements in the array
  static void printLeaders1(int[] arr) {
    List<Integer> list = new ArrayList<Integer>();
    int max = arr[arr.length - 1];
    list.add(max);

    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] > max) {
        list.add(arr[i]);
        max = arr[i];
      }
    }

    Collections.reverse(list);
    System.out.println(list);
  }

  // Naive Approach
  private static void printLeaders2(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean isLeader = true;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] <= arr[j]) {
          isLeader = false;
          break;
        }
      }

      if (isLeader) {
        System.out.print(arr[i] + " ");
      }
    }
  }
}
