package tree.binarytree.problems;

import java.util.HashMap;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class BinaryTreeFromInOrderAndPostOrder {

    private static final TreeFormatter formatter = new TreeFormatter();
    private static final HashMap<Integer, Integer> inOrderLookup = new HashMap<>();
    private static int pIndex = 0;

    public static void main(String[] args) {
        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};

//    Node root = buildTree(inorder, postorder);
//    Node root = buildTree1(inorder, postorder);
        Node root = buildTree2(inorder, postorder);

        formatter.topDown(root);
    }

    // Approach 1
    private static Node buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static Node buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (is > ie) {
            return null;
        }

        Node node = new Node(postorder[pe]);
        if (is == ie) {
            return node;
        }

        int iIndex = getInIndex(inorder, is, ie, node.key);
        int nodesOnLeft = iIndex - is;

        node.left = buildTree(inorder, postorder, is, iIndex - 1, ps, ps + nodesOnLeft - 1);
        node.right = buildTree(inorder, postorder, iIndex + 1, ie, ps + nodesOnLeft, pe - 1);

        return node;
    }

    //  Approach 2
    private static Node buildTree1(int[] inorder, int[] postorder) {
        pIndex = postorder.length - 1;
        return buildTree1(inorder, postorder, 0, inorder.length - 1);
    }

    private static Node buildTree1(int[] inorder, int[] postorder, int is, int ie) {
        if (is > ie) {
            return null;
        }

        Node node = new Node(postorder[pIndex--]);
        if (is == ie) {
            return node;
        }

        int iIndex = getInIndex(inorder, is, ie, node.key);

        node.right = buildTree1(inorder, postorder, iIndex + 1, ie);
        node.left = buildTree1(inorder, postorder, is, iIndex - 1);

        return node;
    }

    // Approach 3: Using hashing
    private static Node buildTree2(int[] inorder, int[] postorder) {
        pIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderLookup.put(inorder[i], i);
        }

        return buildTree2(inorder, postorder, 0, inorder.length - 1);
    }

    private static Node buildTree2(int[] inorder, int[] postorder, int is, int ie) {
        if (is > ie) {
            return null;
        }

        Node node = new Node(postorder[pIndex--]);
        if (is == ie) {
            return node;
        }

        int iIndex = inOrderLookup.get(node.key);

        node.right = buildTree2(inorder, postorder, iIndex + 1, ie);
        node.left = buildTree2(inorder, postorder, is, iIndex - 1);

        return node;
    }

    // Helper method
    private static int getInIndex(int[] inorder, int is, int ie, int key) {
        int iIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == key) {
                iIndex = i;
            }
        }

        return iIndex;
    }

}
