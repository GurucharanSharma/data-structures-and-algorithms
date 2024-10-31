package tree.binarytree.problems;

import tree.BinaryTree.Node;

public class FoldableBinaryTrees {

  public static void main(String[] args) {
//    Node root = new Node(10);
//    root.left = new Node(7);
//    root.right = new Node(15);
//    root.left.right = new Node(9);
//    root.right.left = new Node(11);

//    Node root = new Node(10);
//    root.left = new Node(7);
//    root.right = new Node(15);
//    root.left.left = new Node(9);
//    root.right.right = new Node(11);

//    Node root = new Node(10);
//    root.left = new Node(7);
//    root.right = new Node(15);
//    root.left.left = new Node(5);
//    root.right.left = new Node(11);

    Node root = new Node(10);
    root.left = new Node(7);
    root.right = new Node(15);
    root.left.left = new Node(9);
    root.left.right = new Node(10);
    root.right.left = new Node(12);

    System.out.println(IsFoldable(root));
    System.out.println();
    System.out.println(IsFoldable1(root));
  }

  // Approach 1: Using recursion
  private static boolean IsFoldable(Node node) {
    if (node == null) {
      return true;
    }

    return areMirrorImages(node.left, node.right);
  }

  private static boolean areMirrorImages(Node left, Node right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    return areMirrorImages(left.left, right.right) && areMirrorImages(left.right, right.left);
  }

  // Approach 2: Finding the mirror image of left subtree and comparing it with the right subtree
  private static boolean IsFoldable1(Node node) {
    if (node == null) {
      return true;
    }

    Node mirror = getMirrorImage(node.left);
    return areIdentical(mirror, node.right);
  }

  private static Node getMirrorImage(Node root) {
    if (root == null) {
      return null;
    }

    Node left = getMirrorImage(root.left);
    Node right = getMirrorImage(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  private static boolean areIdentical(Node T, Node S) {
    if (T == null && S == null) {
      return true;
    }

    if (T == null || S == null) {
      return false;
    }

    return areIdentical(T.left, S.left) && areIdentical(T.right, S.right);
  }
}
