package linkedlist.problems;

import linkedlist.common.SinglyLinkedList;
import linkedlist.common.SinglyLinkedList.Node;

public class SwapKthNodesFromEnds {

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.next = new Node(7);

    SinglyLinkedList.print(head);

    Node head1 = swapKthNode(head, 2);

    SinglyLinkedList.print(head1);
  }

  // Naive Approach
  // If swapping nodes data is allowed
  private static Node swapKthNode2(Node head, int k) {
    int n = countNodes(head);

    if (k > n) {
      return head;
    }

    Node first = head;
    for (int i = 1; i < k; i++) {
      first = first.next;
    }

    Node second = head;
    for (int i = 1; i < n - k + 1; i++) {
      second = second.next;
    }

    int temp = first.data;
    first.data = second.data;
    second.data = temp;

    return head;
  }

  // Naive Approach
  // If only physical swapping of the nodes is allowed. No data swapping is allowed.
  private static Node swapKthNode1(Node head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    int size = countNodes(head);
    if (k > size) {
      return head;
    }

    // The nth node from beginning and end are the same.
    // Note: The node is the middle element.
    if (2 * k - 1 == size) {
      return head;
    }

    Node fPrev = null;
    Node first = head;
    for (int i = 1; i < k; i++) {
      fPrev = first;
      first = first.next;
    }

    Node second = head;
    Node sPrev = null;
    for (int i = 1; i < size - k + 1; i++) {
      sPrev = second;
      second = second.next;
    }

    if (fPrev != null) {
      fPrev.next = second;
    }

    if (sPrev != null) {
      sPrev.next = first;
    }

    Node temp = first.next;
    first.next = second.next;
    second.next = temp;

    if (k == 1) {
      return second;
    } else if (k == size) {
      return first;
    } else {
      return head;
    }
  }

  private static int countNodes(Node head) {
    int count = 0;
    while (head != null) {
      head = head.next;
      count++;
    }

    return count;
  }

  // Efficient Approach
  // If swapping nodes data is allowed
  private static Node swapKthNode(Node head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    int count = 0;
    Node fast = head;
    while (count < k - 1 && fast.next != null) {
      count++;
      fast = fast.next;
    }

    if (count < k - 1) {
      return head;
    }

    Node first = fast;
    Node slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    Node second = slow;
    int temp = first.data;
    first.data = second.data;
    second.data = temp;

    return head;
  }
}
