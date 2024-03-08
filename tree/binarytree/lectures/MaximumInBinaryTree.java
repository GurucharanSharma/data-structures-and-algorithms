package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class MaximumInBinaryTree {

  /**
   * Recursive Appraoch
   */
  public static int execute(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int lMax = execute(root.left);
    int rMax = execute(root.right);
    return Math.max(root.key, Math.max(lMax, rMax));
  }

  /**
   * Iterative Approach
   */
  public static int execute1(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int res = Integer.MIN_VALUE;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        assert curr != null;
        res = Math.max(res, curr.key);

        if (curr.left != null) {
          queue.offer(curr.left);
        }
        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }

    return res;
  }
}
