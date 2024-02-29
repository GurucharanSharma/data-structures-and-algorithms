package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class RemoveDuplicatesFromSortedSinglyLinkedList {

  public static void execute(Node head) {
    if (head == null || head.next == null) {
      return;
    }

    Node curr = head;
    while (curr.next != null) {
      if (curr.next.data == curr.data) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
  }
}
