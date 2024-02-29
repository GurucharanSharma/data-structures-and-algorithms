package linkedlist.lectures;

import linkedlist.common.SNode;

public class TraverseSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = new SNode(10);
    head.next = new SNode(20);
    head.next.next = new SNode(30);
    head.next.next.next = new SNode(40);
    head.next.next.next.next = new SNode(50);

    System.out.println("Iterative: ");
    printList(head);
    System.out.println();

    System.out.println("Recursive - 1: ");
    printList1(head);
    System.out.println();

    System.out.println("Recursive - 2: ");
    printList2(head);
    System.out.println();
  }

  /**
   * <b>Iterative Approach</b> <br>
   * Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  private static void printList(SNode head) {
    if (head == null) {
      return;
    }

    while (head != null) {
      System.out.print(head.data + " => ");
      head = head.next;
    }
  }

  /**
   * <b>Recursive Approach</b> <br>
   * Time Complexity: O(n) <br> Auxiliary Space: O(n) [Required to maintain the function call stack] <br>
   * NOTE: Prints the elements in the same order of traversal.
   */
  private static void printList1(SNode head) {
    if (head == null) {
      return;
    }

    System.out.print(head.data + " => ");
    printList1(head.next);
  }

  /**
   * <b>Recursive Approach</b> <br>
   * Time Complexity: O(n) <br> Auxiliary Space: O(n) [Required to maintain the function call stack] <br>
   * NOTE: Prints the elements in the reverse order of traversal.
   */
  private static void printList2(SNode head) {
    if (head == null) {
      return;
    }

    printList2(head.next);
    System.out.print(head.data + " => ");
  }
}
