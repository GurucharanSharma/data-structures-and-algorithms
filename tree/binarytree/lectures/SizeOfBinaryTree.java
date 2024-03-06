package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.binarytree.BinaryTree.Node;

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
}
