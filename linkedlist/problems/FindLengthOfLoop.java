package linkedlist.problems;

import linkedlist.common.SinglyLinkedList.Node;

public class FindLengthOfLoop {

  public static void main(String[] args) {
    Node head = new Node(25);
    head.next = new Node(14);
    head.next.next = new Node(19);
    head.next.next.next = new Node(33);
    head.next.next.next.next = new Node(10);
    head.next.next.next.next.next = new Node(21);
    head.next.next.next.next.next.next = new Node(39);
    head.next.next.next.next.next.next.next = new Node(90);
    head.next.next.next.next.next.next.next.next = new Node(58);
    head.next.next.next.next.next.next.next.next.next = new Node(45);
//    head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;

    System.out.println(countNodesinLoop(head));
  }

  // Function to find the length of a loop in the linked list.
  private static int countNodesinLoop(Node head) {
    if (head == null || head.next == null) {
      return 0;
    }

    if (head.next == head) {
      return 1;
    }

    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    if (slow == fast) {
      int len = 1;
      for (slow = slow.next; slow != fast; slow = slow.next) {
        len++;
      }

      return len;
    }

    return 0;
  }
}
