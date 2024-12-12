package linkedlist.lectures;

import linkedlist.common.CircularLinkedList.Node;

public class DeleteAtGivenPositionOfCircularLinkedList {

  public static Node execute(Node head, int k) {
    if (head == null || head.next == head) {
      return null;
    }

    if (k == 1) {
      head.data = head.next.data;
      head.next = head.next.next;
      return head;
    }

    Node curr = head;
    for (int i = 1; i <= k - 2; i++) {
      curr = curr.next;
    }

    // If k > length of linked list, then curr will loop around. If curr falls back on the first node,
    // then we have to remove the head, which involves an extra operation of moving head as well.
    if (curr.next == head) {
      curr.next = curr.next.next;
      return head.next;
    } else {
      curr.next = curr.next.next;
      return head;
    }
  }
}
