package tree.binarysearchtree.lectures;

import java.util.HashSet;
import tree.BinaryTree.Node;

public class PairSumInBST {

  public static boolean execute(Node root, int sum, HashSet<Integer> set) {
    if (root == null) {
      return false;
    }

    if (execute(root.left, sum, set)) {
      return true;
    }

    if (set.contains(Math.abs(sum - root.key))) {
      return true;
    }
    set.add(root.key);

    return execute(root.right, sum, set);
  }
}
