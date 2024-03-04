package tree.lectures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;

public class TopViewOfBinaryTree {

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
      if (!map.containsKey(pair.dist)) {
        map.put(pair.dist, pair.node.key);
      }

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
   * tree. <br>
   * Auxiliary Space: O(N), Since we store the nodes in the map and queue.
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
      if (!map.containsKey(pair.dist)) {
        map.put(pair.dist, pair.node.key);
      }

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

  // TODO: https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

  record Pair(Node node, int dist) {

  }
}
