package tree.binarysearchtree.lectures;

import tree.BinaryTree.Node;
import tree.binarysearchtree.KSmallestTree;

public class KthSmallest {

  private static int count = 0;

  public static void execute(Node root, int k) {
    if (root == null) {
      return;
    }

    execute(root.left, k);
    count++;
    if (count == k) {
      System.out.println(root.key);
      return;
    }

    execute(root.right, k);
  }

  public static KSmallestTree.Node execute(KSmallestTree.Node root, int k) {
    if (root == null) {
      return null;
    }

    int count = root.lcount + 1;
    if (count == k) {
      return root;
    } else if (count > k) {
      return execute(root.left, k);
    } else {
      return execute(root.right, k - count);
    }
  }
}
