package tree.binarytree.lectures;

import java.util.Stack;
import tree.BinaryTree;
import tree.BinaryTree.Node;

public class ConvertBinaryTreeToDLL {

  private static Node prev;
  private static Node head;

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
//    Node head = convertToDLL(dllTree.root);
//    print(head);

//    [X] ← [4] ↔ [2] ↔ [5] ↔ [1] ↔ [3] ↔ [6] ↔ [8] ↔ [7] → [X]
//    Node head = execute(dllTree.root);
//    print(head);

    convertToDLL1(dllTree.root);
    print(head);
  }

  // Approach 1: Uses pre order traversal (Creates a Singly Linked List)
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

  // Approach 2: Uses in-order traversal (Start creating from head to tail)
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

  // Approach 3: Start creating from tail to head
  public static void convertToDLL1(Node root) {
    if (root == null) {
      return;
    }

    convertToDLL1(root.right);

    root.right = head;
    if (head != null) {
      head.left = root;
    }

    head = root;

    convertToDLL1(root.left);
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
