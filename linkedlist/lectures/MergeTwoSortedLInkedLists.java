package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class MergeTwoSortedLInkedLists {

  public static Node execute(Node head1, Node head2) {
    Node a = head1;
    Node b = head2;
    Node tail, head;

    if (a.data < b.data) {
      tail = head = a;
      a = a.next;
    } else {
      tail = head = b;
      b = b.next;
    }

    while (a != null && b != null) {
      if (a.data < b.data) {
        tail.next = a;
        tail = tail.next; // or, tail = a;
        a = a.next;
      } else {
        tail.next = b;
        tail = tail.next; // or, tail = b;
        b = b.next;
      }
    }

    if (a == null) {
      tail.next = b;
    } else {
      tail.next = a;
    }

    return head;
  }
}
