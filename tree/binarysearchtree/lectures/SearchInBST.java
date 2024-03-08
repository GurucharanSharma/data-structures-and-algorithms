package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class SearchInBST {

  public static Node execute(Node root, int val) {
    if (root == null) {
      return null;
    }

    if (root.key == val) {
      return root;
    } else if (root.key < val) {
      return execute(root.right, val);
    } else {
      return execute(root.left, val);
    }
  }

  public static Node execute1(Node root, int val) {
    if (root == null) {
      return null;
    }

    while (root != null) {
      if (root.key == val) {
        return root;
      } else if (root.key < val) {
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return root; // root would always be null at this point
  }
}
