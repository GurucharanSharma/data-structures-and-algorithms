package tree.binarysearchtree;

import tree.BinaryTree;
import tree.BinaryTree.Node;
import tree.TreeFormatter;
import tree.binarysearchtree.lectures.CeilInBST;
import tree.binarysearchtree.lectures.CeilingOnLeftSideInArray;
import tree.binarysearchtree.lectures.CheckForBST;
import tree.binarysearchtree.lectures.DeleteInBST;
import tree.binarysearchtree.lectures.FixBSTWithTwoSwappedNodes;
import tree.binarysearchtree.lectures.FloorInBST;
import tree.binarysearchtree.lectures.InsertInBST;
import tree.binarysearchtree.lectures.KthSmallest;
import tree.binarysearchtree.lectures.SearchInBST;

public class BinarySearchTreeRunner {

  private static final TreeFormatter formatter = new TreeFormatter();

  public static void main(String[] args) {
    /*
    Constructed binary tree:
           15
          ┌─┴──┐
          5   20
        ┌─┘  ┌─┴─┐
        3   18  80
           ┌─┘
          16
     */

    BinaryTree tree = new BinaryTree();
    tree.root = new Node(15);
    tree.root.left = new Node(5);
    tree.root.left.left = new Node(3);
    tree.root.right = new Node(20);
    tree.root.right.left = new Node(18);
    tree.root.right.left.left = new Node(16);
    tree.root.right.right = new Node(80);

    formatter.topDown(tree.root);

    // Search In BST
    System.out.println("\n# SearchInBST => ");

    Node res = SearchInBST.execute(tree.root, 3);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute1(tree.root, 3);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute(tree.root, 16);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute1(tree.root, 16);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute(tree.root, 80);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute1(tree.root, 80);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute(tree.root, 20);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute1(tree.root, 20);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute(tree.root, 200);
    System.out.println(res == null ? "Not found" : "Found");
    res = SearchInBST.execute1(tree.root, 200);
    System.out.println(res == null ? "Not found" : "Found");

    // Insert In BST
    System.out.println("\n# InsertInBST => ");

    InsertInBST.execute1(tree.root, 85);
    InsertInBST.execute1(tree.root, 17);
    InsertInBST.execute1(tree.root, 10);
    InsertInBST.execute1(tree.root, 1);
    formatter.topDown(tree.root);

    // Delete In BST
    System.out.println("\n# DeleteInBST => ");

    DeleteInBST.execute(tree.root, 15);
    formatter.topDown(tree.root);

    // Floor in BST
    System.out.println("\n# FloorInBST => ");

    System.out.println("Approach 1: ");
    FloorInBST.execute(tree.root, 80);
    System.out.println(FloorInBST.floor == null ? "No floor found for key 80" : FloorInBST.floor.key);
    FloorInBST.execute(tree.root, 19);
    System.out.println(FloorInBST.floor == null ? "No floor found for key 19" : FloorInBST.floor.key);

    System.out.println("Approach 2: ");
    FloorInBST.execute1(tree.root, 80);
    System.out.println(FloorInBST.floor == null ? "No floor found for key 80" : FloorInBST.floor.key);
    FloorInBST.execute1(tree.root, 19);
    System.out.println(FloorInBST.floor == null ? "No floor found for key 19" : FloorInBST.floor.key);

    System.out.println("Approach 3: ");
    res = FloorInBST.execute2(tree.root, 80);
    System.out.println(res == null ? "No floor found for key 80" : res.key);
    res = FloorInBST.execute2(tree.root, 19);
    System.out.println(res == null ? "No floor found for key 19" : res.key);

    // Ceiling in BST
    System.out.println("\n# CeilInBST => ");

    System.out.println("Approach 1: ");
    Node ceil = CeilInBST.execute(tree.root, 80);
    System.out.println(ceil == null ? "No ceiling found for key 80" : ceil.key);
    ceil = CeilInBST.execute(tree.root, 81);
    System.out.println(ceil == null ? "No ceiling found for key 81" : ceil.key);
    ceil = CeilInBST.execute(tree.root, 19);
    System.out.println(ceil == null ? "No ceiling found for key 19" : ceil.key);

    System.out.println("Approach 2: ");
    CeilInBST.execute1(tree.root, 19);
    System.out.println(CeilInBST.ceil == null ? "No ceiling found !" : CeilInBST.ceil.key);

    System.out.println("Approach 3: ");
    CeilInBST.execute2(tree.root, 80);
    System.out.println(CeilInBST.ceil == null ? "No ceil found !" : CeilInBST.ceil.key);
    CeilInBST.execute2(tree.root, 81);
    System.out.println(CeilInBST.ceil == null ? "No ceil found !" : CeilInBST.ceil.key);
    CeilInBST.execute2(tree.root, 19);
    System.out.println(CeilInBST.ceil == null ? "No ceil found !" : CeilInBST.ceil.key);

    // Ceiling on left side in an array
    System.out.println("\n# CeilingOnLeftSideInArray => ");
    int[] arr = {2, 8, 30, 15, 25, 12};

    System.out.println("Approach 1: ");
    CeilingOnLeftSideInArray.execute(arr);

    System.out.println("Approach 2: ");
    CeilingOnLeftSideInArray.execute1(arr);

    // Find Kth Smallest in BST
    System.out.println("\n# KthSmallest => ");
    // formatter.topDown(tree.root);

    System.out.println("Approach 1: ");
    KthSmallest.execute(tree.root, 9);

    System.out.println("Approach 2: ");
    KSmallestTree.Node kRoot = new KSmallestTree.Node(25);
    KSmallestTree.insert(kRoot, 20);
    KSmallestTree.insert(kRoot, 15);
    KSmallestTree.insert(kRoot, 10);
    KSmallestTree.insert(kRoot, 18);
    KSmallestTree.insert(kRoot, 30);
    KSmallestTree.insert(kRoot, 35);
    KSmallestTree.insert(kRoot, 12);

    KSmallestTree.Node kSNode = KthSmallest.execute(kRoot, 3);
    System.out.println(kSNode == null ? "Kth smallest not found !" : kSNode.key);
    kSNode = KthSmallest.execute(kRoot, 5);
    System.out.println(kSNode == null ? "Kth smallest not found !" : kSNode.key);

    // Check for BST
    System.out.println("\n# CheckForBST => ");
    formatter.topDown(tree.root);

    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(6);

    System.out.println("Approach 1: ");
    System.out.println(CheckForBST.execute(tree.root));
    System.out.println(CheckForBST.execute(root));

    System.out.println("Approach 2: ");
    System.out.println(CheckForBST.execute1(tree.root));
    System.out.println(CheckForBST.execute1(root));

    System.out.println("Approach 3: ");
    System.out.println(CheckForBST.execute2(tree.root));
    System.out.println(CheckForBST.execute2(root));

    // Fix BST with Two Nodes Swapped
    System.out.println("\n# FixBSTWithTwoSwappedNodes => ");

    Node sTRoot = new Node(18);
    sTRoot.left = new Node(60);
    sTRoot.right = new Node(70);
    sTRoot.left.left = new Node(4);
    sTRoot.right.left = new Node(8);
    sTRoot.right.right = new Node(80);

    formatter.topDown(sTRoot);
    FixBSTWithTwoSwappedNodes.execute(sTRoot);
    formatter.topDown(sTRoot);
  }
}
