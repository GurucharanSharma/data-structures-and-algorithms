package linkedlist.common;

import linkedlist.lectures.DeleteAtGivenPositionOfCircularLinkedList;
import linkedlist.lectures.DeleteFirstNodeOfCircularLinkedList;
import linkedlist.lectures.InsertAtBeginningOfCircularLinkedList;
import linkedlist.lectures.InsertAtEndOfCircularLinkedList;

public class CircularLinkedList {

  public static void main(String[] args) {
    Node head = null;
    print(head);

    head = InsertAtBeginningOfCircularLinkedList.execute(head, 10);
    head = InsertAtBeginningOfCircularLinkedList.execute(head, 20);
    print(head);

    head = InsertAtBeginningOfCircularLinkedList.execute1(head, 30);
    head = InsertAtBeginningOfCircularLinkedList.execute1(head, 40);
    print(head);

    head = InsertAtEndOfCircularLinkedList.execute(head, 50);
    head = InsertAtEndOfCircularLinkedList.execute(head, 60);
    print(head);

    head = InsertAtEndOfCircularLinkedList.execute1(head, 70);
    head = InsertAtEndOfCircularLinkedList.execute1(head, 80);
    print(head);

    head = DeleteFirstNodeOfCircularLinkedList.execute(head);
    print(head);

    head = DeleteFirstNodeOfCircularLinkedList.execute1(head);
    print(head);

    head = DeleteAtGivenPositionOfCircularLinkedList.execute(head, 3);
    print(head);

    head = DeleteAtGivenPositionOfCircularLinkedList.execute(head, 30);
    print(head);

    head = DeleteAtGivenPositionOfCircularLinkedList.execute(head, 5);
    print(head);
  }

  public static void print(Node head) {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    Node curr = head;
    System.out.print("↓ → ");
    do {
      System.out.print("[" + curr.data + "]" + " → ");
      curr = curr.next;
    } while (curr != head);
    System.out.println("↑");
  }

  public static class Node {

    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
