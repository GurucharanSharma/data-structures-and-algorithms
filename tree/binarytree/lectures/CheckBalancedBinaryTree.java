package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class CheckBalancedBinaryTree {

  /**
   * Time Complexity: O(n^2) in case of full binary tree.<br> Auxiliary Space: O(n) space for call stack since using recursion
   */
  public static boolean execute(Node root) {
    if (root == null) {
      return true;
    }

    int lH = height(root.left);
    int rH = height(root.right);
    return (Math.abs(lH - rH) <= 1 && execute(root.left) && execute(root.right));
  }

  private static int height(Node node) {
    if (node == null) {
      return 0;
    }

    return 1 + Math.max(height(node.left), height(node.right));
  }

  /**
   * Time Complexity: O(n), because we are only one dfs call and utilizing the height returned from that to determine the height balance, it is
   * performing the task in linear time.<br> Auxiliary Space: O(n)
   */
  public static int execute1(Node root) {
    if (root == null) {
      return 0;
    }

    int lH = execute1(root.left);
    if (lH == -1) {
      return -1;
    }

    int rH = execute1(root.right);
    if (rH == -1) {
      return -1;
    }

    if (Math.abs(lH - rH) > 1) {
      return -1;
    } else {
      return 1 + Math.max(lH, rH);
    }
  }

  /**
   * Time Complexity: O(n), because we are only one dfs call and utilizing the height returned from that to determine the height balance, it is
   * performing the task in linear time.<br> Auxiliary Space: O(n)
   */
  private static int execute2(Node root) {
    if (root == null) {
      return 0;
    }

    int lH = execute2(root.left);
    int rH = execute2(root.right);

    if (Math.abs(lH - rH) > 1 || lH == -1 || rH == -1) {
      return -1;
    } else {
      return 1 + Math.max(lH, rH);
    }
  }
}
