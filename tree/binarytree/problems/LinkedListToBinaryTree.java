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

    Node root = convert(head);
//    Node root = convert1(head);
    formatter.topDown(root);
  }

  // Approach 1
  private static Node convert(LNode head) {
    if (head == null) {
      return null;
    }

    Node node = new Node(head.data);

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

  // Approach 2
  private static Node convert1(LNode head) {
    if (head == null) {
      return null;
    }

    Node root = new Node(head.data);
    Queue<Node> queue = new ArrayDeque<>();

    queue.add(root);

    head = head.next;
    while (head != null) {
      Node curr = queue.remove();

      if (head != null) {
        curr.left = new Node(head.data);
        queue.add(curr.left);
        head = head.next;
      }

      if (head != null) {
        curr.right = new Node(head.data);
        queue.add(curr.right);
        head = head.next;
      }
    }

    return root;
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
