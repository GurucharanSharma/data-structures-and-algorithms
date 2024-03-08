package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class BinaryTreeDiameter {

  public static int res = 0;

  /**
   * Time Complexity: O(N2), where N is the number of nodes in the binary tree.<br> Auxiliary Space: O(N) for call stack
   */
  public static int execute(Node root) {
    if (root == null) {
      return 0;
    }

    int rootD = 1 + height(root.left) + height(root.right);
    int leftD = execute(root.left);
    int rightD = execute(root.right);

    return Math.max(rootD, Math.max(leftD, rightD));
  }

  private static int height(Node node) {
    if (node == null) {
      return 0;
    }

    return 1 + Math.max(height(node.left), height(node.right));
  }

  /**
   * Time Complexity: O(N)<br> Auxiliary Space: O(N) due to recursive calls.
   */
  public static int execute1(Node root) {

    if (root == null) {
      return 0;
    }

    int lH = height(root.left);
    int rH = height(root.right);

    res = Math.max(res, 1 + lH + rH);
    return 1 + Math.max(lH, rH);
  }
}
