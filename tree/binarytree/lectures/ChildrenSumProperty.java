package tree.binarytree.lectures;

import tree.BinaryTree.Node;

/**
 * Children Sum Property is a property in which the sum of values of the left child and right child should be equal to the value of their node if both
 * children are present. Else if only one child is present then the value of the child should be equal to its node value.
 */
public class ChildrenSumProperty {

  // Approach 1
  public static boolean execute(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }

    int sum = 0;

    if (root.left != null) {
      sum += root.left.key;
    }

    if (root.right != null) {
      sum += root.right.key;
    }

    return root.key == sum && execute(root.left) && execute(root.right);
  }

  // Approach 2
  private static boolean execute1(Node root) {
    if (root == null || root.left == null && root.right == null) {
      return true;
    }

    int sum = 0;
    sum += root.left != null ? root.left.key : 0;
    sum += root.right != null ? root.right.key : 0;

    return (root.key == sum) && execute1(root.left) && execute1(root.right);
  }

  // Approach 3
  private static boolean execute2(Node root) {
    if (root == null) {
      return true;
    }

    if (root.left == null && root.right == null) {
      return true;
    } else if (root.left == null) {
      return root.key == root.right.key && execute2(root.right);
    } else if (root.right == null) {
      return root.key == root.left.key && execute2(root.left);
    } else {
      return (root.key == (root.left.key + root.right.key)) && execute2(root.left) && execute2(root.right);
    }
  }
}
