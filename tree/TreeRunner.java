package tree;

import tree.BinaryTree.Node;
import tree.lectures.InOrderTraversal;
import tree.lectures.PostOrderTraversal;
import tree.lectures.PreOrderTraversal;

public class TreeRunner {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    InOrderTraversal.execute(tree.root);
    System.out.println();

    PreOrderTraversal.execute(tree.root);
    System.out.println();

    PostOrderTraversal.execute(tree.root);
    System.out.println();
  }
}
