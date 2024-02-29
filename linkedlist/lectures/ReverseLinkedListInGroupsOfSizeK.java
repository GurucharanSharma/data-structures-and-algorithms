package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class ReverseLinkedListInGroupsOfSizeK {

  /**
   * Iterative Approach <br> Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  public static Node execute(Node head, int k) {
    Node curr = head, prevFirst = null;
    boolean isFirstPass = true;

    while (curr != null) {
      int count = 1;
      Node prev = null, currFirst = curr;

      while (curr != null && count <= k) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        count++;
      }

      if (isFirstPass) {
        head = prev;
        isFirstPass = false;
      } else {
        prevFirst.next = prev;
      }

      prevFirst = currFirst;
    }

    return head;
  }

  /**
   * Recursive Approach <br> Time Complexity: O(n)<br> Auxiliary Space: O(n)
   */
  public static Node execute1(Node head, int k) {
    Node curr = head, prev = null, next = null;
    int count = 0;

    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }

    if (next != null) {
      head.next = execute1(next, k);
    }

    return prev;
  }
}
