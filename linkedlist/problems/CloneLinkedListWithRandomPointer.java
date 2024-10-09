package linkedlist.problems;

public class CloneLinkedListWithRandomPointer {

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);

    head = copyList(head);
    printList(head);
  }

  private static void printList(Node head) {
    for (Node curr = head; curr != null; curr = curr.next) {
      System.out.print(curr.data + " ");
    }
    System.out.println();
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
}

class Node {

  int data;
  Node next, random;

  Node(int d) {
    data = d;
    next = random = null;
  }
}
