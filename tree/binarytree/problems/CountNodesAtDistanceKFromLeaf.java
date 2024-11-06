package tree.binarytree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.BinaryTree.Node;
import tree.Pair;
import tree.TreeFormatter;

public class CountNodesAtDistanceKFromLeaf {

  private static final TreeFormatter formatter = new TreeFormatter();

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(8);
    root.right.left.right = new Node(9);
    root.left.left.left = new Node(10);
    root.left.left.right = new Node(11);
    root.left.left.right.right = new Node(12);

    int k = 2;

    formatter.topDown(root);
    System.out.println(countNodes(root, k));
    System.out.println();
    System.out.println(countNodes1(root, k));
  }

  // Recursive approach
  private static int countNodes(Node root, int K) {
    if (root == null) {
      return 0;
    }

    int[] path = new int[1000];
    boolean[] visited = new boolean[1000];

    List<Integer> nodes = new ArrayList<>();
    findNodes(root, path, visited, nodes, 0, K);

    System.out.println(nodes);

    return nodes.size();
  }

  private static void findNodes(Node root, int[] path, boolean[] visited, List<Integer> nodes, int pathLen, int K) {
    if (root == null) {
      return;
    }

    path[pathLen] = root.key;
    visited[pathLen] = false;
    pathLen++;

    // If it is a leaf node
    if (root.left == null && root.right == null) {
      int depth = pathLen - K - 1;
      if (depth >= 0 && !visited[depth]) {
        nodes.add(path[depth]);
        visited[depth] = true;
        return;
      }
    }

    findNodes(root.left, path, visited, nodes, pathLen, K);
    findNodes(root.right, path, visited, nodes, pathLen, K);
  }

  // Iterative approach
  private static int countNodes1(Node root, int k) {
    if (root == null) {
      return 0;
    }

    Stack<Pair> stack = new Stack<>();
    List<Integer> path = new ArrayList<>();
    List<Boolean> visited = new ArrayList<>();

    stack.push(new Pair(root, 0));
    int nodes = 0;

    while (!stack.isEmpty()) {
      Pair pair = stack.pop();
      if (pair == null || pair.node() == null) {
        continue;
      }

      Node curr = pair.node();
      path.add(curr.key);
      visited.add(false);

      if (curr.left == null && curr.right == null) {
        int depth = path.size() - k - 1;
        if (depth >= 0 && !visited.get(depth)) {
          nodes++;
          System.out.print(path.get(depth) + " ");
          visited.set(depth, true);
        }
      }

      // Here the dist is vertical distance of the node. Hence, it increases for both, the left and right subtree.
      stack.push(new Pair(curr.left, pair.dist() + 1));
      stack.push(new Pair(curr.right, pair.dist() + 1));

      if (pair.dist() + 1 < path.size()) {
        int nSize = pair.dist() + 1;
        path.subList(nSize, path.size()).clear();
        visited.subList(nSize, visited.size()).clear();
      }
    }

    return nodes;
  }
}
