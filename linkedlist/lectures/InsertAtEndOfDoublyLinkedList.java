package linkedlist.lectures;

import linkedlist.common.DoublyLinkedList.Node;

public class InsertAtEndOfDoublyLinkedList {

  public static Node run(Node head) {
    head = InsertAtEndOfDoublyLinkedList.execute(head, 10);
    head = InsertAtEndOfDoublyLinkedList.execute(head, 20);
    head = InsertAtEndOfDoublyLinkedList.execute(head, 30);
    head = InsertAtEndOfDoublyLinkedList.execute(head, 40);
    head = InsertAtEndOfDoublyLinkedList.execute(head, 50);

    return head;
  }

  public static Node execute(Node head, int x) {
    Node node = new Node(x);
    if (head == null) {
      return node;
    }

    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = node;
    node.prev = curr;
    return head;
  }
}
