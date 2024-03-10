package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class LowestCommonAncestor {

  public static Node execute(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    if (root.key > n1 && root.key > n2) {
      return execute(root.left, n1, n2);
    }

    if (root.key < n1 && root.key < n2) {
      return execute(root.right, n1, n2);
    }

    return root;
  }

  public static Node execute1(Node root, int n1, int n2) {
    while (root != null) {
      if (root.key > n1 && root.key > n2) {
        root = root.left;
      } else if (root.key < n1 && root.key < n2) {
        root = root.right;
      } else {
        break;
      }
    }

    return root;
  }
}
