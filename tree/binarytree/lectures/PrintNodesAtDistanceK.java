package tree.binarytree.lectures;

import tree.BinaryTree.Node;

public class PrintNodesAtDistanceK {

  public static void execute(Node root, int k) {
    if (root == null) {
      return;
    }

    if (k == 0) {
      System.out.print(root.key + " ");
    }

    execute(root.left, k - 1);
    execute(root.right, k - 1);
  }
}
