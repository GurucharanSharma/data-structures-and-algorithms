package tree.binarytree.problems;

import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;
import tree.Pair;

public class VerticalWidthOfBinaryTree {

  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//    root.right.left = new Node(6);
//    root.right.right = new Node(7);
//    root.right.left.right = new Node(8);
//    root.right.right.right = new Node(9);

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    System.out.println(verticalWidth(root));
  }

  // Function to find the vertical width of a Binary Tree.
  public static int verticalWidth(Node root) {
    if (root == null) {
      return 0;
    }

    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(root, 0));
    int min = 0;
    int max = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Pair pair = queue.remove();
        Node curr = pair.node();

        if (curr.left != null) {
          min = Math.min(min, pair.dist() - 1);
          queue.add(new Pair(curr.left, pair.dist() - 1));
        }

        if (curr.right != null) {
          max = Math.max(max, pair.dist() + 1);
          queue.add(new Pair(curr.right, pair.dist() + 1));
        }
      }
    }

    return max - min + 1;
  }
}
