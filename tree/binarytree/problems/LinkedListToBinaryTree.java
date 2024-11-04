package tree.binarytree.problems;

import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class LinkedListToBinaryTree {

  private static final TreeFormatter formatter = new TreeFormatter();

  public static void main(String[] args) {
//    LNode head = new LNode(1);
//    head.next = new LNode(2);
//    head.next.next = new LNode(3);
//    head.next.next.next = new LNode(4);
//    head.next.next.next.next = new LNode(5);

    LNode head = new LNode(5);
    head.next = new LNode(4);
    head.next.next = new LNode(3);
    head.next.next.next = new LNode(2);
    head.next.next.next.next = new LNode(1);

    Node root = convert(head, null);
    formatter.topDown(root);
  }

  private static Node convert(LNode head, Node node) {
    if (head == null) {
      return null;
    }

    node = new Node(head.data);

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);

    head = head.next;

    while (head != null) {
      Node parent = queue.remove();
      Node lChild = null, rChild = null;

      if (head != null) {
        lChild = new Node(head.data);
        queue.add(lChild);
        head = head.next;
      }

      if (head != null) {
        rChild = new Node(head.data);
        queue.add(rChild);
        head = head.next;
      }

      parent.left = lChild;
      parent.right = rChild;
    }

    return node;
  }

  static class LNode {

    int data;
    LNode next;

    LNode(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
