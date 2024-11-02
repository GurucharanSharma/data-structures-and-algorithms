package tree.binarytree.problems;

import tree.BinaryTree.Node;

public class BinaryTreeToCDLL {

  private static Node prev = null;

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//    root.right.left = new Node(8);
//    root.right.left.right = new Node(9);
//    root.left.left.left = new Node(10);
//    root.left.left.right = new Node(11);
//    root.left.left.right.right = new Node(12);

    Node root = new Node(10);
    root.left = new Node(12);
    root.right = new Node(15);
    root.left.left = new Node(25);
    root.left.right = new Node(30);
    root.right.left = new Node(36);

//    Node head = bTreeToClist(root);
//    printList(head);

    Node head = bTreeToClist1(root);
    printList(head);
  }

  // Approach 1: Convert a Binary Tree to a Circular Doubly Link List by Inorder Traversal
  private static Node bTreeToClist(Node root) {
    Node head = bTreeToDlist(root);
    head.left = prev;
    prev.right = head;

    return head;
  }

  private static Node bTreeToDlist(Node root) {
    if (root == null) {
      return null;
    }

    Node head = bTreeToDlist(root.left);
    if (prev == null) {
      head = root;
    } else {
      root.left = prev;
      prev.right = root;
    }

    prev = root;
    bTreeToDlist(root.right);

    return head;
  }

  // Approach 2: Convert a Binary Tree to a Circular Doubly Link List using Recursion
  private static Node bTreeToClist1(Node root) {
    if (root == null) {
      return null;
    }

    Node left = bTreeToClist1(root.left);
    Node right = bTreeToClist1(root.right);

    root.left = root.right = root;

    return concatenate(concatenate(left, root), right);
  }

  private static Node concatenate(Node lHead, Node rHead) {
    if (lHead == null) {
      return rHead;
    }

    if (rHead == null) {
      return lHead;
    }

    Node lLast = lHead.left;
    Node rLast = rHead.left;

    lLast.right = rHead;
    rHead.left = lLast;
    lHead.left = rLast;
    rLast.right = lHead;

    return lHead;
  }

  private static void printList(Node node) {
    if (node == null) {
      return;
    }
    Node curr = node;
    do {
      System.out.print(curr.key + " ");
      curr = curr.right;
    } while (curr != node);
  }
}
