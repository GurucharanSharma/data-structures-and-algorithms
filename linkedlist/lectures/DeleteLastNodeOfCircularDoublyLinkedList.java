package linkedlist.lectures;

import linkedlist.common.CircularDoublyLinkedList.Node;

public class DeleteLastNodeOfCircularDoublyLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    head.prev.data = head.data;
    head.prev.next = head.next;
    head.next.prev = head.prev;
    return head.prev;
  }
}
