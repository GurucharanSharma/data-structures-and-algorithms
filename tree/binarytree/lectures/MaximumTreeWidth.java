package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import tree.BinaryTree.Node;

public class MaximumTreeWidth {

  public static int execute(Node root) {
    if (root == null) {
      return 0;
    }

    int res = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        Objects.requireNonNull(curr);

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }

      res = Math.max(res, size);
    }

    return res;
  }
}
