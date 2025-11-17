package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.BinaryTree.Node;

/**
 * <pre><code>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * </code></pre>
 */
public class DiameterOfBinaryTree {

    int result = Integer.MIN_VALUE;

    /// Recursive
    public int computeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftD = computeHeight(root.left);
        int rightD = computeHeight(root.right);
        int rootD = 1 + Math.max(leftD, rightD);
        result = Math.max(result, 1 + leftD + rightD);

        return rootD;
    }

    /// Recursive + Memoization
    public int computeHeight(Node root, Map<Node, Integer> memory) {
        if (root == null) {
            return 0;
        }

        int lH = computeHeight(root.left, memory);
        int rH = computeHeight(root.right, memory);
        int nH = 1 + Math.max(lH, rH);
        result = Math.max(result, 1 + lH + rH);

        return nH;
    }

    @Nested
    class DiameterOfBinaryTreeTest {

        DiameterOfBinaryTree solver = new DiameterOfBinaryTree();

        @Test
        public void testSingleNode() {
            BinaryTree.Node root = new BinaryTree.Node(1);

            solver.computeHeight(root);
            assertEquals(1, solver.result);

            solver.computeHeight(root, new HashMap<>());
            assertEquals(1, solver.result);
        }

        @Test
        public void testLinearTree() {
            BinaryTree.Node root = new BinaryTree.Node(1);
            root.right = new BinaryTree.Node(2);
            root.right.right = new BinaryTree.Node(3);

            solver.computeHeight(root);
            assertEquals(3, solver.result);

            solver.computeHeight(root, new HashMap<>());
            assertEquals(3, solver.result);
        }

        @Test
        public void testBalancedTree() {
            BinaryTree.Node root = new BinaryTree.Node(1);
            root.left = new BinaryTree.Node(2);
            root.right = new BinaryTree.Node(3);
            root.left.left = new BinaryTree.Node(4);
            root.left.right = new BinaryTree.Node(5);

            solver.computeHeight(root);
            assertEquals(4, solver.result); // Path: 4 -> 2 -> 1 -> 3

            solver.computeHeight(root, new HashMap<>());
            assertEquals(4, solver.result);
        }

        @Test
        public void testEmptyTree() {
            BinaryTree.Node root = null;

            solver.computeHeight(root);
            assertEquals(0, solver.result == Integer.MIN_VALUE ? 0 : solver.result);

            solver.computeHeight(root, new HashMap<>());
            assertEquals(0, solver.result == Integer.MIN_VALUE ? 0 : solver.result);
        }
    }
}