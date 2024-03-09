package tree.binarysearchtree;

public class KSmallestTree {

  public static Node insert(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }

    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      root.right = insert(root.right, key);
    } else {
      root.left = insert(root.left, key);
      root.lcount++;
    }

    return root;
  }

  public static class Node {

    public int key;
    public Node left, right;
    public int lcount;

    public Node(int key) {
      this.key = key;
    }
  }
}
