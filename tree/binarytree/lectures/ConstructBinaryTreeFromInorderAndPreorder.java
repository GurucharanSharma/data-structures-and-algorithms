package tree.binarytree.lectures;

import java.util.HashMap;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class ConstructBinaryTreeFromInorderAndPreorder {

  private static final TreeFormatter formatter = new TreeFormatter();
  private static int preIndex;

  public static void main(String[] args) {
    int[] in = {20, 10, 40, 30, 50};
    int[] pre = {10, 20, 30, 40, 50};

    Node root1 = execute(in, pre, 0, in.length - 1);
    formatter.topDown(root1);

    Node root2 = execute1(in, pre, 0, pre.length - 1, 0, in.length - 1);
    formatter.topDown(root2);

    Node root3 = execute2(in, pre);
    formatter.topDown(root3);
  }

  // Approach 1: Using global variable
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

  // Approach 2: Without using global variable
  public static Node execute1(int[] in, int[] pre, int ps, int pe, int is, int ie) {
    if (is > ie || ps > pe) {
      return null;
    }

    Node node = new Node(pre[ps]);
    int inIndex = getInIndex(in, node.key);
    int nodesOnLeft = (inIndex - is);

    node.left = execute1(in, pre, ps + 1, ps + nodesOnLeft, is, inIndex - 1);
    node.right = execute1(in, pre, ps + nodesOnLeft + 1, pe, inIndex + 1, ie);

    return node;
  }

  // Approach 3
  public static Node execute2(int[] in, int[] pre) {
    HashMap<Integer, Integer> lookup = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      lookup.put(in[i], i);
    }

    return constructTree(in, pre, 0, in.length - 1, 0, pre.length - 1, lookup);
  }

  private static Node constructTree(int[] in, int[] pre, int inStart, int inEnd, int preStart, int preEnd, HashMap<Integer, Integer> lookup) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    Node node = new Node(pre[preStart]);
    int inIndex = lookup.get(node.key);
    int nodesOnLeft = inIndex - inStart;

    node.left = constructTree(in, pre, inStart, inIndex - 1, preStart + 1, preStart + nodesOnLeft, lookup);
    node.right = constructTree(in, pre, inIndex + 1, inEnd, preStart + nodesOnLeft + 1, preEnd, lookup);

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
