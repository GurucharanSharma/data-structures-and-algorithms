package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class ConvertBinaryTreeToDLL {

  private static Node prev;

  public static Node execute(Node root) {
    if (root == null) {
      return root;
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
