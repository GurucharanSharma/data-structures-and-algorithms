import java.util.ArrayDeque;
import java.util.Queue;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.right.left.right = new Node(11);

        TreeFormatter formatter = new TreeFormatter();
        formatter.topDown(root);

        Solution solution = new Solution();
        Node nRoot = solution.deleteNode(root, 6);

        formatter.topDown(nRoot);
    }
}

class Solution {

    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.key == key) {
                return null;
            } else {
                return root;
            }
        }

        Node delNode = null;
        Node cNode = null;
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            cNode = queue.poll();

            if (cNode.key == key) {
                delNode = cNode;
            }

            if (cNode.left != null) {
                queue.offer(cNode.left);
            }

            if (cNode.right != null) {
                queue.offer(cNode.right);
            }
        }

        if (delNode == null) {
            return null;
        }

        deleteLastNode(root, cNode);
        delNode.key = cNode.key;

        return root;
    }

    private void deleteLastNode(Node root, Node lastNode) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cNode = queue.poll();

            if (cNode.right != null) {
                if (cNode.right == lastNode) {
                    cNode.right = null;
                    break;
                }

                queue.offer(cNode.right);
            }

            if (cNode.left != null) {
                if (cNode.left == lastNode) {
                    cNode.left = null;
                    break;
                }

                queue.offer(cNode.left);
            }
        }
    }
}