package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList;
import linkedlist.common.SinglyLinkedList.Node;

public class RemoveLoopInLinkedList {

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = head;

//    head = removeLoop(head);
//    SinglyLinkedList.print(head);

    head = removeLoop1(head);
    SinglyLinkedList.print(head);
  }

  public static Node removeLoop(Node head) {
    if (head == null || head.next == null) {
      return head;
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
      slow = head;
      while (slow.next != fast.next) {
        slow = slow.next;
        fast = fast.next;
      }

      fast.next = null;
    }

    return head;
  }

  // Function to remove a loop in the linked list.
  // Handles
  private static Node removeLoop1(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    if (head.next == head) {
      head.next = null;
      return head;
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
      if (fast == head) {
        fast = head.next;
        while (fast.next != slow) {
          fast = fast.next;
        }
      } else {
        slow = head;
        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }
      }

      fast.next = null;
    }

    return head;
  }
}
