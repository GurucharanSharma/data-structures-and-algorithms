package tree.binarytree.lectures;

import tree.binarytree.BinaryTree.Node;

public class ConstructBinaryTreeFromInorderAndPreorder {

  private static int preIndex;

  public static Node execute(int[] in, int[] pre, int is, int ie) {
    if (is > ie) {
      return null;
    }

    Node node = new Node(pre[preIndex++]);
    int inIndex = getInIndex(in, node.key);

    node.left = execute(in, pre, is, inIndex - 1);
    node.right = execute(in, pre, inIndex + 1, ie);
    return node;
  }

  private static int getInIndex(int[] in, int val) {
    for (int i = 0; i < in.length; i++) {
      if (in[i] == val) {
        return i;
      }
    }

    return -1;
  }
}
