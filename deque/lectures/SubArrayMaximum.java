package deque.lectures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
 */
public class SubArrayMaximum {

  public static void execute(int[] arr, int k) {
    // Create a Double Ended Queue, Qi
    // that will store indexes of array elements
    // The queue will store indexes of
    // useful elements in every window and it will
    // maintain decreasing order of values
    // from front to rear in Qi, i.e.,
    // arr[Qi.front[]] to arr[Qi.rear()]
    // are sorted in decreasing order
    Deque<Integer> deque = new ArrayDeque<>();

    // Process first k (or first window) elements of array
    int i = 0;
    for (; i < k; i++) {
      // For every element, the previous
      // smaller elements are useless so
      // remove them from Qi
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        // Remove from rear
        deque.pollFirst();
      }

      // Add new element at rear of queue
      deque.offerLast(i);
    }

    // Process rest of the elements,
    // i.e., from arr[k] to arr[n-1]
    System.out.print("[");
    for (; i < arr.length; i++) {
      // The element at the front of the
      // queue is the largest element of
      // previous window, so print it
      System.out.print(arr[deque.peekFirst()] + ", ");

      // Remove the elements which
      // are out of this window
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }

      // Remove all elements smaller
      // than the currently
      // being added element (remove
      // useless elements)
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekFirst()]) {
        deque.pollFirst();
      }

      // Add current element at the rear of Qi
      deque.offerLast(i);
    }

    // Print the maximum element of last window
    System.out.println(arr[deque.peekFirst()] + "]");
  }
}
