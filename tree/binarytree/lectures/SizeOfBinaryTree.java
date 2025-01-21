package tree.binarytree.lectures;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class SizeOfBinaryTree {

  /**
   * Recursive Approach
   */
  public static int execute(Node root) {
    if (root == null) {
      return 0;
    }

    int lSize = execute(root.left);
    int rSize = execute(root.right);
    return 1 + lSize + rSize;
  }

  // Recursive Approach 2
  public static int size(Node root) {
    if (root.left == null && root.right == null) {
      return 1;
    }

    int res = 1;

    if (root.left != null) {
      res += size(root.left);
    }

    if (root.right != null) {
      res += size(root.right);
    }

    return res;
  }

  /**
   * Iterative Approach
   */
  public static int execute1(Node root) {
    if (root == null) {
      return 0;
    }

    int counter = 0;
    int size = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      size += queue.size();
      for (; counter < size; counter++) {
        Node curr = queue.poll();
        assert curr != null;

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
    }

    return size;
  }

  // Iterative approach 2
  private static int execute2(Node root) {
    Queue<Node> queue = new ArrayDeque<>();
    int count = 0;

    queue.offer(root);
    while (!queue.isEmpty()) {
      count++;
      Node curr = queue.poll();

      if (curr.left != null) {
        queue.offer(curr.left);
      }

      if (curr.right != null) {
        queue.offer(curr.right);
      }
    }

    return count;
  }
}
