package tree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class RightViewOfBinaryTree {

  private static int maxLevel = 0;

  public static void execute(Node root, int level) {
    if (root == null) {
      return;
    }

    if (level > maxLevel) {
      System.out.println(root.key);
      maxLevel = level;
    }

    execute(root.right, level + 1);
    execute(root.left, level + 1);
  }

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        assert curr != null;

        if (i == size - 1) {
          System.out.println(curr.key);
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
