package linkedlist.lectures;

import linkedlist.common.DoublyLinkedList.Node;

public class DeleteFirstNodeOfDoublyLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    head = head.next;
    return head;
  }

}
