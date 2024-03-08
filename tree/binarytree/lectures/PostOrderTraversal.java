package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class PostOrderTraversal {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    execute(root.left);
    execute(root.right);
    System.out.print(root.key + " ");
  }
}
