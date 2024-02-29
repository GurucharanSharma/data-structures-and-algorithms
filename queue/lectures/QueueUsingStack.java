package queue.lectures;

import java.util.Stack;

public class QueueUsingStack {

  /**
   * Push Approach: By making enQueue operation costly
   */
  public static class PushQueue {

    Stack<Integer> mainStack;
    Stack<Integer> auxStack;

    public PushQueue() {
      this.mainStack = new Stack<>();
      this.auxStack = new Stack<>();
    }

    public void enqueue(int val) {
      while (!mainStack.isEmpty()) {
        auxStack.push(mainStack.pop());
      }

      mainStack.push(val);

      while (!auxStack.isEmpty()) {
        mainStack.push(auxStack.pop());
      }
    }

    public int dequeue() {
      if (mainStack.isEmpty()) {
        return -1;
      }

      return mainStack.pop();
    }

    public int peek() {
      return mainStack.isEmpty() ? -1 : mainStack.peek();
    }

    public int size() {
      return mainStack.size();
    }

    public boolean isEmpty() {
      return mainStack.isEmpty();
    }

    public void print() {
      while (!mainStack.isEmpty()) {
        System.out.print(mainStack.pop() + " ");
      }
      System.out.println();
    }
  }

  /**
   * Pop Approach: By making deQueue operation costly
   */
  public static class PopQueue {

    Stack<Integer> mainStack;
    Stack<Integer> auxStack;

    public PopQueue() {
      this.mainStack = new Stack<>();
      this.auxStack = new Stack<>();
    }

    public void enqueue(int val) {
      mainStack.push(val);
    }

    public int dequeue() {
      if (mainStack.isEmpty()) {
        return -1;
      }

      while (!mainStack.isEmpty()) {
        auxStack.push(mainStack.pop());
      }

      int res = auxStack.pop();
      while (!auxStack.isEmpty()) {
        mainStack.push(auxStack.pop());
      }

      return res;
    }

    public int peek() {
      if (mainStack.isEmpty()) {
        return -1;
      }

      while (!mainStack.isEmpty()) {
        auxStack.push(mainStack.pop());
      }

      int res = auxStack.peek();
      while (!auxStack.isEmpty()) {
        mainStack.push(auxStack.pop());
      }

      return res;
    }

    public int size() {
      return mainStack.size();
    }

    public boolean isEmpty() {
      return mainStack.isEmpty();
    }

    public void print() {
      while (!mainStack.isEmpty()) {
        System.out.print(mainStack.pop() + " ");
      }
      System.out.println();
    }
  }
}
