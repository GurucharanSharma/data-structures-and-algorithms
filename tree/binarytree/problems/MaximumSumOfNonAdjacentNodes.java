package tree.binarytree.problems;

import java.util.HashMap;
import tree.BinaryTree.Node;

public class MaximumSumOfNonAdjacentNodes {

  public static void main(String[] args) {
//    Node root = new Node(11);
//    root.left = new Node(1);
//    root.right = new Node(2);

    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(6);

    System.out.println(getMaxSum(root));
  }

  //Function to return the maximum sum of non-adjacent nodes.
  private static int getMaxSum(Node root) {
    if (root == null) {
      return 0;
    }

    HashMap<Node, Integer> map = new HashMap<>();
    return getNodeSum(root, map);
  }

  private static int getNodeSum(Node root, HashMap<Node, Integer> map) {
    if (root == null) {
      return 0;
    }

    if (map.containsKey(root)) {
      return map.get(root);
    }

    int inclSum = root.key + sumOfGrandChildren(root, map);
    int exclSum = getNodeSum(root.left, map) + getNodeSum(root.right, map);

    map.put(root, Math.max(inclSum, exclSum));
    return map.get(root);
  }

  private static int sumOfGrandChildren(Node root, HashMap<Node, Integer> map) {
    int sum = 0;

    if (root.left != null) {
      sum += getNodeSum(root.left.left, map) + getNodeSum(root.left.right, map);
    }

    if (root.right != null) {
      sum += getNodeSum(root.right.left, map) + getNodeSum(root.right.right, map);
    }

    return sum;
  }
}
