package tree.binarytree.problems;

import tree.BinaryTree.Node;

public class MaximumDifferenceBetweenNodeAndAncestor {

  private static int maxDiff = Integer.MIN_VALUE;

  public static void main(String[] args) {
//    Node root = new Node(5);
//    root.left = new Node(2);
//    root.right = new Node(1);

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.right = new Node(7);

    maxDiff(root);
    System.out.println(maxDiff);
  }

  // Approach 1: Using recursion
  private static int maxDiff(Node root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    if (root.left == null && root.right == null) {
      return root.key;
    }

    int lMin = maxDiff(root.left);
    int rMin = maxDiff(root.right);

    maxDiff = Math.max(maxDiff, root.key - Math.min(lMin, rMin));

    return Math.min(root.key, Math.min(lMin, rMin));
  }
}
