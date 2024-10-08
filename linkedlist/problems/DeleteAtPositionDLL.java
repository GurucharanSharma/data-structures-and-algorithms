package linkedlist.problems;

import linkedlist.common.DoublyLinkedList;
import linkedlist.common.DoublyLinkedList.Node;

public class DeleteAtPositionDLL {

  public static void main(String[] args) {
    Node head = new Node(29);
    head.next = new Node(78);

    DoublyLinkedList.print(head);

    head = deleteNode(head, 1);

    DoublyLinkedList.print(head);
  }

  private static Node deleteNode(Node head, int x) {
    if (head == null) {
      return null;
    }

    if (x == 1) {
      head = head.next;
      head.prev = null;
      
      return head;
    }

    int pos = 1;
    Node curr = head;
    while (curr.next != null && pos < x) {
      curr = curr.next;
      pos++;
    }

    if (pos == x) {
      curr.prev.next = curr.next;

      if (curr.next != null) {
        curr.next.prev = curr.prev;
      }
    }

    return head;
  }
}
