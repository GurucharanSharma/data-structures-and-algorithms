package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;
import java.util.HashSet;

public class IntersectionPointOfTwoLinkedLists {

  /**
   * Naive Approach <br> Time Complexity: O(m + n) <br> Auxiliary Space: O(m)
   */
  public static Node execute(Node head1, Node head2) {
    HashSet<Node> set = new HashSet<>();

    Node curr1 = head1;
    while (curr1 != null) {
      set.add(curr1);
      curr1 = curr1.next;
    }

    Node curr2 = head2;
    while (curr2 != null) {
      if (set.contains(curr2)) {
        return curr2;
      }

      curr2 = curr2.next;
    }

    return new Node(-1);
  }

  /**
   * Naive Approach <br> Time Complexity: O(m + n) + O(m) <br> Auxiliary Space: O(1)
   */
  public static Node execute1(Node head1, Node head2) {
    int len1 = 1;
    Node curr1 = head1;
    while (curr1 != null) {
      curr1 = curr1.next;
      len1++;
    }

    int len2 = 1;
    Node curr2 = head2;
    while (curr2 != null) {
      curr2 = curr2.next;
      len2++;
    }

    int diff;
    curr1 = head1;
    curr2 = head2;

    if (len1 >= len2) {
      diff = len1 - len2;
      while (diff > 0) {
        curr1 = curr1.next;
        diff--;
      }

      while (curr1 != null) {
        if (curr1 == curr2) {
          return curr1;
        }

        curr1 = curr1.next;
        curr2 = curr2.next;
      }
    } else {
      diff = len2 - len1;
      while (diff > 0) {
        curr2 = curr2.next;
        diff--;
      }

      while (curr2 != null) {
        if (curr1 == curr2) {
          return curr1;
        }

        curr1 = curr1.next;
        curr2 = curr2.next;
      }
    }

    return new Node(-1);
  }
}
