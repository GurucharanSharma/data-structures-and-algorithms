package tree;

public class BinaryTree {

  public Node root;

  public static class Node {

    public final int key;
    public Node left;
    public Node right;

    public Node(int key) {
      this.key = key;
      this.left = null;
      this.right = null;
    }
  }
}
