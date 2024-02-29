package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class SegregateEvenAndOddNodes {

  /**
   * Naive Approach <br> Time Complexity: O(n) [twice traversal] <br> Auxiliary Space: O(1)
   */
  public static Node execute(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }

    Node end = tail; // original tail node

    // If head is odd
    while (head != null && head.data % 2 != 0) {
      Node next = head.next;
      tail.next = head;
      tail = tail.next;
      tail.next = null;
      head = next;
    }

    Node curr = head;
    while (curr.next != null && curr != end) {
      if (curr.next.data % 2 != 0) {
        Node next = curr.next.next;
        tail.next = curr.next;
        tail = tail.next;
        tail.next = null;
        curr.next = next;
      } else {
        curr = curr.next;
      }
    }

    return head;
  }

  /**
   * Efficient Approach <br> Time Complexity: O(n) [single traversal] <br> Auxiliary Space: O(1)
   */
  public static Node execute1(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node os = null, oe = null;
    Node es = null, ee = null;

    if (head.data % 2 == 0) {
      es = ee = head;
    } else {
      os = oe = head;
    }

    Node curr = head.next;
    while (curr != null) {
      if (curr.data % 2 == 0) {
        if (es == null) {
          es = ee = curr;
        } else {
          ee.next = curr;
          ee = ee.next;
        }
      } else {
        if (os == null) {
          os = oe = curr;
        } else {
          oe.next = curr;
          oe = oe.next;
        }
      }

      curr = curr.next;
    }

    if (os == null || es == null) {
      return head;
    } else {
      ee.next = os;
      oe.next = null;
      return es;
    }
  }
}
