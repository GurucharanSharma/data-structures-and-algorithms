package linkedlist.lectures;

import linkedlist.common.CircularLinkedList.Node;

public class DeleteFirstNodeOfCircularLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == head) {
      return null;
    }

    Node curr = head;
    while (curr.next != head) {
      curr = curr.next;
    }

    curr.next = head.next;
    return head.next;
  }

  public static Node execute1(Node head) {
    if (head == null || head.next == head) {
      return null;
    }

    head.data = head.next.data;
    head.next = head.next.next;
    return head;
  }
}
