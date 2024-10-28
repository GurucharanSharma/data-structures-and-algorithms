package tree.binarytree.lectures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;
import tree.binarytree.lectures.BottomViewOfBinaryTree.Pair;

public class TopViewOfBinaryTree {


  public static void main(String[] args) {
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.right = new Node(4);
//    root.left.right.right = new Node(5);
//    root.left.right.right.right = new Node(6);

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

    printTopView(root);
    System.out.println();
    printTopView1(root);
    System.out.println();
    printTopView2(root);
  }

  /**
   * Time complexity: O(N * log(N)), where N is the number of nodes in the given tree.<br> Auxiliary Space: O(N), As we store nodes in the map and
   * queue.
   */
  public static void printTopView(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();

      if (!map.containsKey(pair.dist())) {
        map.put(pair.dist(), pair.node().key);
      }

      if (pair.node().left != null) {
        queue.offer(new Pair(pair.node().left, pair.dist() - 1));
      }

      if (pair.node().right != null) {
        queue.offer(new Pair(pair.node().right, pair.dist() + 1));
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
  }

  /**
   * Time Complexity: O(N), Since we only perform level-order traversal and print some part of the N nodes which at max will be 2N in case of skew
   * tree. <br> Auxiliary Space: O(N), Since we store the nodes in the map and queue.
   */
  public static void printTopView1(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    int min = 0;
    int max = 0;

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();

      if (!map.containsKey(pair.dist())) {
        map.put(pair.dist(), pair.node().key);
      }

      if (pair.node().left != null) {
        min = Math.min(min, pair.dist() - 1);
        queue.offer(new Pair(pair.node().left, pair.dist() - 1));
      }

      if (pair.node().right != null) {
        max = Math.max(max, pair.dist() + 1);
        queue.offer(new Pair(pair.node().right, pair.dist() + 1));
      }
    }

    for (; min <= max; min++) {
      System.out.print(map.get(min) + " ");
    }
  }

  // Recursive approach
  // Time complexity: O(N * log(N)), where N is the number of nodes in the given binary tree with each insertion operation in Map requiring O(log2 N) complexity.
  // Auxiliary Space: O(N)
  private static void printTopView2(Node root) {
    Map<Integer, TreePair> treeMap = new TreeMap<>();
    fillTopView(root, treeMap, 0, 0);

    for (Entry<Integer, TreePair> entry : treeMap.entrySet()) {
      System.out.print(entry.getValue().key + " ");
    }
  }

  private static void fillTopView(Node root, Map<Integer, TreePair> treeMap, int d, int l) {
    if (root == null) {
      return;
    }

    if (!treeMap.containsKey(d)) {
      treeMap.put(d, new TreePair(root.key, l));
    } else if (treeMap.get(d).level > l) {
      treeMap.put(d, new TreePair(root.key, l));
    }

    fillTopView(root.left, treeMap, d - 1, l + 1);
    fillTopView(root.right, treeMap, d + 1, l + 1);
  }

  static class TreePair {

    int key;
    int level;

    TreePair(int key, int level) {
      this.key = key;
      this.level = level;
    }
  }
}
