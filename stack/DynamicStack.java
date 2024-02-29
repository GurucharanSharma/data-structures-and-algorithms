package stack;

import java.util.ArrayList;
import java.util.List;

public class DynamicStack {

  public static void main(String[] args) {
    Stack stack = new Stack();

    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println(stack.peek());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());

    stack.push(40);
    stack.push(50);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());

    stack.push(60);
    stack.push(70);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());
  }

  static class Stack {

    private final List<Integer> list;

    Stack() {
      list = new ArrayList<>();
    }

    public void push(int val) {
      list.add(val);
    }

    public int pop() {
      return list.remove(list.size() - 1);
    }

    public int peek() {
      return list.get(list.size() - 1);
    }

    public int size() {
      return list.size();
    }

    public boolean isEmpty() {
      return list.isEmpty();
    }
  }
}
