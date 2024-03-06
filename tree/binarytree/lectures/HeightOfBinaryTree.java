package tree.binarytree.lectures;

import tree.binarytree.BinaryTree.Node;

public class HeightOfBinaryTree {

  public static int execute(Node root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(execute(root.left), execute(root.right));
  }
}
