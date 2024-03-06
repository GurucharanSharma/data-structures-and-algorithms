package tree.lectures;

import java.util.LinkedList;
import java.util.Queue;
import tree.BinaryTree.Node;

public class DeletionInBinaryTree {

  public static void execute(Node root, int val) {
    if (root == null) {
      return;
    }

    Node curr = null;
    Node valNode = null;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      curr = queue.poll();
      if (curr.key == val) {
        valNode = curr;
      }

      if (curr.left != null) {
        queue.offer(curr.left);
      }

      if (curr.right != null) {
        queue.offer(curr.right);
      }
    }

    assert valNode != null;
    int data = curr.key;
    deleteNode(root, curr);
    valNode.key = data;
  }

  private static void deleteNode(Node root, Node lastNode) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      if (curr.right != null) {
        if (curr.right == lastNode) {
          curr.right = null;
          return;
        } else {
          queue.offer(curr.right);
        }
      }

      if (curr.left != null) {
        if (curr.left == lastNode) {
          curr.left = null;
          return;
        } else {
          queue.offer(curr.left);
        }
      }
    }
  }
}
