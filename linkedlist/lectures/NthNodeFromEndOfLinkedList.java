package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class NthNodeFromEndOfLinkedList {

  /**
   * Naive Approach <br> Time Complexity: O(n) [Twice traversal]
   */
  public static Node execute(Node head, int n) {
    if (head == null) {
      return null;
    }

    int count = 0;
    Node curr = head;
    while (curr != null) {
      curr = curr.next;
      count++;
    }

    curr = head;
    for (int i = 0; i < count - n && curr.next != null; i++) {
      curr = curr.next;
    }

    return curr;
  }

  /**
   * Naive Approach <br> Time Complexity: O(n) [Single traversal]
   */
  public static Node execute1(Node head, int n) {
    if (head == null) {
      return null;
    }

    Node first = head;
    for (int i = 0; i < n; i++) {
      first = first.next;
      if (first.next == null) {
        return head;
      }
    }

    Node second = head;
    while (first != null && second.next != null) {
      first = first.next;
      second = second.next;
    }

    return second;
  }
}
