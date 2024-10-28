package tree.binarytree.lectures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;

public class BottomViewOfBinaryTree {

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

    execute(root);
    System.out.println();
    execute1(root);
    System.out.println();
    execute2(root);
  }

  /**
   * Time complexity: O(N * log(N)), where N is the number of nodes in the given tree.<br> Auxiliary Space: O(N), As we store nodes in the map and
   * queue.
   */
  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      map.put(pair.dist, pair.node.key);

      if (pair.node.left != null) {
        queue.offer(new Pair(pair.node.left, pair.dist - 1));
      }
      if (pair.node.right != null) {
        queue.offer(new Pair(pair.node.right, pair.dist + 1));
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
    System.out.println();
  }

  /**
   * Time Complexity: O(N), Since we only perform level-order traversal and print some part of the N nodes which at max will be 2N in case of skew
   * tree. <br> Auxiliary Space: O(N), Since we store the nodes in the map and queue.
   */
  public static void execute1(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    int min = 0;
    int max = 0;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      map.put(pair.dist, pair.node.key);

      if (pair.node.left != null) {
        min = Math.min(min, pair.dist - 1);
        queue.offer(new Pair(pair.node.left, pair.dist - 1));
      }
      if (pair.node.right != null) {
        max = Math.max(max, pair.dist + 1);
        queue.offer(new Pair(pair.node.right, pair.dist + 1));
      }
    }

    for (; min <= max; min++) {
      System.out.print(map.get(min) + " ");
    }
    System.out.println();
  }

  // Recursive approach
  // Time complexity: O(N * log(N)), where N is the number of nodes in the given binary tree with each insertion operation in Map requiring O(log2 N) complexity.
  // Auxiliary Space: O(N)
  private static void execute2(Node root) {
    Map<Integer, Pair> treeMap = new TreeMap<>();
    fillBottomView(root, treeMap, 0, 0);

    for (Entry<Integer, Pair> entry : treeMap.entrySet()) {
      System.out.print(entry.getValue().node.key + " ");
    }
  }

  private static void fillBottomView(Node root, Map<Integer, Pair> treeMap, int depth, int level) {
    if (root == null) {
      return;
    }

    // Here, the pair class is reused, but the dist attribute of pair class is being reused as level.
    if (!treeMap.containsKey(depth) || treeMap.get(depth).dist <= level) {
      treeMap.put(depth, new Pair(root, level));
    }

    fillBottomView(root.left, treeMap, depth - 1, level + 1);
    fillBottomView(root.right, treeMap, depth + 1, level + 1);
  }

  record Pair(Node node, int dist) {

  }
}
