package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class InsertInBST {

  // Recursive Approach
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

  // Iterative Approach
  public static Node execute1(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }

    Node curr = root;
    while (true) {
      if (curr.key == key) {
        break;
      } else if (curr.key < key) {
        if (curr.right == null) {
          curr.right = new Node(key);
          break;
        } else {
          curr = curr.right;
        }
      } else {
        if (curr.left == null) {
          curr.left = new Node(key);
          break;
        } else {
          curr = curr.left;
        }
      }
    }

    return root;
  }
}
