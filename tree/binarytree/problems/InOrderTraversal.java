package tree.binarytree.problems;

import java.util.ArrayList;
import java.util.Stack;
import tree.BinaryTree.Node;

public class InOrderTraversal {

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(3);
//    root.right = new Node(2);

    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    root.right.left = new Node(50);

    System.out.println(inOrder(root));
  }

  // Function to return a list containing the inorder traversal of the tree.
  private static ArrayList<Integer> inOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
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
}
