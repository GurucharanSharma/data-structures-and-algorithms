package tree.binarytree.problems;

import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;
import tree.BinaryTree.Node;

public class MaximumPathSumFromAnyNode {

  private static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
//    Node root = new Node(10);
//    root.left = new Node(2);
//    root.right = new Node(-25);
//    root.left.left = new Node(20);
//    root.left.right = new Node(1);
//    root.right.left = new Node(3);
//    root.right.right = new Node(4);

    Node root = new Node(10);
    root.left = new Node(2);
    root.right = new Node(5);
    root.right.right = new Node(-2);

    findMaxSum(root);
    System.out.println(max);
    System.out.println();
    System.out.println(findMaxSum1(root));
  }

  // Approach 1: Using Recursion
  // Assumes that the maximum sum will always be positive. (All nodes will not be negative)
  private static int findMaxSum(Node node) {
    if (node == null) {
      return 0;
    }

    int lSum = Math.max(0, findMaxSum(node.left));
    int rSum = Math.max(0, findMaxSum(node.right));

    max = Math.max(max, node.key + lSum + rSum);

    return node.key + Math.max(lSum, rSum);
  }

  // Approach 2: Using Iterative DFS
  // Handles the scenarios where the max sum can be negative. (All nodes can be negative)
  private static int findMaxSum1(Node node) {
    int max = Integer.MIN_VALUE;
    Stack<SimpleEntry<Node, Integer>> stack = new Stack<>();
    stack.push(new SimpleEntry<>(node, 0));

    while (!stack.isEmpty()) {
      SimpleEntry<Node, Integer> entry = stack.pop();
      Node curr = entry.getKey();
      int visit = entry.getValue();

      if (curr == null) {
        continue;
      }

      if (visit == 0) {
        stack.push(new SimpleEntry<>(curr, 1));
        stack.push(new SimpleEntry<>(curr.left, 0));
      } else if (visit == 1) {
        stack.push(new SimpleEntry<>(curr, 2));
        stack.push(new SimpleEntry<>(curr.right, 0));
      } else {
        int lSum = Math.max(0, (curr.left != null ? curr.left.key : 0));
        int rSum = Math.max(0, (curr.right != null ? curr.right.key : 0));

        max = Math.max(max, curr.key + lSum + rSum);
        curr.key = curr.key + Math.max(lSum, rSum);
      }
    }

    return max;
  }
}
