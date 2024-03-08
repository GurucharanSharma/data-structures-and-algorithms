package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class DeleteInBST {

  public static Node execute(Node root, int key) {
    if (root == null) {
      return null;
    }

    if (root.key < key) {
      root.right = execute(root.right, key);
    } else if (root.key > key) {
      root.left = execute(root.left, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        Node succ = getSuccessor(root);
        root.key = succ.key;
        root.right = execute(root.right, succ.key);
      }
    }

    return root;
  }

  private static Node getSuccessor(Node root) {
    Node curr = root.right;
    while (curr != null && curr.left != null) {
      curr = curr.left;
    }

    return curr;
  }
}
