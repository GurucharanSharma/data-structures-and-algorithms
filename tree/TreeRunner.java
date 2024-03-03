package tree;

import tree.BinaryTree.Node;
import tree.lectures.HeightOfBinaryTree;
import tree.lectures.InOrderTraversal;
import tree.lectures.PostOrderTraversal;
import tree.lectures.PreOrderTraversal;
import tree.lectures.PrintNodesAtDistanceK;

public class TreeRunner {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    // In-order traversal
    System.out.println("\nInOrderTraversal => ");
    InOrderTraversal.execute(tree.root);
    System.out.println();

    // Pre-order traversal
    System.out.println("\nPreOrderTraversal => ");
    PreOrderTraversal.execute(tree.root);
    System.out.println();

    // Post-order traversal
    System.out.println("\nPostOrderTraversal => ");
    PostOrderTraversal.execute(tree.root);
    System.out.println();

    // Height of Binary Tree
    System.out.println("\nHeightOfBinaryTree => ");
    System.out.println(HeightOfBinaryTree.execute(tree.root));

    // Print Nodes at K Distance
    System.out.println("\nPrintNodesAtDistanceK => ");
    tree.root.right.left = new Node(8);
    PrintNodesAtDistanceK.execute(tree.root, 2);
  }
}
