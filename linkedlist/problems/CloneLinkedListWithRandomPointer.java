package linkedlist.problems;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);

    head.random = head.next.next;
    head.next.random = head.next.next.next.next;
    head.next.next.random = head;
    head.next.next.next.random = head.next;
    head.next.next.next.next.random = head.next.next.next.next.next;
    head.next.next.next.next.next.random = head.next.next.next;

    Node cHead = copyList(head);
    printList(cHead);
    System.out.println();

    Node cHead1 = copyList1(head);
    printList(cHead1);
    System.out.println();
  }

  private static Node copyList1(Node head) {
    if (head == null) {
      return null;
    }

    Node cHead = new Node(head.data);
    Map<Integer, Node> lookup = new HashMap<>();

    Node curr = head.next;
    Node cCurr = cHead;

    lookup.put(cCurr.data, cCurr);

    while (curr != null) {
      cCurr.next = new Node(curr.data);
      lookup.put(cCurr.next.data, cCurr.next);
      cCurr = cCurr.next;
      curr = curr.next;
    }

    curr = head;
    cCurr = cHead;
    while (curr != null) {
      if (curr.random != null) {
        cCurr.random = lookup.get(curr.random.data);
      }

      cCurr = cCurr.next;
      curr = curr.next;
    }

    return cHead;
  }

  // Function to clone a linked list with next and random pointer.
  private static Node copyList(Node head) {
    if (head == null) {
      return null;
    }

    Node curr = head;
    while (curr != null) {
      Node next = curr.next;
      curr.next = new Node(curr.data);
      curr.next.next = next;
      curr = next;
    }

    curr = head;
    while (curr != null) {
      curr.next.random = curr.random == null ? null : curr.random.next;
      curr = curr.next.next;
    }

    Node cHead = head.next;
    Node clone = cHead;
    curr = head;

    while (curr != null) {
      curr.next = curr.next.next;
      clone.next = clone.next == null ? null : clone.next.next;
      curr = curr.next;
      clone = clone.next;
    }

    return cHead;
  }

  ///// HELPER METHOD /////
  private static void printList(Node head) {
    while (head != null) {
      if (head.random != null) {
        System.out.print("[ " + head.data + ", " + head.random.data + " ] -> ");
      } else {
        System.out.print("[ " + head.data + ", - ] -> ");
      }

      head = head.next;
    }
    System.out.println("[X]");
  }
}

class Node {

  int data;
  Node next, random;

  Node(int d) {
    data = d;
    next = random = null;
  }
}
