package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class CeilInBST {

  public static Node ceil;

  public static Node execute(Node root, int key) {
    Node ceil = null;

    while (root != null) {
      if (root.key == key) {
        return root;
      } else if (root.key > key) {
        ceil = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }

    return ceil;
  }

  public static void execute1(Node root, int key) {
    if (root == null) {
      return;
    }

    execute1(root.left, key);

    if (root.key == key) {
      ceil = root;
    } else if (root.key > key) {
      if (ceil != null && root.key <= ceil.key) {
        ceil = root;
      } else if (ceil == null) {
        ceil = root;
      }
    }

    execute1(root.right, key);
  }

  public static void execute2(Node root, int key) {
    if (root == null) {
      return;
    }

    if (root.key == key) {
      ceil = root;
    } else if (root.key > key) {
      ceil = root;
      execute2(root.left, key);
    } else {
      execute2(root.right, key);
    }
  }
}
