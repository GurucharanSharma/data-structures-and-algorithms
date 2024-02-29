package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class PalindromeLinkedList {

  public static boolean execute(Node head) {
    if (head == null || head.next == null) {
      return true;
    }

    Node slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    Node revHead = reverse(slow.next);
    slow = head;
    fast = revHead;
    while (fast != null) {
      if (fast.data != slow.data) {
        reverse(revHead);
        return false;
      }

      fast = fast.next;
      slow = slow.next;
    }

    reverse(revHead);
    return true;
  }

  private static Node reverse(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node rH = reverse(head.next);
    Node rT = head.next;
    rT.next = head;
    head.next = null;

    return rH;
  }
}
