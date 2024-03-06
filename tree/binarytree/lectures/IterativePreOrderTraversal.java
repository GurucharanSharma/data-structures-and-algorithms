package tree.binarytree.lectures;

import java.util.Stack;
import tree.binarytree.BinaryTree.Node;

public class IterativePreOrderTraversal {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      System.out.print(curr.key + " ");

      if (curr.right != null) {
        stack.push(curr.right);
      }

      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
  }

  public static void execute1(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        System.out.print(curr.key + " ");
        if (curr.right != null) {
          stack.push(curr.right);
        }

        curr = curr.left;
      }

      if (!stack.isEmpty()) {
        curr = stack.pop();
      }
    }
  }
}
