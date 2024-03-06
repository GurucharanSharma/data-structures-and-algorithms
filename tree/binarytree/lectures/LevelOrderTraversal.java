package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.binarytree.BinaryTree.Node;

public class LevelOrderTraversal {

  private static int height(Node root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(height(root.left), height(root.right));
  }

  private static void printAtK(Node root, int k) {
    if (root == null) {
      return;
    }

    if (k == 0) {
      System.out.print(root.key + " ");
    }

    printAtK(root.left, k - 1);
    printAtK(root.right, k - 1);
  }

  /**
   * Naive Approach
   */
  public static void execute(Node root) {
    int height = height(root);
    for (int i = 0; i < height; i++) {
      printAtK(root, i);
      System.out.println();
    }
  }

  public static void execute1(Node root) {
    if (root == null) {
      System.err.println("Root node is null");
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    while (queue.size() > 1) {
      Node curr = queue.poll();
      if (curr == null) {
        System.out.println();
        queue.offer(null);
      } else {
        System.out.print(curr.key + " ");

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }
    System.out.println();
  }

  public static void execute2(Node root) {
    if (root == null) {
      System.err.println("Root node is null");
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        assert curr != null;
        System.out.print(curr.key + " ");

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      System.out.println();
    }
  }
}
