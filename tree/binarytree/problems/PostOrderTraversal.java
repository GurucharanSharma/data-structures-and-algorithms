package tree.binarytree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import tree.BinaryTree.Node;

public class PostOrderTraversal {

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(10);
//    root.right = new Node(39);
//    root.left.left = new Node(5);

    Node root = new Node(19);
    root.left = new Node(10);
    root.right = new Node(8);
    root.left.left = new Node(11);
    root.left.right = new Node(13);

    System.out.println(postOrder(root));
    System.out.println();
    System.out.println(postOrder1(root));
    System.out.println();
    System.out.println(postOrder2(root));
    System.out.println();
    System.out.println(postOrder3(root));
  }

  // Iterative approach: Use 2 stacks
  private static ArrayList<Integer> postOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> mStack = new Stack<>();
    Stack<Node> aStack = new Stack<>();

    mStack.push(root);

    while (!mStack.isEmpty()) {
      Node curr = mStack.pop();
      aStack.push(curr);

      if (curr.left != null) {
        mStack.push(curr.left);
      }

      if (curr.right != null) {
        mStack.push(curr.right);
      }
    }

    while (!aStack.isEmpty()) {
      list.add(aStack.pop().key);
    }

    return list;
  }

  // Iterative approach: Using 1 stack
  // Push directly root node two times while traversing to the left. While popping if you find stack top() is same as root then go for root->right else print root.
  private static ArrayList<Integer> postOrder1(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      if (!stack.isEmpty() && stack.peek() == curr) {
        curr = curr.right;
      } else {
        list.add(curr.key);
        curr = null;
      }
    }

    return list;
  }

  // Iterative approach: Using 1 stack
  // Iterative PostOrder Traversal Using Stack and Hashing
  private static ArrayList<Integer> postOrder2(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Map<Node, Boolean> visitLookup = new HashMap<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.peek();
      visitLookup.put(curr, true);

      if (curr.left != null) {
        if (!visitLookup.containsKey(curr.left) || !visitLookup.get(curr.left)) {
          stack.push(curr.left);
          continue;
        }
      }

      if (curr.right != null) {
        if (!visitLookup.containsKey(curr.right) || !visitLookup.get(curr.right)) {
          stack.push(curr.right);
          continue;
        }
      }

      list.add(curr.key);
      stack.pop();
    }

    return list;
  }

  private static ArrayList<Integer> postOrder3(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;
    boolean addToStack = true;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null && addToStack) {
        stack.push(curr);
        curr = curr.left;
      }

      if (stack.isEmpty()) {
        break;
      }

      if (curr != stack.peek().right) {
        curr = stack.peek().right;
        addToStack = true;
        continue;
      }

      curr = stack.pop();
      list.add(curr.key);
      addToStack = false;
    }

    return list;
  }
}
