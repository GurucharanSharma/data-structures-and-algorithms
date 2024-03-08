package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class InsertionInBinaryTree {

  public static boolean execute(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return true;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      if (curr.left == null) {
        curr.left = new Node(val);
        return true;
      } else if (curr.right == null) {
        curr.right = new Node(val);
        return true;
      } else {
        queue.add(curr.left);
        queue.add(curr.right);
      }
    }

    return false;
  }
}
