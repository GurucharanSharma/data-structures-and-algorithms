package linkedlist.lectures;

import common.SNode;
import common.Util;

public class DeleteLastNodeOfSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = new SNode(10);
    head.next = new SNode(20);
    head.next.next = new SNode(30);
    head.next.next.next = new SNode(40);
    head.next.next.next.next = new SNode(50);

    head = deleteTail(head);
    Util.print(head);

    head = deleteTail(head);
    Util.print(head);

    head = deleteTail(head);
    Util.print(head);

    head = deleteTail(head);
    Util.print(head);

    head = deleteTail(head);
    Util.print(head);
  }

  private static SNode deleteTail(SNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    SNode curr = head;
    while (curr.next.next != null) {
      curr = curr.next;
    }

    curr.next = null;
    return head;
  }
}
