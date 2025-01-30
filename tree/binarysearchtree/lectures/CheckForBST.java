package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class CheckForBST {

  private static int prev = Integer.MIN_VALUE;

  // Naive Approach
  public static boolean isBST(Node root) {
    if (root == null) {
      return true;
    }

    if (root.left != null && getMax(root.left) > root.key) {
      return false;
    }

    if (root.right != null && getMin(root.right) < root.key) {
      return false;
    }

    return isBST(root.left) && isBST(root.right);
  }

  private static int getMax(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int lMax = getMax(root.left);
    int rMax = getMax(root.right);

    return Math.max(root.key, Math.max(lMax, rMax));
  }

  private static int getMin(Node root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    int lMin = getMin(root.left);
    int rMin = getMin(root.right);

    return Math.min(root.key, Math.min(lMin, rMin));
  }

  // Efficient Approach 1: Using the upper and lower bounds for each node
  public static boolean isBST1(Node root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBST(Node root, int min, int max) {
    if (root == null) {
      return true;
    }

    return (root.key > min && root.key < max && isBST(root.left, min, root.key) && isBST(root.right, root.key, max));
  }

  // Efficient Approach 2: Using In-order traversal
  public static boolean isBST2(Node root) {
    if (root == null) {
      return true;
    }

    if (!isBST2(root.left)) {
      return false;
    }

    if (prev >= root.key) {
      return false;
    }

    prev = root.key;
    return isBST2(root.right);
  }
}
