package tree.binarysearchtree;

import tree.BinaryTree;
import tree.BinaryTree.Node;
import tree.TreeFormatter;
import tree.binarysearchtree.lectures.DeleteInBST;
import tree.binarysearchtree.lectures.FloorInBST;
import tree.binarysearchtree.lectures.InsertInBST;
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
  }
}
