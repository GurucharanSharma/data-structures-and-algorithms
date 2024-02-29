package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class InsertAtBeginningOfSinglyLinkedList {

  public static Node execute(Node head, int x) {
    Node node = new Node(x);

    if (head == null) {
      return node;
    }

    node.next = head;
    return node;
  }
}
