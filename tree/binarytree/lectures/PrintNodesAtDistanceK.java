package tree.binarytree.lectures;

import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;

public class PrintNodesAtDistanceK {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(8);
    root.right.left.right = new Node(9);
    root.left.left.left = new Node(10);
    root.left.left.right = new Node(11);
    root.left.left.right.right = new Node(12);

    execute(root, 3);
    System.out.println();
    execute1(root, 3);
  }

  /**
   * Recursive approach
   */
  public static void execute(Node root, int k) {
    if (root == null) {
      return;
    }

    if (k == 0) {
      System.out.print(root.key + " ");
    }

    execute(root.left, k - 1);
    execute(root.right, k - 1);
  }

  /**
   * Iterative approach using Queue
   */
  public static void execute1(Node root, int k) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    int level = 0;
    while (!queue.isEmpty() && level <= k) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node curr = queue.remove();

        if (level == k) {
          System.out.print(curr.key + " ");
        }

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }

      level++;
    }
  }
}
