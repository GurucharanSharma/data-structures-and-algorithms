package tree.binarytree.lectures;

import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;

public class HeightOfBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(8);
    root.right.left.right = new Node(9);
    root.left.left.left = new Node(10);
    root.left.left.right = new Node(11);
    root.left.left.right.right = new Node(12);

//    Node root = new Node(10);
//    root.left = new Node(11);
//    root.left.left = new Node(7);
//    root.right = new Node(9);
//    root.right.left = new Node(15);
//    root.right.right = new Node(8);

    System.out.println(execute(root));
    System.out.println();
    System.out.println(execute1(root));
  }

  public static int execute(Node root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(execute(root.left), execute(root.right));
  }

  public static int execute1(Node root) {
    if (root == null) {
      return 0;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    int height = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      height++;

      for (int i = 0; i < size; i++) {
        Node curr = queue.remove();

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
    }

    return height;
  }
}
