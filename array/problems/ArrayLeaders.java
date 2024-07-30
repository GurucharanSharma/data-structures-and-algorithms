package array.problems;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {

  public static void main(String[] args) {
//    int[] arr = {16, 17, 4, 3, 5, 2};
//    int[] arr = {10, 4, 2, 4, 1};
//    int[] arr = {5, 10, 20, 40};
    int[] arr = {30, 10, 10, 5};
    System.out.println(leaders(arr.length, arr));
  }

  // Function to find the leaders in the array.
  static ArrayList<Integer> leaders(int n, int[] arr) {
    ArrayList<Integer> leaders = new ArrayList<>();
    int leader = arr[n - 1];
    leaders.add(leader);

    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] >= leader) {
        leader = arr[i];
        leaders.add(leader);
      }
    }

    Collections.reverse(leaders);
    return leaders;
  }
}
