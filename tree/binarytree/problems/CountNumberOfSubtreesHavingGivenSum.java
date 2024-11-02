package tree.binarytree.problems;

import tree.BinaryTree.Node;

public class CountNumberOfSubtreesHavingGivenSum {

  private static int count = 0;

  public static void main(String[] args) {
//    int sum = 7;
//    Node root = new Node(5);
//    root.left = new Node(-10);
//    root.right = new Node(3);
//    root.left.left = new Node(9);
//    root.left.right = new Node(8);
//    root.right.left = new Node(-4);
//    root.right.right = new Node(7);

    int sum = 6;
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    countSubtreesWithSumX(root, sum);
    System.out.println(count);
  }

  //Function to count number of subtrees having sum equal to given sum.
  private static int countSubtreesWithSumX(Node root, int X) {
    if (root == null) {
      return 0;
    }

    int lSum = countSubtreesWithSumX(root.left, X);
    int rSum = countSubtreesWithSumX(root.right, X);

    int sum = root.key + lSum + rSum;
    if (sum == X) {
      count++;
    }

    return sum;
  }
}
