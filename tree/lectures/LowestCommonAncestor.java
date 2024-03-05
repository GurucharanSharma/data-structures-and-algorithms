package tree.lectures;

import java.util.ArrayList;
import tree.BinaryTree.Node;

public class LowestCommonAncestor {

  /**
   * Time Complexity: O(N) where N is the number of nodes in the given Tree. It required 3 traversals.<br> Auxiliary Space: O(N)
   */
  public static void execute(Node root, int n1, int n2) {
    if (root == null) {
      return;
    }

    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
      return;
    }

    int i = 0;
    for (; i < path1.size() - 1 && i < path2.size() - 1; i++) {
      if (path1.get(i + 1) != path2.get(i + 1)) {
        System.out.println(path1.get(i).key);
        break;
      }
    }

    if (i == path1.size() - 1) {
      System.out.println(path2.get(i).key);
    }

    if (i == path2.size() - 1) {
      System.out.println(path1.get(i).key);
    }
  }

  private static boolean findPath(Node root, ArrayList<Node> arr, int n) {
    if (root == null) {
      return false;
    }

    arr.add(root);

    if (root.key == n) {
      return true;
    }

    if (findPath(root.left, arr, n) || findPath(root.right, arr, n)) {
      return true;
    }

    arr.remove(root);
    return false;
  }


  /**
   * Time Complexity: O(N) where N is the number of nodes in the given Tree. It required single traversals.<br>
   */
  public static Node execute1(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    if (root.key == n1 || root.key == n2) {
      return root;
    }

    Node left = execute1(root.left, n1, n2);
    Node right = execute1(root.right, n1, n2);

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else {
      return right;
    }
  }
}