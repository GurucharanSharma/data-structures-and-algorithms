package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class FixBSTWithTwoSwappedNodes {

  private static Node prev, first, second;

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    fixNodes(root);

    int temp = first.key;
    first.key = second.key;
    second.key = temp;
  }

  private static void fixNodes(Node root) {
    if (root == null) {
      return;
    }

    fixNodes(root.left);

    if (prev != null && prev.key > root.key) {
      if (first == null) {
        first = prev;
      }

      second = root;
    }
    prev = root;

    fixNodes(root.right);
  }
}
