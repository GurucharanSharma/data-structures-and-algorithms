package linkedlist.lectures;

import linkedlist.common.DoublyLinkedList.Node;

public class ReverseDoublyLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node curr = head, prev = null;
    while (curr != null) {
      prev = curr.prev;
      curr.prev = curr.next;
      curr.next = prev;
      curr = curr.prev; // Since prev is now the new next node
    }

    return prev.prev;
  }
}
