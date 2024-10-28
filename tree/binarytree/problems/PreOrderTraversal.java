package tree.binarytree.problems;

import java.util.ArrayList;
import java.util.Stack;
import tree.BinaryTree.Node;

public class PreOrderTraversal {

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(4);
//    root.left.left = new Node(4);
//    root.left.right = new Node(2);

    Node root = new Node(6);
    root.left = new Node(3);
    root.right = new Node(2);
    root.left.right = new Node(1);
    root.right.left = new Node(2);

    System.out.println(preorder(root));
    System.out.println();
    System.out.println(preorder1(root));
  }

  // Function to return a list containing the preorder traversal of the tree.
  static ArrayList<Integer> preorder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Stack<Node> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        list.add(curr.key);
        if (curr.right != null) {
          stack.push(curr.right);
        }

        curr = curr.left;
      }

      if (!stack.isEmpty()) {
        curr = stack.pop();
      }
    }

    return list;
  }

  static ArrayList<Integer> preorder1(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    fillList(root, list);
    return list;
  }

  private static void fillList(Node root, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }

    list.add(root.key);
    fillList(root.left, list);
    fillList(root.right, list);
  }
}
