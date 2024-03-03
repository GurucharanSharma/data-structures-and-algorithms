package tree.lectures;

import tree.BinaryTree.Node;

public class InOrderTraversal {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    execute(root.left);
    System.out.print(root.key + " ");
    execute(root.right);
  }
}
