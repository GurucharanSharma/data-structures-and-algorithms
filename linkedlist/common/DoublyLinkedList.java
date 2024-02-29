package linkedlist.common;

import linkedlist.lectures.DeleteFirstNodeOfDoublyLinkedList;
import linkedlist.lectures.DeleteLastNodeOfDoublyLinkedList;
import linkedlist.lectures.InsertAtBeginningOfDoublyLinkedList;
import linkedlist.lectures.InsertAtEndOfDoublyLinkedList;
import linkedlist.lectures.ReverseDoublyLinkedList;

public class DoublyLinkedList {

  public static void main(String[] args) {
    Node head = new Node(1);

    head = InsertAtBeginningOfDoublyLinkedList.run(head);
    print(head);

    head = InsertAtEndOfDoublyLinkedList.run(head);
    print(head);

    head = ReverseDoublyLinkedList.execute(head);
    print(head);

    head = DeleteFirstNodeOfDoublyLinkedList.execute(head);
    print(head);

    head = DeleteLastNodeOfDoublyLinkedList.execute(head);
    print(head);
  }

  private static void print(Node head) {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    while (head != null) {
      System.out.print("[" + head.data + "]" + (head.next == null ? " → " : " ↔ "));
      head = head.next;
    }
    System.out.println("[X]");
  }

  public static class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }
}
