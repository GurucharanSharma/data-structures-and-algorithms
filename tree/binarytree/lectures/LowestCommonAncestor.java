package tree.binarytree.lectures;

import java.util.ArrayList;
import tree.BinaryTree;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class LowestCommonAncestor {

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

        TreeFormatter formatter = new TreeFormatter();
        formatter.topDown(tree.root);

        System.out.println("\n# Lowest Common Ancestor => ");
        System.out.println("Naive Approach: ");
        LowestCommonAncestor.execute(tree.root, 10, 12);
//    LowestCommonAncestor.execute(tree.root, 5, 9);
//    LowestCommonAncestor.execute(tree.root, 8, 9);

//    System.out.println("Efficient Approach: ");
//    Node lca = LowestCommonAncestor.execute1(tree.root, 10, 12);
//    System.out.println(lca == null ? -1 : lca.key);
//    lca = LowestCommonAncestor.execute1(tree.root, 5, 9);
//    System.out.println(lca == null ? -1 : lca.key);
//    lca = LowestCommonAncestor.execute1(tree.root, 8, 9);
//    System.out.println(lca == null ? -1 : lca.key);
    }

    /**
     * Time Complexity: O(N) where N is the number of nodes in the given Tree. It required 3 traversals.<br> Auxiliary Space: O(N)
     */
    public static void execute(Node root, int n1, int n2) {
        if (root == null) {
            return;
        }

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
            return;
        }

        System.out.println("Paths:");
        System.out.println(path1);
        System.out.println(path2);
        System.out.println();

        int i = 0;
        for (; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                System.out.println(path1.get(i).key);
                break;
            }
        }

        if (i == path1.size() - 1) {
            System.out.println(path2.get(i).key);
        }

        if (i == path2.size() - 1) {
            System.out.println(path1.get(i).key);
        }
    }

    public static void execute2(Node root, int n1, int n2) {
        if (root == null) {
            return;
        }

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
            return;
        }

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                if (i > 0) {
                    System.out.println(path1.get(i - 1).key);
                } else {
                    System.out.println(-1);
                }

                break;
            }
        }
    }

    private static boolean findPath(Node root, ArrayList<Node> arr, int n) {
        if (root == null) {
            return false;
        }

        arr.add(root);

        if (root.key == n) {
            return true;
        }

        if (findPath(root.left, arr, n) || findPath(root.right, arr, n)) {
            return true;
        }

        arr.remove(root);
        return false;
    }


    /**
     * Time Complexity: O(N) where N is the number of nodes in the given Tree. It required single traversals.<br> It assumes that the nodes are
     * present in the tree. In case they are not present, it gives incorrect results
     */
    public static Node execute1(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.key == n1 || root.key == n2) {
            return root;
        }

        Node left = execute1(root.left, n1, n2);
        Node right = execute1(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}