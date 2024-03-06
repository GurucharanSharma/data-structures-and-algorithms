package tree.lectures;

import java.util.Stack;
import tree.BinaryTree.Node;

public class IterativeInOrderTraversal {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      System.out.print(curr.key + " ");
      curr = curr.right;
    }
  }
}
