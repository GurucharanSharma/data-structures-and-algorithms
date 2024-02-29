package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;
import java.util.HashSet;

public class DetectLoopInLinkedList {

  /**
   * Naive Approach <br> Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  public static boolean execute(Node head) {
    if (head == null || head.next == null) {
      return false;
    }

    Node curr = head.next;
    while (curr != null) {
      Node pointer = head;
      while (curr.next != pointer && pointer != curr) {
        pointer = pointer.next;
      }

      if (curr.next == pointer) {
        return true;
      }

      curr = curr.next;
    }

    return false;
  }

  /**
   * Iterative Approach <br> Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  public static boolean execute1(Node head) {
    HashSet<Node> visited = new HashSet<>();

    Node curr = head;
    while (curr != null) {
      if (visited.contains(curr)) {
        return true;
      } else {
        visited.add(curr);
      }

      curr = curr.next;
    }

    return false;
  }

  /**
   * Iterative Approach <br> Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  public static boolean execute2(Node head) {
    if (head == null || head.next == null) {
      return false;
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public static int lengthOfLoop(Node head) {
    if (head == null || head.next == null) {
      return -1;
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
      slow = slow.next;
      int count = 1;
      while (slow != fast) {
        slow = slow.next;
        count++;
      }

      return count;
    }

    return -1;
  }

  public static Node firstNodeOfLoop(Node head) {
    if (head == null || head.next == null) {
      return new Node(-1);
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

      return slow;
    }

    return new Node(-1);
  }
}
