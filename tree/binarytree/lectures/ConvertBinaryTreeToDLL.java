package tree.binarytree.lectures;

import java.util.Stack;
import tree.BinaryTree;
import tree.BinaryTree.Node;

public class ConvertBinaryTreeToDLL {

  private static Node prev;

  public static void main(String[] args) {
    BinaryTree dllTree = new BinaryTree();
    dllTree.root = new Node(1);
    dllTree.root.left = new Node(2);
    dllTree.root.right = new Node(3);
    dllTree.root.left.left = new Node(4);
    dllTree.root.left.right = new Node(5);
    dllTree.root.right.right = new Node(8);
    dllTree.root.right.right.left = new Node(6);
    dllTree.root.right.right.right = new Node(7);

//    [X] ← [1] ↔ [3] ↔ [8] ↔ [7] ↔ [6] ↔ [2] ↔ [5] ↔ [4] → [X]
    Node head = convertToDLL(dllTree.root);
    print(head);

//    [X] ← [4] ↔ [2] ↔ [5] ↔ [1] ↔ [3] ↔ [6] ↔ [8] ↔ [7] → [X]
//    Node head = execute(dllTree.root);
//    print(head);
  }

  // Approach 1: Uses pre order traversal
  public static Node convertToDLL(Node root) {
    if (root == null) {
      return null;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node currNode = stack.pop();

      if (currNode.right != null) {
        stack.push(currNode.right);
      }

      if (currNode.left != null) {
        stack.push(currNode.left);
      }

      if (!stack.isEmpty()) {
        currNode.right = stack.peek();
      }

      currNode.left = null;
    }

    return root;
  }

  // Approach 2L: Uses in-order traversal
  public static Node execute(Node root) {
    if (root == null) {
      return null;
    }

    Node head = execute(root.left);
    if (prev == null) {
      head = root;
    } else {
      prev.right = root;
      root.left = prev;
    }

    prev = root;
    execute(root.right);

    return head;
  }

  public static void print(Node head) {
    if (head == null) {
      return;
    }

    System.out.print("[X] ← ");
    while (head != null) {
      System.out.print("[" + head.key + "]" + (head.right == null ? " → " : " ↔ "));
      head = head.right;
    }
    System.out.println("[X]");
  }
}
