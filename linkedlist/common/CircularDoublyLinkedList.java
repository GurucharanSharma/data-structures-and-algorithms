package linkedlist.common;

import linkedlist.lectures.DeleteFirstNodeOfCircularDoublyLinkedList;
import linkedlist.lectures.DeleteLastNodeOfCircularDoublyLinkedList;
import linkedlist.lectures.InsertAtBeginningOfCircularDoublyLinkedList;
import linkedlist.lectures.InsertAtEndOfCircularDoublyLinkedList;

public class CircularDoublyLinkedList {

  public static void main(String[] args) {
    Node head = null;
    print(head);

    head = InsertAtBeginningOfCircularDoublyLinkedList.execute(head, 20);
    head = InsertAtBeginningOfCircularDoublyLinkedList.execute(head, 10);
    print(head);

    head = InsertAtEndOfCircularDoublyLinkedList.execute(head, 30);
    head = InsertAtEndOfCircularDoublyLinkedList.execute(head, 40);
    print(head);

    head = DeleteFirstNodeOfCircularDoublyLinkedList.execute(head);
    print(head);

    head = DeleteLastNodeOfCircularDoublyLinkedList.execute(head);
    print(head);
  }

  public static void print(Node head) {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    Node curr = head;
    System.out.print("↕ ↔ ");
    do {
      System.out.print("[" + curr.data + "]" + " ↔ ");
      curr = curr.next;
    } while (curr != head);
    System.out.println("↕");
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
