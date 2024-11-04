package tree.binarytree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree.Node;

public class CheckIfSubtree {

  public static void main(String[] args) {
    Node T = new Node(1);
    T.left = new Node(2);
    T.right = new Node(3);
    T.right.left = new Node(4);

    Node S = new Node(3);
    S.left = new Node(4);

    System.out.println(isSubtree(T, S));
    System.out.println();
    System.out.println(isSubtree1(T, S));
    System.out.println();
    System.out.println(isSubtree2(T, S));
  }

  // Approach 1: Using recursion
  private static boolean isSubtree(Node T, Node S) {
    if (S == null) {
      return true;
    }

    if (T == null) {
      return false;
    }

    if (areIdentical(T, S)) {
      return true;
    }

    return isSubtree(T.left, S) || isSubtree(T.right, S);
  }

  private static boolean areIdentical(Node T, Node S) {
    if (T == null && S == null) {
      return true;
    }

    if (T == null || S == null) {
      return false;
    }

    return (T.key == S.key) && areIdentical(T.left, S.left) && areIdentical(T.right, S.right);
  }

  // Approach 2: Using height of the second tree
  private static boolean isSubtree1(Node T, Node S) {
    if (S == null) {
      return true;
    }

    if (T == null) {
      return false;
    }

    int height = getHeight(S);
    List<Node> nodes = new ArrayList<>();
    findSubTree(T, nodes, height);

    for (int i = 0; i < nodes.size(); i++) {
      if (nodes.get(i).key == S.key) {
        if (areIdentical1(nodes.get(i), S)) {
          return true;
        }
      }
    }

    return false;
  }

  private static int getHeight(Node root) {
    if (root == null) {
      return 0;
    }

    int lH = getHeight(root.left);
    int rH = getHeight(root.right);

    return 1 + Math.max(lH, rH);
  }

  private static int findSubTree(Node root, List<Node> nodes, int h) {
    if (root == null) {
      return 0;
    }

    int lH = findSubTree(root.left, nodes, h);
    int rH = findSubTree(root.right, nodes, h);
    int height = 1 + Math.max(lH, rH);

    if (height == h) {
      nodes.add(root);
    }

    return height;
  }

  private static boolean areIdentical1(Node T, Node S) {
    if (T == null && S == null) {
      return true;
    }

    if (T == null || S == null) {
      return false;
    }

    return (T.key == S.key) && areIdentical1(T.left, S.left) && areIdentical1(T.right, S.right);
  }

  // Approach 3: Using Stacks
  private static boolean isSubtree2(Node T, Node S) {
    if (S == null) {
      return true;
    }

    if (T == null) {
      return false;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(T);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();

      if (curr.key == S.key) {
        if (areIdentical2(curr, S)) {
          return true;
        }
      }

      if (curr.left != null) {
        stack.push(curr.left);
      }

      if (curr.right != null) {
        stack.push(curr.right);
      }
    }

    return false;
  }

  private static boolean areIdentical2(Node T, Node S) {
    Stack<Node> mStack = new Stack<>();
    Stack<Node> aStack = new Stack<>();

    mStack.push(T);
    aStack.push(S);

    while (!mStack.isEmpty() && !aStack.isEmpty()) {
      Node curr1 = mStack.pop();
      Node curr2 = aStack.pop();

      if (curr1 == null && curr2 == null) {
        continue;
      }

      if (curr1 == null || curr2 == null) {
        return false;
      }

      if (curr1.key != curr2.key) {
        return false;
      }

      mStack.push(curr1.left);
      mStack.push(curr1.right);

      aStack.push(curr2.left);
      aStack.push(curr2.right);
    }

    return mStack.isEmpty() && aStack.isEmpty();
  }
}
