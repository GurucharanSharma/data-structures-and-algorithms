package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class InsertionInBinaryTree {

  // Iterative Approach 1: Using level order traversal
  // The idea is to do iterative level order traversal of the given tree using a queue.
  // If we find a node whose left child is empty, we make new key as the left child of the node.
  // Else if we find a node whose right child is empty, we make new key as the right child of that node.
  // We keep traversing the tree until we find a node whose either left or right child is empty.
  public static boolean execute(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return true;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      if (curr.left == null) {
        curr.left = new Node(val);
        return true;
      } else if (curr.right == null) {
        curr.right = new Node(val);
        return true;
      } else {
        queue.add(curr.left);
        queue.add(curr.right);
      }
    }

    return false;
  }

  // Recursive approach: Does not follow the level order traversal insertion order.
  private static boolean insertInBinaryTree(Node root, int key) {
    if (root == null) {
      root = new Node(key);
      return true;
    }

    if (root.left == null) {
      root.left = new Node(key);
      return true;
    } else if (root.right == null) {
      root.right = new Node(key);
      return true;
    } else {
      return insertInBinaryTree(root.left, key) || insertInBinaryTree(root.right, key);
    }
  }
}
