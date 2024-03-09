package tree.binarysearchtree.lectures;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import tree.BinaryTree.Node;

public class VerticalSum {

  public static void execute(Node root) {
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
}
