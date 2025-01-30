package tree.binarysearchtree.lectures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class PairSumInBST {

  private static final TreeFormatter FORMATTER = new TreeFormatter();
  private static final HashSet<Integer> hashSet = new HashSet<>();

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(15);
    tree.root.left = new Node(5);
    tree.root.left.left = new Node(3);
    tree.root.right = new Node(20);
    tree.root.right.left = new Node(18);
    tree.root.right.left.left = new Node(16);
    tree.root.right.right = new Node(80);

    FORMATTER.topDown(tree.root);

    System.out.println(execute(tree.root, 20));
    System.out.println(execute(tree.root, 38));
    System.out.println(execute(tree.root, 30));
    System.out.println(execute(tree.root, 165));
    System.out.println(execute(tree.root, 170));
  }

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

  // Approach 2
  private static boolean pairSum(Node root, int sum) {
    if (root == null) {
      return false;
    }

    if (hashSet.contains(sum - root.key)) {
      return true;
    }

    hashSet.add(root.key);

    return pairSum(root.left, sum) || pairSum(root.right, sum);
  }
}
