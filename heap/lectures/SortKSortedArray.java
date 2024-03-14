package heap.lectures;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {

  public static void execute(int[] arr, int k) {
    if (arr.length <= 1) {
      return;
    }

    int i = 0;
    Queue<Integer> queue = new PriorityQueue<>();
    for (; i < k; i++) {
      queue.add(arr[i]);
    }

    int index = 0;
    for (; i < arr.length; i++) {
      arr[index++] = queue.remove();
      queue.add(arr[i]);
    }

    while (!queue.isEmpty()) {
      arr[index++] = queue.remove();
    }
  }
}
