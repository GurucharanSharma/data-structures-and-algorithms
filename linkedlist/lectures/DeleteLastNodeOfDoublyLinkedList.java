package linkedlist.lectures;

import linkedlist.common.DoublyLinkedList.Node;

public class DeleteLastNodeOfDoublyLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    Node curr = head;
    while (curr.next.next != null) {
      curr = curr.next;
    }

    curr.next = null;
    return head;
  }
}
