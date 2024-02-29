package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class RemoveLoopInLinkedList {

  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    if (slow == fast) {
      slow = head;
      while (slow.next != fast.next) {
        slow = slow.next;
        fast = fast.next;
      }

      fast.next = null;
    }

    return head;
  }
}
