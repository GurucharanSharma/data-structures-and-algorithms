package deque.lectures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumInAllSubArrays {

  public static void main(String[] args) {
    int[] arr = {20, 40, 30, 10, 60};
    int k = 3;

    System.out.println(printMax(arr, k));
  }

  private static List<Integer> printMax(int[] arr, int win) {
    List<Integer> list = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < win; i++) {
      while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
        deque.removeLast();
      }

      deque.offerLast(i);
    }

    for (int i = win; i < arr.length; i++) {
      list.add(arr[deque.peekFirst()]);

      while (!deque.isEmpty() && deque.peekFirst() <= (i - win)) {
        deque.removeFirst();
      }

      while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
        deque.removeLast();
      }

      deque.offerLast(i);
    }
    list.add(arr[deque.peekFirst()]);

    return list;
  }
}
