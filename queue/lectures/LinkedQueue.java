package queue.lectures;

public class LinkedQueue {

  private static class Node {

    private final int data;
    private Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static class Queue {

    private int size;
    private Node head, tail;

    public Queue() {
      this.size = 0;
      this.head = this.tail = null;
    }

    public boolean enqueue(int data) {
      Node node = new Node(data);

      if (size == 0) {
        head = tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
      size++;

      return true;
    }

    public int dequeue() {
      if (size == 0) {
        return -1;
      } else {
        Node node = head;
        head = head.next;
        size--;

        return node.data;
      }
    }

    public int getSize() {
      return size;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int peek() {
      return this.tail.data;
    }

    public void print() {
      Node curr = this.head;
      while (curr != null) {
        System.out.print("[" + curr.data + "]" + " → ");
        curr = curr.next;
      }
      System.out.println("[X]");
    }
  }
}
