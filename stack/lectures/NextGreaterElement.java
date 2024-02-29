package stack.lectures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class NextGreaterElement {

  public static List<Integer> execute(int[] arr) {
    Deque<Integer> stack = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();

    list.add(-1);
    stack.push(arr.length - 1);

    for (int i = arr.length - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }

      list.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(i);
    }

    Collections.reverse(list);
    return list;
  }
}
