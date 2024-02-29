package linkedlist.lectures;

import linkedlist.common.SNode;
import linkedlist.common.Util;

public class SearchInSinglyLinkedList {

  public static void main(String[] args) {
    SNode head = new SNode(10);
    head.next = new SNode(20);
    head.next.next = new SNode(30);
    head.next.next.next = new SNode(40);
    head.next.next.next.next = new SNode(50);

    Util.print(head);

    System.out.println("Iterative - 1 (Using flag): ");
    System.out.println(search(head, 70));
    System.out.println(search(head, 30));
    System.out.println(search(head, 10));
    System.out.println(search(head, 50));

    System.out.println("Iterative - 2: ");
    System.out.println(search1(head, 70));
    System.out.println(search1(head, 30));
    System.out.println(search1(head, 10));
    System.out.println(search1(head, 50));

    System.out.println("Recursive: ");
    System.out.println(search2(head, 70));
    System.out.println(search2(head, 30));
    System.out.println(search2(head, 10));
    System.out.println(search2(head, 50));
  }

  /**
   * <b>Iterative Approach (Using flag)</b> <br>
   * Time Complexity: O(n) <br>
   * Auxiliary Space: O(1)
   */
  private static int search(SNode head, int x) {
    SNode curr = head;
    boolean found = false;
    int pos = 1;

    while (curr != null) {
      if (curr.data == x) {
        found = true;
        break;
      }

      curr = curr.next;
      pos++;
    }

    if (found) {
      return pos;
    } else {
      return -1;
    }
  }

  /**
   * <b>Iterative Approach (Without using flag)</b> <br>
   * Time Complexity: O(n) <br>
   * Auxiliary Space: O(1)
   */
  private static int search1(SNode head, int x) {
    SNode curr = head;
    int pos = 1;

    while (curr != null) {
      if (curr.data == x) {
        return pos;
      }

      curr = curr.next;
      pos++;
    }

    return -1;
  }

  /**
   * <b>Recursive Approach</b> <br>
   * Time Complexity: O(n) <br>
   * Auxiliary Space: O(n) [Required to maintain function call stack]
   */
  private static int search2(SNode head, int x) {
    if (head == null) {
      return -1;
    }

    if (head.data == x) {
      return 1;
    } else {
      int res = search2(head.next, x);
      if (res == -1) {
        return -1;
      } else {
        return res + 1;
      }
    }
  }
}
