package tree.binarytree.lectures;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import tree.binarytree.BinaryTree.Node;

public class SpiralTreeTraversal {

  /**
   * Time Complexity: O(n2). Worst case occurs in case of skewed trees.<br> Auxiliary Space: O(n) for call stack since using recursion
   */
  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    boolean reverse = false;
    Stack<Node> stack = new Stack<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        Objects.requireNonNull(curr);

        if (reverse) {
          stack.push(curr);
        } else {
          System.out.print(curr.key + " ");
        }

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }

      if (reverse) {
        while (!stack.isEmpty()) {
          System.out.print(stack.pop().key + " ");
        }
      }
      System.out.println();

      reverse = !reverse;
    }
  }

  /**
   * Time Complexity: O(n) <br>
   * Auxiliary Space: O(n)
   */
  public static void execute1(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> mainStack = new Stack<>();
    Stack<Node> auxStack = new Stack<>();
    mainStack.push(root);

    while (!mainStack.isEmpty() || !auxStack.isEmpty()) {
      while (!mainStack.isEmpty()) {
        Node curr = mainStack.pop();
        System.out.print(curr.key + " ");

        if (curr.left != null) {
          auxStack.push(curr.left);
        }

        if (curr.right != null) {
          auxStack.push(curr.right);
        }
      }
      System.out.println();

      while (!auxStack.isEmpty()) {
        Node curr = auxStack.pop();
        System.out.print(curr.key + " ");

        if (curr.right != null) {
          mainStack.push(curr.right);
        }

        if (curr.left != null) {
          mainStack.push(curr.left);
        }
      }
      System.out.println();
    }
  }
}
