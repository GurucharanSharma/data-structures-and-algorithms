package stack.lectures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class PreviousGreaterElement {

  // Pushing the indexes of the previous greater elements
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

  // Pushing the values of the previous greater elements
  private static List<Integer> execute1(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> pGreater = new ArrayList<>();

    pGreater.add(-1);
    stack.push(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      pGreater.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(arr[i]);
    }

    return pGreater;
  }

  // Naive approach
  private static List<Integer> execute2(int[] arr) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      int greater = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > arr[i]) {
          greater = arr[j];
          break;
        }
      }

      list.add(greater);
    }

    return list;
  }
}
