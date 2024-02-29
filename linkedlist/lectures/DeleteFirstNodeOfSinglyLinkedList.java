package linkedlist.lectures;

import common.SNode;
import common.Util;

public class DeleteFirstNodeOfSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = new SNode(10);
    head.next = new SNode(20);
    head.next.next = new SNode(30);
    head.next.next.next = new SNode(40);
    head.next.next.next.next = new SNode(50);

    head = deleteHead(head);
    Util.print(head);

    head = deleteHead(head);
    Util.print(head);

    head = deleteHead(head);
    Util.print(head);
  }

  private static SNode deleteHead(SNode head) {
    if (head == null) {
      return head;
    }

    head = head.next;
    return head;
  }
}
