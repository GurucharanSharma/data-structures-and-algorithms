package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;

public class CheckForBST {

  private static int prev = Integer.MIN_VALUE;

  public static boolean execute(Node root) {
    if (root == null) {
      return true;
    }

    if (root.left != null && getMax(root.left) > root.key) {
      return false;
    }

    if (root.right != null && getMin(root.right) < root.key) {
      return false;
    }

    return execute(root.left) && execute(root.right);
  }

  private static int getMax(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int max = root.key;
    int lMax = getMax(root.left);
    max = Math.max(max, lMax);

    int rMax = getMax(root.right);
    max = Math.max(max, rMax);

    return max;
  }

  private static int getMin(Node root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    int min = root.key;
    int lMin = getMin(root.left);
    min = Math.min(lMin, min);

    int rMin = getMin(root.right);
    min = Math.min(rMin, min);

    return min;
  }

  public static boolean execute1(Node root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBST(Node root, int min, int max) {
    if (root == null) {
      return true;
    }

    return (root.key > min && root.key < max && isBST(root.left, min, root.key) && isBST(root.right, root.key, max));
  }

  public static boolean execute2(Node root) {
    if (root == null) {
      return true;
    }

    if (!execute2(root.left)) {
      return false;
    }

    if (prev > root.key) {
      return false;
    }

    prev = root.key;
    return execute2(root.right);
  }
}
