package tree.binarytree.problems;

import java.util.HashMap;
import tree.BinaryTree.Node;

public class MaximumSumOfNonAdjacentNodes {

  public static void main(String[] args) {
    Node root = new Node(11);
    root.left = new Node(1);
    root.right = new Node(2);

//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.left.left = new Node(4);
//    root.right = new Node(3);
//    root.right.left = new Node(5);
//    root.right.right = new Node(6);

    System.out.println(getMaxSum(root));
    System.out.println();
    System.out.println(getMaxSum1(root));
  }

  // Approach 1: Using recursion
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

  // Approach 2: Using Pair
  private static int getMaxSum1(Node root) {
    Pair pair = getNodeSum1(root);
    return Math.max(pair.inclSum, pair.exclSum);
  }

  private static Pair getNodeSum1(Node root) {
    if (root == null) {
      return new Pair(0, 0);
    }

    Pair lPair = getNodeSum1(root.left);
    Pair rPair = getNodeSum1(root.right);
    Pair pair = new Pair(0, 0);

    pair.inclSum = lPair.exclSum + rPair.exclSum + root.key;
    pair.exclSum = Math.max(lPair.inclSum, lPair.exclSum) + Math.max(rPair.inclSum, rPair.exclSum);

    return pair;
  }

  static class Pair {

    int inclSum;
    int exclSum;

    Pair(int inclSum, int exclSum) {
      this.inclSum = inclSum;
      this.exclSum = exclSum;
    }
  }
}
