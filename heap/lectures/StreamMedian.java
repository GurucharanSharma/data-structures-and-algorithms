package heap.lectures;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class StreamMedian {

  public static void execute(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    Arrays.sort(arr);

    int size = 1;
    for (int i = 0; i < arr.length; i++) {
      if (size % 2 == 0) {
        System.out.print((((double) arr[size / 2] + arr[size / 2 - 1]) / 2) + " ");
      } else {
        System.out.print(arr[size / 2] + " ");
      }

      size++;
    }
    System.out.println();
  }

  public static void execute1(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    Queue<Integer> sQueue = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> gQueue = new PriorityQueue<>();
    sQueue.add(arr[0]);
    System.out.print(arr[0] + " ");

    for (int i = 1; i < arr.length; i++) {
      if (sQueue.size() > gQueue.size()) {
        if (arr[i] < sQueue.element()) {
          gQueue.add(sQueue.remove());
          sQueue.add(arr[i]);
        } else {
          gQueue.add(arr[i]);
        }

        System.out.print((((double) sQueue.element() + gQueue.element()) / 2) + " ");
      } else {
        if (arr[i] < sQueue.element()) {
          sQueue.add(arr[i]);
        } else {
          sQueue.add(gQueue.poll());
          gQueue.add(arr[i]);
        }

        System.out.print(sQueue.element() + " ");
      }
    }
    System.out.println();
  }
}
