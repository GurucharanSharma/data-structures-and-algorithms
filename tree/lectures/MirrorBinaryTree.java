package tree.lectures;

import tree.BinaryTree.Node;

public class MirrorBinaryTree {

  public static void execute(Node root) {
    if (root == null) return;

    execute(root.left);
    execute(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
