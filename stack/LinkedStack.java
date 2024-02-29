package stack;

public class LinkedStack {

  public static void main(String[] args) {
    Stack stack = new Stack();

    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println(stack.peek());
    System.out.println(stack.getSize());
    System.out.println(stack.isEmpty());

    stack.push(40);
    stack.push(50);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.getSize());
    System.out.println(stack.isEmpty());

    stack.push(60);
    stack.push(70);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.getSize());
    System.out.println(stack.isEmpty());
  }

  static class Stack {

    Node head;
    int size;

    Stack() {
      this.size = 0;
      this.head = null;
    }

    public void push(int data) {
      size++;
      Node node = new Node(data);
      node.next = head;
      head = node;
    }

    public int pop() {
      if (head == null) {
        System.out.println("Stack empty");
        return Integer.MIN_VALUE;
      }

      size--;
      int val = head.data;
      head = head.next;
      return val;
    }

    public int peek() {
      if (head == null) {
        System.out.println("Stack empty");
        return Integer.MIN_VALUE;
      }

      return head.data;
    }

    public int getSize() {
      return size;
    }

    public boolean isEmpty() {
      return head == null;
    }

    private static class Node {

      private final int data;
      private Node next;

      public Node(int data) {
        this.data = data;
        this.next = null;
      }
    }
  }
}
