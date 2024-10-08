package linkedlist.problems;

import linkedlist.common.SinglyLinkedList.Node;

public class IdenticalLinkedLists {

  public static void main(String[] args) {
//    Node head1 = new Node(1);
//    head1.next = new Node(2);
//    head1.next.next = new Node(3);
//    head1.next.next.next = new Node(4);
//    head1.next.next.next.next = new Node(5);
//    head1.next.next.next.next.next = new Node(6);
//
//    Node head2 = new Node(99);
//    head2.next = new Node(59);
//    head2.next.next = new Node(42);
//    head2.next.next.next = new Node(20);

//    Node head1 = new Node(1);
//    head1.next = new Node(2);
//    head1.next.next = new Node(3);
//    head1.next.next.next = new Node(4);
//    head1.next.next.next.next = new Node(5);
//
//    Node head2 = new Node(1);
//    head2.next = new Node(2);
//    head2.next.next = new Node(3);
//    head2.next.next.next = new Node(4);
//    head2.next.next.next.next = new Node(5);

    Node head1 = new Node(1);
    head1.next = new Node(2);
    head1.next.next = new Node(3);
    head1.next.next.next = new Node(4);
    head1.next.next.next.next = new Node(5);

    Node head2 = new Node(1);
    head2.next = new Node(2);
    head2.next.next = new Node(3);
    head2.next.next.next = new Node(4);
    head2.next.next.next.next = new Node(5);
    head2.next.next.next.next.next = new Node(6);

    System.out.println(areIdentical(head1, head2));
  }

  // Function to check whether two linked lists are identical or not.
  private static boolean areIdentical(Node head1, Node head2) {
    if (head1 == null && head2 == null) {
      return true;
    }

    if (head1 == null || head2 == null) {
      return false;
    }

    while (head1 != null && head2 != null) {
      if (head1.data != head2.data) {
        return false;
      }

      head1 = head1.next;
      head2 = head2.next;
    }

    return head1 == null && head2 == null;
  }
}
