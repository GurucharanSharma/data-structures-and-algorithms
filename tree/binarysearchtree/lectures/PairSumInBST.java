package tree.binarysearchtree.lectures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree.Node;

public class PairSumInBST {

  // Naive Approach: Using in-order traversal and two pointer approach
  // Time Complexity: O(n)
  // Auxiliary Space: O(n)
  public static boolean execute(Node root, int sum) {
    if (root == null) {
      return false;
    }

    List<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    // Iterative inorder traversal of the binary tree
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      list.add(curr.key);
      curr = curr.right;
    }

    // Two pointer approach to check whether the sum exists
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

  // Efficient Approach: Using Hashing
  // Time Complexity: O(n) (does better than O(n) in most cases)
  // Auxiliary Space: O(n)
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
