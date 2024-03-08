package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class PreOrderTraversal {

  public static void execute(Node root) {
    if (root == null) return;

    System.out.print(root.key + " ");
    execute(root.left);
    execute(root.right);
  }
}
