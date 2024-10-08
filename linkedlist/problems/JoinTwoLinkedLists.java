package linkedlist.problems;

import linkedlist.common.SinglyLinkedList;
import linkedlist.common.SinglyLinkedList.Node;

public class JoinTwoLinkedLists {

  public static void main(String[] args) {
    Node head1 = new Node(5);

    Node head2 = new Node(1);
    head2.next = new Node(2);

    Node head = joinTheLists(head1, head2);

    SinglyLinkedList.print(head);
  }

  private static Node joinTheLists(Node head1, Node head2) {
    if (head1 == null) {
      return head2;
    }

    if (head2 == null) {
      return head1;
    }

    Node tail = head1;
    while (tail.next != null) {
      tail = tail.next;
    }

    tail.next = head2;
    return head1;
  }
}
