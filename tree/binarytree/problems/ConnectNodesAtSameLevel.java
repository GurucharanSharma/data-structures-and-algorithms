package tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

  public static void main(String[] args) {
//    Node root = new Node(10);
//    root.left = new Node(3);
//    root.right = new Node(5);
//    root.left.left = new Node(4);
//    root.left.right = new Node(1);
//    root.right.right = new Node(2);

    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);

    Node nRoot = connect(root);
    printSpecial(nRoot);
  }

  // Approach 1: Using Level Order Traversal – O(n) Time and O(n) Space
  private static Node connect(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    // Adding 'null' to the queue at the end of each level to differentiate the levels.
    // Otherwise, the last node of a level connects to the first node of next level.
    queue.add(null);

    while (!queue.isEmpty()) {
      Node curr = queue.remove();

      if (curr != null) {
        curr.nextRight = queue.peek();

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      } else {
        if (!queue.isEmpty()) {
          queue.add(null);
        }
      }
    }

    return root;
  }

  // Approach 2: Using Pre-Order Traversal – O(n) Time and O(n) Space
  private static Node connect1(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }

    root.nextRight = null;  // Ideally not required. By default, it should be null.
    connectNextRight(root);

    return root;
  }

  private static void connectNextRight(Node root) {
    if (root == null) {
      return;
    }

    if (root.left != null) {
      root.left.nextRight = root.right;
    }

    if (root.right != null) {
      if (root.nextRight != null) {
        root.right.nextRight = root.nextRight.left;
      } else {
        root.right.nextRight = null;
      }
    }

    connectNextRight(root.left);
    connectNextRight(root.right);
  }

  // Helper method
  private static void printSpecial(Node root) {
    if (root == null) {
      return;
    }

    Node nextRoot = null;

    while (root != null) {
      System.out.print(root.data + " ");

      if (root.left != null && nextRoot == null) {
        nextRoot = root.left;
      } else if (root.right != null && nextRoot == null) {
        nextRoot = root.right;
      }

      root = root.nextRight;
    }
    System.out.println();

    printSpecial(nextRoot);
  }

  static class Node {

    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
      nextRight = null;
    }
  }
}
