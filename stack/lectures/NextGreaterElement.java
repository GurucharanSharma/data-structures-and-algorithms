package stack.lectures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

  // Naive approach: Insert at the end of the list and then reverse the list
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

  // Efficient approach: Always inserting at the beginning of the list. No need to reverse the list.
  private static List<Integer> nextGreaterElement(int[] arr) {
    List<Integer> list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    list.add(-1);
    stack.push(arr[arr.length - 1]);

    for (int i = arr.length - 2; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      list.add(0, stack.isEmpty() ? -1 : stack.peek());
      stack.push(arr[i]);
    }

    return list;
  }
}
