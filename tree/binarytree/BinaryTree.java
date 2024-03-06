package tree.binarytree;

public class BinaryTree {

  public Node root;

  public static void printTree(Node node, String prefix, boolean isLeft) {
    if (node != null) {
      System.out.println(prefix + (isLeft ? "/-- " : "\\-- ") + node.key);
      printTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
      printTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
    }
  }

  public static void traversePreOrder(Node root) {
    if (root == null) {
      return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(root.key);

    String pointerRight = "└──";
    String pointerLeft = (root.right != null) ? "├──" : "└──";

    traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
    traverseNodes(sb, "", pointerRight, root.right, false);

    System.out.println(sb);
  }

  private static void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
    if (node != null) {
      sb.append("\n");
      sb.append(padding);
      sb.append(pointer);
      sb.append(node.key);

      StringBuilder paddingBuilder = new StringBuilder(padding);
      if (hasRightSibling) {
        paddingBuilder.append("│  ");
      } else {
        paddingBuilder.append("   ");
      }

      String paddingForBoth = paddingBuilder.toString();
      String pointerRight = "└──";
      String pointerLeft = (node.right != null) ? "├──" : "└──";

      traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
      traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
    }
  }

  public static class Node {

    public int key;
    public Node left;
    public Node right;

    public Node(int key) {
      this.key = key;
      this.left = null;
      this.right = null;
    }
  }
}
