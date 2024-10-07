package linkedlist.lectures;

import linkedlist.common.CircularDoublyLinkedList.Node;

public class DeleteFirstNodeOfCircularDoublyLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == head) {
      return null;
    }

    head.prev.next = head.next;
    head.next.prev = head.prev;
    return head.next;
  }
}
