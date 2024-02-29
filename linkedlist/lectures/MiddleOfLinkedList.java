package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class MiddleOfLinkedList {

  /**
   * Naive Approach <br> Time Complexity: O(n) [Twice traversal]
   */
  public static int execute(Node head) {
    if (head == null) {
      return -1;
    }

    int count = 0;
    Node curr = head;
    while (curr != null) {
      curr = curr.next;
      count++;
    }

    curr = head;
    for (int i = 1; i <= count / 2; i++) {
      curr = curr.next;
    }

    return curr.data;
  }

  /**
   * Naive Approach <br> Time Complexity: O(n) [Single traversal]
   */
  public static int execute1(Node head) {
    if (head == null) {
      return -1;
    }

    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow.data;
  }
}
