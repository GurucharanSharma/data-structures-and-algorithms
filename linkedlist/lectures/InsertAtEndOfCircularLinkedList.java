package linkedlist.lectures;

import linkedlist.common.CircularLinkedList.Node;

public class InsertAtEndOfCircularLinkedList {

  public static Node execute(Node head, int x) {
    Node node = new Node(x);
    if (head == null) {
      node.next = node;
      return node;
    }

    Node curr = head;
    while (curr.next != head) {
      curr = curr.next;
    }

    node.next = curr.next;
    curr.next = node;
    return head; // Head remains the same
  }

  public static Node execute1(Node head, int x) {
    Node node = new Node(x);
    if (head == null) {
      node.next = node;
      return node;
    }

    node.next = head.next;
    head.next = node;

    int temp = head.data;
    head.data = node.data;
    node.data = temp;

    return head.next; // Move head to the old node
  }
}
