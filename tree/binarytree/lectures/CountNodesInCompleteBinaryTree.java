package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class CountNodesInCompleteBinaryTree {

  public static void main(String[] args) {
    // Binary tree
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(8);
    root.right.left.right = new Node(9);
    root.left.left.left = new Node(10);
    root.left.left.right = new Node(11);
    root.left.left.right.right = new Node(12);

//    Node root = new Node(10);
//    root.left = new Node(20);
//    root.right = new Node(30);
//    root.right.left = new Node(40);
//    root.right.right = new Node(50);

//    Node root = new Node(20);
//    root.left = new Node(8);
//    root.right = new Node(12);
//    root.right.left = new Node(3);
//    root.right.right = new Node(9);

    System.out.println(countNodes(root));
    System.out.println();
    System.out.println(countNodes1(root));
  }

  // Naive approach
  private static int countNodes(Node root) {
    if (root == null) {
      return 0;
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  // Efficient approach
  private static int countNodes1(Node root) {
    if (root == null) {
      return 0;
    }

    int lCount = 0;
    Node curr = root;
    while (curr != null) {
      lCount++;
      curr = curr.left;
    }

    int rCount = 0;
    curr = root;
    while (curr != null) {
      rCount++;
      curr = curr.right;
    }

    if (lCount == rCount) {
      return (int) Math.pow(2, lCount) - 1;
    } else {
      return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
  }
}
