package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class InsertInBST {

  public static Node execute(Node root, int key) {
    if (root == null) {
      return new Node(key);
    } else if (root.key == key) {
      return root;
    } else if (root.key < key) {
      root.right = execute(root.right, key);
    } else {
      root.left = execute(root.left, key);
    }

    return root;
  }

  public static Node execute1(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }

    while (true) {
      if (root.key == key) {
        break;
      } else if (root.key < key) {
        if (root.right == null) {
          root.right = new Node(key);
          break;
        } else {
          root = root.right;
        }
      } else {
        if (root.left == null) {
          root.left = new Node(key);
          break;
        } else {
          root = root.left;
        }
      }
    }

    return root;
  }
}
