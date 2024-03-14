package heap.lectures;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestElements {

  public static void execute(int[] arr, int k, int num) {
    if (arr.length == 0 || k == 0 || k > arr.length) {
      return;
    }

    boolean[] visited = new boolean[arr.length];

    for (int i = 0; i < k; i++) {
      int minDiff = Integer.MAX_VALUE;
      int minDiffIndex = -1;
      for (int j = 0; j < arr.length; j++) {
        if (!visited[j] && Math.abs(num - arr[j]) <= minDiff) {
          minDiff = Math.abs(num - arr[j]);
          minDiffIndex = j;
        }
      }

      visited[minDiffIndex] = true;
      System.out.print(arr[minDiffIndex] + " ");
    }
    System.out.println();
  }

  public static void execute1(int[] arr, int k, int num) {
    if (arr.length == 0 || k == 0 || k > arr.length) {
      return;
    }

    int i = 0;
    Queue<Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> (Integer.compare(o2.getValue(), o1.getValue())));
    for (; i < k; i++) {
      queue.add(new SimpleEntry<>(arr[i], Math.abs(num - arr[i])));
    }

    for (; i < arr.length; i++) {
      if (Math.abs(num - arr[i]) < queue.element().getValue()) {
        queue.remove();
        queue.add(new SimpleEntry<>(arr[i], Math.abs(num - arr[i])));
      }
    }

    while (!queue.isEmpty()) {
      System.out.print(queue.remove().getKey() + " ");
    }
    System.out.println();
  }
}
