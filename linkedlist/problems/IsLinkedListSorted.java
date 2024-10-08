package linkedlist.problems;

import linkedlist.common.SinglyLinkedList.Node;

public class IsLinkedListSorted {

  public static void main(String[] args) {
    Node head = new Node(5);
    head.next = new Node(5);
    head.next.next = new Node(6);
    head.next.next.next = new Node(7);
    head.next.next.next.next = new Node(1);

    System.out.println(isSorted(head));
  }

  public static boolean isSorted(Node head) {
    if (head == null || head.next == null) {
      return true;
    }

    Node curr = head;
    int order = -1; // -1 = not defines, 0 = ascending, 1 = descending

    while (curr.next != null) {
      if (curr.data > curr.next.data) {
        if (order == 0) {
          return false;
        } else {
          order = 1;
        }
      } else if (curr.data < curr.next.data) {
        if (order == 1) {
          return false;
        } else {
          order = 0;
        }
      }

      curr = curr.next;
    }

    return true;
  }
}
