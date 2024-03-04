package tree;

import tree.BinaryTree.Node;
import tree.lectures.BottomViewOfBinaryTree;
import tree.lectures.ChildrenSumProperty;
import tree.lectures.HeightOfBinaryTree;
import tree.lectures.InOrderTraversal;
import tree.lectures.LeftViewOfBinaryTree;
import tree.lectures.LevelOrderTraversal;
import tree.lectures.MaximumInBinaryTree;
import tree.lectures.PostOrderTraversal;
import tree.lectures.PreOrderTraversal;
import tree.lectures.PrintNodesAtDistanceK;
import tree.lectures.RightViewOfBinaryTree;
import tree.lectures.SizeOfBinaryTree;
import tree.lectures.TopViewOfBinaryTree;

public class TreeRunner {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(8);
    tree.root.right.left.right = new Node(9);
    tree.root.left.left.left = new Node(10);
    tree.root.left.left.right = new Node(11);
    tree.root.left.left.right.right = new Node(12);

    // In-order traversal
    System.out.println("\n# InOrderTraversal => ");
    InOrderTraversal.execute(tree.root);
    System.out.println();

    // Pre-order traversal
    System.out.println("\n# PreOrderTraversal => ");
    PreOrderTraversal.execute(tree.root);
    System.out.println();

    // Post-order traversal
    System.out.println("\n# PostOrderTraversal => ");
    PostOrderTraversal.execute(tree.root);
    System.out.println();

    // Height of Binary Tree
    System.out.println("\n# HeightOfBinaryTree => ");
    System.out.println(HeightOfBinaryTree.execute(tree.root));

    // Print Nodes at K Distance
    System.out.println("\n# PrintNodesAtDistanceK => ");
    PrintNodesAtDistanceK.execute(tree.root, 2);
    System.out.println();

    // Level Order Traversal of a Binary Tree
    System.out.println("\n# LevelOrderTraversal => ");
    System.out.println("First Approach: ");
    LevelOrderTraversal.execute(tree.root);
    System.out.println("Second Approach: ");
    LevelOrderTraversal.execute1(tree.root);
    System.out.println("Third Approach: ");
    LevelOrderTraversal.execute2(tree.root);

    // Size of Binary Tree
    System.out.println("\n# SizeOfBinaryTree => ");
    System.out.println("Recursive Approach: ");
    System.out.println(SizeOfBinaryTree.execute(tree.root));
    System.out.println("Iterative Approach: ");
    System.out.println(SizeOfBinaryTree.execute1(tree.root));

    // Maximum in Binary Tree
    System.out.println("\n# MaximumInBinaryTree => ");
    System.out.println("Recursive Approach: ");
    System.out.println(MaximumInBinaryTree.execute(tree.root));
    System.out.println("Iterative Approach: ");
    System.out.println(MaximumInBinaryTree.execute1(tree.root));

    // Left view of a Binary Tree
    System.out.println("\n# LeftViewOfBinaryTree => ");
    System.out.println("Recursive Approach: ");
    LeftViewOfBinaryTree.execute(tree.root, 1);
    System.out.println("Iterative Approach: ");
    LeftViewOfBinaryTree.execute(tree.root);

    // Right view of a Binary Tree
    System.out.println("\n# RightViewOfBinaryTree => ");
    System.out.println("Recursive Approach: ");
    RightViewOfBinaryTree.execute(tree.root, 1);
    System.out.println("Iterative Approach: ");
    RightViewOfBinaryTree.execute(tree.root);

    // Top view of a Binary Tree
    System.out.println("\n# TopViewOfBinaryTree => ");
    System.out.println("Iterative Approach (1): ");
    TopViewOfBinaryTree.execute(tree.root);
    System.out.println("Iterative Approach (2): ");
    TopViewOfBinaryTree.execute1(tree.root);

    // Bottom view of a Binary Tree
    System.out.println("\n# BottomViewOfBinaryTree => ");
    System.out.println("Iterative Approach (1): ");
    BottomViewOfBinaryTree.execute(tree.root);
    System.out.println("Iterative Approach (2): ");
    BottomViewOfBinaryTree.execute1(tree.root);

    // Children sum property
    BinaryTree csPropTree = new BinaryTree();
    csPropTree.root = new Node(20);
    csPropTree.root.left = new Node(8);
    csPropTree.root.right = new Node(12);
    csPropTree.root.right.left = new Node(3);
    csPropTree.root.right.right = new Node(9);

    System.out.println("\n# Children sum property => ");
    System.out.println(ChildrenSumProperty.execute(tree.root));
    System.out.println(ChildrenSumProperty.execute(csPropTree.root));
  }
}