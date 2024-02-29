package stack.lectures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreviousGreaterElement {

  public static List<Integer> execute(int[] arr) {
    Deque<Integer> stack = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();

    list.add(-1);
    stack.push(0);

    for (int i = 1; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
        stack.pop();
      }

      list.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(i);
    }

    return list;
  }
}
