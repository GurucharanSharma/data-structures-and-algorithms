package linkedlist.problems;

import linkedlist.common.SinglyLinkedList.Node;

public class CountLinkedListNodes {

  public static void main(String[] args) {
//    Node head = new Node(1);
//    head.next = new Node(2);
//    head.next.next = new Node(3);
//    head.next.next.next = new Node(4);
//    head.next.next.next.next = new Node(5);

    Node head = new Node(2);
    head.next = new Node(4);
    head.next.next = new Node(6);
    head.next.next.next = new Node(7);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(1);
    head.next.next.next.next.next.next = new Node(0);

    System.out.println(getCount(head));
  }

  // Function to count nodes of a linked list.
  private static int getCount(Node head) {
    if (head == null) {
      return 0;
    }

    if (head.next == null) {
      return 1;
    }

    int len = 0;
    for (Node curr = head; curr != null; curr = curr.next) {
      len++;
    }

    return len;
  }
}
