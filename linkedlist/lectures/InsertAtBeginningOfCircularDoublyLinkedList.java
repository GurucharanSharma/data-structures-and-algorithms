package linkedlist.lectures;

import linkedlist.common.CircularDoublyLinkedList.Node;

public class InsertAtBeginningOfCircularDoublyLinkedList {

  public static Node execute(Node head, int x) {
    Node node = new Node(x);
    if (head == null) {
      node.next = node;
      node.prev = node;
      return node;
    }

    head.prev.next = node;
    node.prev = head.prev;
    node.next = head;
    head.prev = node;
    return node;
  }
}
