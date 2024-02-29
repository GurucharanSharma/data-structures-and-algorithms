package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;
import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

  /**
   * Naive Approach <br> Time Complexity: O(n) [Twice Traversal] <br> Auxiliary Space: O(n)
   */
  public static void execute(Node head) {
    List<Integer> list = new ArrayList<>();
    for (Node curr = head; curr != null; curr = curr.next) {
      list.add(curr.data);
    }

    for (Node curr = head; curr != null; curr = curr.next) {
      curr.data = list.remove(list.size() - 1);
    }
  }

  /**
   * Iterative Approach <br> Time Complexity: O(n) [Single Traversal] <br> Auxiliary Space: O(1)
   */
  public static Node execute1(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node prev = null, curr = head;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  /**
   * Recursive Approach [Reversing from the tail of the linked list] <br> Time Complexity: O(n) [Single Traversal] <br> Auxiliary Space: O(n)
   */
  public static Node execute2(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node rH = execute2(head.next);
    Node rT = head.next;
    rT.next = head;
    head.next = null;
    return rH;
  }

  /**
   * Recursive Approach [Reversing from the head of the linked list]
   * <br> Time Complexity: O(n) [Single Traversal] <br> Auxiliary Space: O(n)
   */
  public static Node execute3(Node curr, Node prev) {
    if (curr == null) {
      return prev;
    }

    Node next = curr.next;
    curr.next = prev;
    return execute3(next, curr);
  }
}
