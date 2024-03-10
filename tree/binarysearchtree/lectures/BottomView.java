package tree.binarysearchtree.lectures;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;
import tree.Pair;

public class BottomView {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      if (pair.node().left != null) {
        queue.add(new Pair(pair.node().left, pair.dist() - 1));
      }

      if (pair.node().right != null) {
        queue.add(new Pair(pair.node().right, pair.dist() + 1));
      }

      map.put(pair.dist(), pair.node().key);
    }

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
    System.out.println();
  }

  public static void execute1(Node root) {

    if (root == null) {
      return;
    }

    Map<Integer, Integer> map = new TreeMap<>();
    traverse(root, 0, map);

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
    System.out.println();
  }

  private static void traverse(Node root, int hd, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }

    traverse(root.left, hd - 1, map);

    map.put(hd, root.key);

    traverse(root.right, hd + 1, map);
  }
}
