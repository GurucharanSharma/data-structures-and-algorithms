package linkedlist.problems;

import linkedlist.common.CircularDoublyLinkedList;
import linkedlist.common.CircularDoublyLinkedList.Node;
import linkedlist.lectures.InsertAtEndOfCircularDoublyLinkedList;

public class MiddleOfCircularDoublyLinkedList {

  public static void main(String[] args) {
    Node head = null;
    head = InsertAtEndOfCircularDoublyLinkedList.execute(head, 1);
    head = InsertAtEndOfCircularDoublyLinkedList.execute(head, 2);
    head = InsertAtEndOfCircularDoublyLinkedList.execute(head, 3);

//    CircularDoublyLinkedList.print(head);

    System.out.println(findMiddle(head));
  }

  //Complete the function
  public static int findMiddle(Node head) {
    if (head.next == head) {
      return head.data;
    }

    Node slow = head;
    Node fast = head;

    do {
      slow = slow.next;
      fast = fast.next.next;
    } while (fast != null && fast.next != head);

    return slow.data;
  }
}
