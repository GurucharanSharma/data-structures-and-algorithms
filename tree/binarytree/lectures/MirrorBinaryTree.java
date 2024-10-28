package tree.binarytree.lectures;

import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class MirrorBinaryTree {

  private static final TreeFormatter formatter = new TreeFormatter();

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    formatter.topDown(root);
//    execute(root);
//    execute1(root);
    execute2(root);
    formatter.topDown(root);
  }

  // Recursive approach
  // Time Complexity: O(n), Visiting all the nodes of the tree of size n
  // Auxiliary Space: O(h), where h is the height of binary tree.
  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    execute(root.left);
    execute(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
  }

  // Recursive approach
  // Time Complexity: O(n), Visiting all the nodes of the tree of size n
  // Auxiliary Space: O(h), where h is the height of binary tree.
  public static Node execute1(Node root) {
    if (root == null) {
      return null;
    }

    Node left = execute1(root.left);
    Node right = execute1(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  // Iterative approach
  // Time Complexity: O(n), Visiting all the nodes of the tree of size n
  // Auxiliary Space: O(h), where h is the height of binary tree.
  public static void execute2(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.remove();

      // swap left and right nodes
      Node temp = curr.left;
      curr.left = curr.right;
      curr.right = temp;

      if (curr.left != null) {
        queue.add(curr.left);
      }

      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }
}
