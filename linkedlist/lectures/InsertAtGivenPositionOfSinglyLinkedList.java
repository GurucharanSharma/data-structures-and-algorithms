package linkedlist.lectures;

import common.SNode;
import common.Util;

public class InsertAtGivenPositionOfSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = new SNode(10);
    head.next = new SNode(20);
    head.next.next = new SNode(30);
    head.next.next.next = new SNode(40);
    head.next.next.next.next = new SNode(50);

    head = insertPos(head, 80, 1);
    Util.print(head);

    head = insertPos(head, 60, 4);
    Util.print(head);

    head = insertPos(head, 90, 8);
    Util.print(head);
  }

  private static SNode insertPos(SNode head, int x, int pos) {
    SNode node = new SNode(x);
    if (head == null) {
      throw new UnsupportedOperationException("Head should not be null");
    }

    if (pos == 1) {
      node.next = head;
      return node;
    } else {
      SNode curr = head;
      for (int i = 1; i <= pos - 2 && curr != null; i++) {
        curr = curr.next;
      }

      if (curr == null) {
        return head;
      }

      node.next = curr.next;
      curr.next = node;

      return head;
    }
  }
}
