package tree.binarysearchtree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree.Node;

public class inOrderTraversal {

  public static void main(String[] args) {
    Node root = new Node(15);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.right = new Node(20);
    root.right.left = new Node(18);
    root.right.left.left = new Node(16);
    root.right.right = new Node(80);

    List<Integer> traversal1 = inOrder(root);
    System.out.println(traversal1);
    System.out.println();
    List<Integer> traversal2 = inOrder1(root);
    System.out.println(traversal2);
  }

  private static ArrayList<Integer> inOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      list.add(curr.key);
      curr = curr.right;
    }

    return list;
  }

  private static ArrayList<Integer> inOrder1(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    fillInOrderTraversal(root, list);

    return list;
  }

  private static void fillInOrderTraversal(Node root, List<Integer> list) {
    if (root == null) {
      return;
    }

    fillInOrderTraversal(root.left, list);
    list.add(root.key);
    fillInOrderTraversal(root.right, list);
  }
}
