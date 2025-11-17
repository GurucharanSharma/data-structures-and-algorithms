package tree.binarytree.problems;

import java.util.Stack;
import tree.BinaryTree.Node;

public class MaximumDifferenceBetweenNodeAndAncestor {

    private static int maxDiff = Integer.MIN_VALUE;

    public static void main(String[] args) {
//    Node root = new Node(5);
//    root.left = new Node(2);
//    root.right = new Node(1);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(7);

        maxDiffRecursive(root);
        System.out.println(maxDiff);
    }

    // Approach 1: Using recursion
    private static int maxDiffRecursive(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.key;
        }

        int lMin = maxDiffRecursive(root.left);
        int rMin = maxDiffRecursive(root.right);

        maxDiff = Math.max(maxDiff, root.key - Math.min(lMin, rMin));

        return Math.min(root.key, Math.min(lMin, rMin));
    }

    // Approach 2: Iterative approach using stacks
    private static int maxDiffIterative(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.key;
        }

        int maxDiff = Integer.MIN_VALUE;
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            Node currNode = pair.node;
            int currVisit = pair.visit;

            if (currNode == null) {
                continue;
            }

            if (currVisit == 0) {
                stack.push(new Pair(currNode, 1));
                stack.push(new Pair(currNode.left, 0));
            } else if (currVisit == 1) {
                stack.push(new Pair(currNode, 2));
                stack.push(new Pair(currNode.right, 0));
            } else {
                int lData = currNode.left != null ? currNode.left.key : Integer.MAX_VALUE;
                int rData = currNode.right != null ? currNode.right.key : Integer.MAX_VALUE;

                maxDiff = Math.max(maxDiff, currNode.key - Math.min(lData, rData));
                currNode.key = Math.min(currNode.key, Math.min(lData, rData));
            }
        }

        return maxDiff;
    }
}

class Pair {

    Node node;
    int visit;

    public Pair(Node node, int visit) {
        this.node = node;
        this.visit = visit;
    }
}
