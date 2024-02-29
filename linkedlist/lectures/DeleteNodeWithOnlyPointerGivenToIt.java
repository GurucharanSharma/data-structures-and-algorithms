package linkedlist.lectures;

import linkedlist.common.SinglyLinkedList.Node;

public class DeleteNodeWithOnlyPointerGivenToIt {

  public static void execute(Node node) {
    if (node == null || node.next == null) {
      return;
    }

    node.data = node.next.data;
    node.next = node.next.next;
  }
}
