package tree.binarysearchtree.lectures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import tree.BinaryTree.Node;

public class VerticalTraversal {

  public static void execute(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(0, root));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      if (pair.node.left != null) {
        queue.offer(new Pair(pair.hd - 1, pair.node.left));
      }

      if (pair.node.right != null) {
        queue.offer(new Pair(pair.hd + 1, pair.node.right));
      }

      ArrayList<Integer> list = map.getOrDefault(pair.hd, new ArrayList<>());
      list.add(pair.node.key);
      map.put(pair.hd, list);
    }

    for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      System.out.println(entry.getValue());
    }
    System.out.println();
  }

  public static void execute1(Node root) {
    if (root == null) {
      return;
    }

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    traverse(root, 0, map);

    for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      System.out.println(entry.getValue());
    }
    System.out.println();
  }

  private static void traverse(Node root, int hd, Map<Integer, ArrayList<Integer>> map) {
    if (root == null) {
      return;
    }

    ArrayList<Integer> list = map.getOrDefault(hd, new ArrayList<>());
    list.add(root.key);
    map.put(hd, list);

    traverse(root.left, hd - 1, map);

    traverse(root.right, hd + 1, map);
  }

  private static class Pair {

    int hd;
    Node node;

    public Pair(int hd, Node node) {
      this.hd = hd;
      this.node = node;
    }
  }


}
