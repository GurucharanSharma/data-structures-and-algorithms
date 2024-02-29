package linkedlist.lectures;

import linkedlist.common.SNode;
import linkedlist.common.Util;

public class InsertAtEndOfSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = null;
    head = insertEnd(head, 10);
    head = insertEnd(head, 20);
    head = insertEnd(head, 30);
    head = insertEnd(head, 40);
    head = insertEnd(head, 50);

    Util.print(head);
  }

  private static SNode insertEnd(SNode head, int x) {
    SNode node = new SNode(x);
    if (head == null) {
      return node;
    }

    SNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = node;
    return head;
  }
}
