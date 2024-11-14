package tree.binarysearchtree.lectures;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;

public class VerticalSum {

  // Approach 1: Using Recursion
  public static void verticalSum(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new TreeMap<>();
    calculateSum(root, 0, map);

    for (Entry<Integer, Integer> record : map.entrySet()) {
      System.out.print(record.getValue() + " ");
    }
  }

  private static void calculateSum(Node root, int hd, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }

    calculateSum(root.left, hd - 1, map);
    map.put(hd, map.getOrDefault(hd, 0) + root.key);
    calculateSum(root.right, hd + 1, map);
  }

  // Approach 2: Using BFS
  private static void verticalSum1(Node root) {
    if (root == null) {
      return;
    }

    TreeMap<Integer, Integer> sumLookup = new TreeMap<>();
    Queue<SimpleEntry<Integer, Node>> queue = new LinkedList<>();
    queue.add(new SimpleEntry<>(0, root));

    while (!queue.isEmpty()) {
      SimpleEntry<Integer, Node> entry = queue.remove();
      Node curr = entry.getValue();
      int hDist = entry.getKey();

      sumLookup.put(hDist, sumLookup.getOrDefault(hDist, 0) + curr.key);

      if (curr.left != null) {
        queue.add(new SimpleEntry<>(hDist - 1, curr.left));
      }

      if (curr.right != null) {
        queue.add(new SimpleEntry<>(hDist + 1, curr.right));
      }
    }

    for (Entry<Integer, Integer> entry : sumLookup.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
