package queue.lectures;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {

  public static void execute(int[] arr, int k) {
    Queue<Integer> queue = new LinkedList<>();

    // Process first k (or first window) elements of array
    int i = 0;
    for (; i < k; i++) {
      // For every element, the previous smaller elements are useless so
      // remove them from Qi
      while (!queue.isEmpty() && arr[i] >= arr[queue.peek()]) {
        queue.poll();
      }

      // Add new element at rear of queue
      queue.offer(i);
    }

    // Process rest of the elements, i.e., from arr[k] to arr[n-1]
    System.out.print("[");
    for (; i < arr.length; i++) {
      // The element at the front of the queue is the largest element of
      // previous window, so print it
      System.out.print(arr[queue.peek()] + ", ");

      // Remove the elements which are out of this window
      while (!queue.isEmpty() && queue.peek() <= i - k) {
        queue.poll();
      }

      // Remove all elements smaller than the currently
      // being added element (remove useless elements)
      while (!queue.isEmpty() && arr[i] >= arr[queue.peek()]) {
        queue.poll();
      }

      // Add current element at the rear of Qi
      queue.offer(i);
    }

    // Print the maximum element of last window
    System.out.println(arr[queue.peek()] + "]");
  }
}
