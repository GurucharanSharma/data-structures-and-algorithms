package queue.lectures;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

  /**
   * Iterative Approach
   */
  public static void execute(Queue<Integer> queue) {
    if (queue.size() <= 1) {
      return;
    }

    Stack<Integer> stack = new Stack<>();

    while (!queue.isEmpty()) {
      stack.push(queue.poll());
    }

    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }
  }

  /**
   * Recursive Approach
   */
  public static void execute1(Queue<Integer> queue) {
    if (queue.size() <= 1) {
      return;
    }

    int head = queue.poll();
    execute1(queue);
    queue.offer(head);
  }
}
