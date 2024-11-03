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

  // Recursive approach: Does not follow the exact level order traversal insertion order.
  public static boolean insertInBinaryTree(Node root, int key) {
    if (root == null) {
      root = new Node(key);
      return true;
    }

    // Calculate heights of left and right subtrees
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    // Insert into the shorter subtree to maintain balance (approximate level-order)
    if (leftHeight <= rightHeight) {
      if (root.left == null) {
        root.left = new Node(key);
        return true;
      } else {
        return insertInBinaryTree(root.left, key);
      }
    } else {
      if (root.right == null) {
        root.right = new Node(key);
        return true;
      } else {
        return insertInBinaryTree(root.right, key);
      }
    }
  }

  private static int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }
}
