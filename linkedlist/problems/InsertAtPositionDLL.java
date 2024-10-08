package linkedlist.problems;

import linkedlist.common.DoublyLinkedList;
import linkedlist.common.DoublyLinkedList.Node;

public class InsertAtPositionDLL {

  public static void main(String[] args) {
//    Node head = new Node(2);
//    head.next = new Node(4);
//    head.next.next = new Node(5);

//    Node head = new Node(1);
//    head.next = new Node(2);
//    head.next.next = new Node(3);
//    head.next.next.next = new Node(4);

    Node head = new Node(3);
    head.next = new Node(6);
    head.next.next = new Node(1);

    head = addNode(head, 1, 1);

    DoublyLinkedList.print(head);
  }

  // Function to insert a new node at given position in doubly linked list.
  private static Node addNode(Node head, int p, int x) {
    if (head == null) {
      return null;
    }

    Node node = new Node(x);
    if (p == 0) {
      node.next = head;
      return node;
    } else {
      Node curr = head;
      int i = 0;
      while (curr.next != null && i < p) {
        curr = curr.next;
        i++;
      }

      if (i == p) {
        node.next = curr.next;
        curr.next = node;
        node.prev = curr;
        if (node.next != null) {
          node.next.prev = node;
        }
      }
    }

    return head;
  }
}
