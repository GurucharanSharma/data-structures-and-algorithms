package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class SortedInsertInSinglyLinkedList {

  public static Node insert(Node head, int x) {
    Node node = new Node(x);
    if (head == null) {
      return node;
    }

    if (x < head.data) {
      node.next = head;
      return node;
    }

    Node curr = head;
    while (curr.next != null && curr.next.data < x) {
      curr = curr.next;
    }

    node.next = curr.next;
    curr.next = node;
    return head;
  }
}
