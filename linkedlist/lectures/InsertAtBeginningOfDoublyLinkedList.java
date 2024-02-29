package linkedlist.lectures;

import linkedlist.common.DoublyLinkedList.Node;

public class InsertAtBeginningOfDoublyLinkedList {

  public static Node run(Node head) {
    head = insertBegin(head, 100);
    head = insertBegin(head, 110);
    head = insertBegin(head, 120);
    head = insertBegin(head, 130);
    head = insertBegin(head, 140);

    return head;
  }

  private static Node insertBegin(Node head, int x) {
    Node node = new Node(x);
    node.next = head;
    if (head != null) {
      head.prev = node;
    }

    return node;
  }
}
