package tree;

import tree.BinaryTree.Node;
import tree.lectures.BinaryTreeDiameter;
import tree.lectures.BottomViewOfBinaryTree;
import tree.lectures.CheckBalancedBinaryTree;
import tree.lectures.ChildrenSumProperty;
import tree.lectures.ConstructBinaryTreeFromInorderAndPreorder;
import tree.lectures.ConvertBinaryTreeToDLL;
import tree.lectures.HeightOfBinaryTree;
import tree.lectures.InOrderTraversal;
import tree.lectures.LeftViewOfBinaryTree;
import tree.lectures.LevelOrderTraversal;
import tree.lectures.MaximumInBinaryTree;
import tree.lectures.MaximumTreeWidth;
import tree.lectures.PostOrderTraversal;
import tree.lectures.PreOrderTraversal;
import tree.lectures.PrintNodesAtDistanceK;
import tree.lectures.RightViewOfBinaryTree;
import tree.lectures.SizeOfBinaryTree;
import tree.lectures.SpiralTreeTraversal;
import tree.lectures.TopViewOfBinaryTree;

public class TreeRunner {

  public static void main(String[] args) {
    /*
    Constructed binary tree:
              1
            /   \
           2     3
          / \   /
         4   5 8
        / \
      10   11
             \
              12
     */

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

    // Check for Balanced Binary Tree
    /*
		Constructed binary tree is:
			   10
			  /  \
		   5    30
		  / \
		 15  20
		*/

    BinaryTree balTree = new BinaryTree();
    balTree.root = new Node(10);
    balTree.root.left = new Node(5);
    balTree.root.right = new Node(30);
    balTree.root.left.left = new Node(15);
    balTree.root.left.right = new Node(20);

    System.out.println("\n# CheckBalancedBinaryTree => ");
    System.out.println("Naive Approach: ");
    System.out.println(CheckBalancedBinaryTree.execute(tree.root));
    System.out.println(CheckBalancedBinaryTree.execute(balTree.root));
    System.out.println("Efficient Approach: ");
    System.out.println(CheckBalancedBinaryTree.execute1(tree.root) != -1);
    System.out.println(CheckBalancedBinaryTree.execute1(balTree.root) != -1);

    // Maximum width of Binary Tree
		/*
		Constructed binary tree is:
			   1
			  / \
		   2   3
		  / \   \
		 4   5   8
				/ \
			 6   7
		*/

    BinaryTree wideTree = new BinaryTree();
    wideTree.root = new Node(1);
    wideTree.root.left = new Node(2);
    wideTree.root.right = new Node(3);
    wideTree.root.left.left = new Node(4);
    wideTree.root.left.right = new Node(5);
    wideTree.root.right.right = new Node(8);
    wideTree.root.right.right.left = new Node(6);
    wideTree.root.right.right.right = new Node(7);

    System.out.println("\n# MaximumTreeWidth => ");
    System.out.println(MaximumTreeWidth.execute(wideTree.root));
    System.out.println(MaximumTreeWidth.execute(tree.root));

    // Convert a given Binary Tree to Doubly Linked List
    BinaryTree dllTree = new BinaryTree();
    dllTree.root = new Node(1);
    dllTree.root.left = new Node(2);
    dllTree.root.right = new Node(3);
    dllTree.root.left.left = new Node(4);
    dllTree.root.left.right = new Node(5);
    dllTree.root.right.right = new Node(8);
    dllTree.root.right.right.left = new Node(6);
    dllTree.root.right.right.right = new Node(7);
    System.out.println("\n# ConvertBinaryTreeToDLL => ");
    ConvertBinaryTreeToDLL.print(ConvertBinaryTreeToDLL.execute(dllTree.root));

    // Construct Binary Tree from Inorder and Preorder
    System.out.println("\n# ConstructBinaryTreeFromInorderAndPreorder => ");
    int[] in = {20, 10, 40, 30, 50};
    int[] pre = {10, 20, 30, 40, 50};
    Node root = ConstructBinaryTreeFromInorderAndPreorder.execute(in, pre, 0, in.length - 1);
    BinaryTree.traversePreOrder(root);
    System.out.println();
    BinaryTree.printTree(root, "", false);
    System.out.println();

    // Tree Traversal in Spiral Form
    System.out.println("\n# SpiralTreeTraversal => ");
    BinaryTree.traversePreOrder(tree.root);
    System.out.println("Naive Approach: ");
    SpiralTreeTraversal.execute(tree.root);
    System.out.println("Efficient Approach: ");
    SpiralTreeTraversal.execute1(tree.root);

    // Diameter of a Binary Tree
    System.out.println("\n# Binary Tree Diameter => ");
    System.out.println("Naive Approach: ");
    System.out.println(BinaryTreeDiameter.execute(tree.root));
    System.out.println("Efficient Approach: ");
    BinaryTreeDiameter.execute1(tree.root);
    System.out.println(BinaryTreeDiameter.res);
  }
}
