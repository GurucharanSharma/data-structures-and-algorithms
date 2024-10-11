package stack.lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

  //  Naive approach
  public static List<Integer> execute(int[] prices) {
    List<Integer> spans = new ArrayList<>();

    for (int i = 0; i < prices.length; i++) {
      int span = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (prices[j] <= prices[i]) {
          span++;
        } else {
          break;
        }
      }

      spans.add(span);
    }

    return spans;
  }

  // Efficient approach
  public static List<Integer> execute1(int[] prices) {
    List<Integer> spans = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    stack.add(0);
    spans.add(1);

    for (int i = 1; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
        stack.pop();
      }

      spans.add(stack.isEmpty() ? i + 1 : i - stack.peek());
      stack.push(i);
    }

    return spans;
  }
}
