package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class LeftViewOfBinaryTree {

  private static int maxLevel = 0;

  /**
   * Recursive Approach
   */
  public static void execute(Node root, int level) {
    if (root == null) {
      return;
    }

    if (level > maxLevel) {
      System.out.println(root.key);
      maxLevel = level;
    }

    execute(root.left, level + 1);
    execute(root.right, level + 1);
  }

  /**
   * Iterative Approach
   */
  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        assert curr != null;

        if (i == 0) {
          System.out.println(curr.key + " ");
        }

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }
  }
}
