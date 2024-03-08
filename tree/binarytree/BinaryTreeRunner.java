package tree.binarytree;

import java.util.ArrayList;
import tree.BinaryTree;
import tree.TreeFormatter;
import tree.BinaryTree.Node;
import tree.binarytree.lectures.BinaryTreeDiameter;
import tree.binarytree.lectures.BottomViewOfBinaryTree;
import tree.binarytree.lectures.CheckBalancedBinaryTree;
import tree.binarytree.lectures.ChildrenSumProperty;
import tree.binarytree.lectures.ConstructBinaryTreeFromInorderAndPreorder;
import tree.binarytree.lectures.ConvertBinaryTreeToDLL;
import tree.binarytree.lectures.DeletionInBinaryTree;
import tree.binarytree.lectures.DeserializeBinaryTree;
import tree.binarytree.lectures.HeightOfBinaryTree;
import tree.binarytree.lectures.InOrderTraversal;
import tree.binarytree.lectures.InsertionInBinaryTree;
import tree.binarytree.lectures.IterativeInOrderTraversal;
import tree.binarytree.lectures.IterativePreOrderTraversal;
import tree.binarytree.lectures.LeftViewOfBinaryTree;
import tree.binarytree.lectures.LevelOrderTraversal;
import tree.binarytree.lectures.LowestCommonAncestor;
import tree.binarytree.lectures.MaximumInBinaryTree;
import tree.binarytree.lectures.MaximumTreeWidth;
import tree.binarytree.lectures.MirrorBinaryTree;
import tree.binarytree.lectures.PostOrderTraversal;
import tree.binarytree.lectures.PreOrderTraversal;
import tree.binarytree.lectures.PrintNodesAtDistanceK;
import tree.binarytree.lectures.RightViewOfBinaryTree;
import tree.binarytree.lectures.SerializeBinaryTree;
import tree.binarytree.lectures.SizeOfBinaryTree;
import tree.binarytree.lectures.SpiralTreeTraversal;
import tree.binarytree.lectures.TopViewOfBinaryTree;

public class BinaryTreeRunner {

  private static final TreeFormatter formatter = new TreeFormatter();

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
    formatter.topDown(root);
    System.out.println();

    // Tree Traversal in Spiral Form
    System.out.println("\n# SpiralTreeTraversal => ");
    formatter.topDown(tree.root);
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

    // Finding LCA in Binary Tree
    System.out.println("\n# Lowest Common Ancestor => ");
    System.out.println("Naive Approach: ");
    LowestCommonAncestor.execute(tree.root, 10, 12);
    LowestCommonAncestor.execute(tree.root, 5, 9);
    LowestCommonAncestor.execute(tree.root, 8, 9);
    System.out.println("Efficient Approach: ");
    Node lca = LowestCommonAncestor.execute1(tree.root, 10, 12);
    System.out.println(lca == null ? -1 : lca.key);
    lca = LowestCommonAncestor.execute1(tree.root, 5, 9);
    System.out.println(lca == null ? -1 : lca.key);
    lca = LowestCommonAncestor.execute1(tree.root, 8, 9);
    System.out.println(lca == null ? -1 : lca.key);

    // Serialize and Deserialize a Binary Tree
    System.out.println("\n# SerializeBinaryTree => ");
    ArrayList<Integer> arrayList = new ArrayList<>();
    SerializeBinaryTree.execute(tree.root, arrayList);
    System.out.println(arrayList);
    System.out.println("\n# DeserializeBinaryTree => ");
    Node dRoot = DeserializeBinaryTree.execute(arrayList);
    formatter.topDown(dRoot);

    // Iterative Inorder Traversal
    System.out.println("\n# IterativeInOrderTraversal => ");
    IterativeInOrderTraversal.execute(tree.root);
    System.out.println();
    InOrderTraversal.execute(tree.root);
    System.out.println();

    // Iterative Preorder Traversal
    System.out.println("\n# IterativePreOrderTraversal => ");
    IterativePreOrderTraversal.execute(tree.root);
    System.out.println();
    IterativePreOrderTraversal.execute1(tree.root);
    System.out.println();
    PreOrderTraversal.execute(tree.root);
    System.out.println();

    // Insertion in a Binary Tree
    System.out.println("\n# InsertionInBinaryTree => ");
    formatter.topDown(tree.root);
    InsertionInBinaryTree.execute(tree.root, 15);
    formatter.topDown(tree.root);

    // Deletion in a Binary Tree
    BinaryTree delTree = new BinaryTree();
    delTree.root = new Node(10);
    delTree.root.left = new Node(11);
    delTree.root.left.left = new Node(7);
    delTree.root.left.right = new Node(12);
    delTree.root.right = new Node(9);
    delTree.root.right.left = new Node(15);
    delTree.root.right.right = new Node(8);

    System.out.println("\n# DeletionInBinaryTree => ");
    formatter.topDown(delTree.root);
    DeletionInBinaryTree.execute(delTree.root, 11);
    formatter.topDown(delTree.root);

    // Convert a Binary Tree into its Mirror Tree
    System.out.println("\n# MirrorBinaryTree => ");
    formatter.topDown(tree.root);
    MirrorBinaryTree.execute(tree.root);
    formatter.topDown(tree.root);
  }
}
