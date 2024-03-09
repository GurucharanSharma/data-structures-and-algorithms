package tree.binarysearchtree.lectures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree.Node;

public class PairSumInBST {

  public static boolean execute(Node root, int sum) {
    if (root == null) {
      return false;
    }

    List<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      list.add(curr.key);
      curr = curr.right;
    }

    int i = 0;
    int j = list.size() - 1;
    int res = 0;
    while (i < j) {
      res = list.get(i) + list.get(j);
      if (res == sum) {
        return true;
      } else if (res > sum) {
        j--;
      } else {
        i++;
      }
    }

    return false;
  }

  public static boolean execute1(Node root, int sum, HashSet<Integer> set) {
    if (root == null) {
      return false;
    }

    if (execute1(root.left, sum, set)) {
      return true;
    }

    if (set.contains(Math.abs(sum - root.key))) {
      return true;
    }
    set.add(root.key);

    return execute1(root.right, sum, set);
  }
}
