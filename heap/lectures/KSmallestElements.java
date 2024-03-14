package heap.lectures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestElements {

  public static void execute(int[] arr, int k) {
    if (arr.length == 0 || k == 0 || k > arr.length) {
      return;
    }

    int i = 0;
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (; i < k; i++) {
      queue.add(arr[i]);
    }

    for (; i < arr.length; i++) {
      if (arr[i] < queue.element()) {
        queue.remove();
        queue.add(arr[i]);
      }
    }

    System.out.println(queue);
  }
}
