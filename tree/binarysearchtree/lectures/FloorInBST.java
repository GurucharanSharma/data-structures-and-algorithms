package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class FloorInBST {

  public static Node floor;

  // Approach 1: Recursive approach
  public static void execute(Node root, int key) {
    if (root == null) {
      return;
    }

    if (root.key == key) {
      floor = root;
    } else if (root.key < key) {
      floor = root;
      execute(root.right, key);
    } else {
      execute(root.left, key);
    }
  }

  // Approach 2: Recursive approach
  public static void execute1(Node root, int key) {
    if (root == null) {
      return;
    }

    execute1(root.left, key);

    if (root.key == key || root.key < key) {
      floor = root;
    }

    execute1(root.right, key);
  }

  // Approach 3: Iterative approach
  public static Node execute2(Node root, int key) {
    Node res = null;

    while (root != null) {
      if (root.key == key) {
        return root;
      } else if (root.key < key) {
        res = root;
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return res;
  }
}
