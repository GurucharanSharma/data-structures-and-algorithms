package stack.lectures;

import java.util.Stack;

public class GetMinInStack {

  // Needs auxiliary space
  public static class MinStack {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> auxStack;

    public MinStack() {
      this.mainStack = new Stack<>();
      this.auxStack = new Stack<>();
    }

    public boolean push(int val) {
      if (mainStack.isEmpty()) {
        mainStack.push(val);
        auxStack.push(val);
      } else {
        mainStack.push(val);
        if (val <= auxStack.peek()) {
          auxStack.push(val);
        }
      }

      return true;
    }

    public Integer pop() {
      if (mainStack.isEmpty()) {
        return null;
      } else {
        int element = mainStack.pop();
        if (element == auxStack.peek()) {
          auxStack.pop();
        }

        return element;
      }
    }

    public Integer getMin() {
      if (auxStack.isEmpty()) { // We could have checked mainStack.isEmpty().
        return null;
      } else {
        return auxStack.peek();
      }
    }
  }

  // Works only if the stack contains all the positive numbers
  public static class PositiveMinStack {

    private final Stack<Integer> stack;
    private int min;

    public PositiveMinStack() {
      this.stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(val);
        min = val;
      } else if (val < min) {
        stack.push(val - min);
        min = val;
      } else {
        stack.push(val);
      }
    }

    public Integer pop() {
      if (stack.isEmpty()) {
        return null;
      } else {
        int element = stack.pop();
        if (element <= 0) {
          int res = min;
          min = min - element;
          return res;
        } else {
          return element;
        }
      }
    }

    public Integer getMin() {
      if (stack.isEmpty()) {
        return null;
      } else {
        return min;
      }
    }

    public Integer peek() {
      if (stack.isEmpty()) {
        return null;
      }

      int element = stack.peek();
      if (element <= 0) {
        return min;
      }

      return element;
    }
  }

  // Works for all the integers
  public static class ConstantMinStack {

    private final Stack<Integer> stack;
    private int min;

    public ConstantMinStack() {
      this.stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(val);
        min = val;
      } else if (val < min) {
        stack.push(2 * val - min);
        min = val;
      } else {
        stack.push(val);
      }
    }

    public Integer pop() {
      if (stack.isEmpty()) {
        return null;
      } else {
        int element = stack.pop();
        if (element <= min) {
          int res = min;
          min = 2 * min - element;
          return res;
        } else {
          return element;
        }
      }
    }

    public Integer getMin() {
      if (stack.isEmpty()) {
        return null;
      } else {
        return min;
      }
    }

    public Integer peek() {
      if (stack.isEmpty()) {
        return null;
      }

      int element = stack.peek();
      if (element <= min) {
        return min;
      }

      return element;
    }
  }
}
