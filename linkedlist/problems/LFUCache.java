package linkedlist.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {

  private final int capacity;
  Map<Integer, Node> lruCache;
  Map<Integer, LinkedList<Node>> frequencyLookup;
  private int minFrequency;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.minFrequency = 0;

    lruCache = new HashMap<>();
    frequencyLookup = new HashMap<>();
  }

  private void updateNode(Node node) {
    LinkedList<Node> oldList = frequencyLookup.get(node.frequency);
    oldList.remove(node);

    if (oldList.isEmpty() && minFrequency == node.frequency) {
      minFrequency = node.frequency + 1;
    }

    node.frequency += 1;
    LinkedList<Node> newList = frequencyLookup.getOrDefault(node.frequency, new LinkedList<>());
    newList.addFirst(node);
    frequencyLookup.put(node.frequency, newList);
  }

  public int get(int key) {
    if (!lruCache.containsKey(key)) {
      return -1;
    }

    Node node = lruCache.get(key);
    updateNode(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (lruCache.containsKey(key)) {
      Node node = lruCache.get(key);
      node.value = value;

      updateNode(node);
    } else {
      Node node = new Node(key, value, 1);
      lruCache.put(key, node);
      LinkedList<Node> list = frequencyLookup.getOrDefault(1, new LinkedList<>());
      list.addFirst(node);
      frequencyLookup.put(1, list);

      if (lruCache.size() > capacity) {
        LinkedList<Node> minList = frequencyLookup.get(minFrequency);
        Node fNode = minList.removeLast();
        lruCache.remove(fNode.key);

        if (!minList.isEmpty()) {
          frequencyLookup.put(minFrequency, minList);
        }
      }

      minFrequency = 1;
    }
  }

  private static class Node {

    public int key;
    public int value;
    public int frequency;
    public Node next;
    public Node prev;

    public Node(int key, int value, int frequency) {
      this.key = key;
      this.value = value;
      this.frequency = frequency;
      this.next = null;
      this.prev = null;
    }
  }
}
