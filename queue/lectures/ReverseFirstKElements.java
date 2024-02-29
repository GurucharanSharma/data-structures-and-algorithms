package queue.lectures;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

  public static void execute(Queue<Integer> queue, int k) {
    Stack<Integer> stack = new Stack<>();

    int count = 0;
    while (count < k) {
      stack.push(queue.poll());
      count++;
    }

    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }

    for (int i = 0; i < queue.size() - k; i++) {
      queue.offer(queue.poll());
    }
  }
}
