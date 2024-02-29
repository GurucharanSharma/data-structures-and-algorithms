package linkedlist.lectures;

import java.util.HashMap;

public class LRUCache {

  private final HashMap<Integer, Node> lookup;
  Node head, tail;
  int capacity, size;

  public LRUCache(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Capacity must be > 0");
    }

    this.capacity = 0;
    this.size = size;

    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.head.prev = null;
    this.tail.next = null;

    this.lookup = new HashMap<>();
  }

  public void print() {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    Node curr = head.next;
    while (curr.next != tail) {
      System.out.print("[" + curr.key + " : " + curr.value + "]");
      curr = curr.next;
    }
    System.out.println();
  }

  private void insertAtHead(Node node) {
    node.next = head.next;
    node.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  private void deleteNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public int get(int key) {
    if (lookup.containsKey(key)) {
      Node node = lookup.get(key);

      deleteNode(node);
      insertAtHead(node);

      return node.value;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    if (lookup.containsKey(key)) {
      Node node = lookup.get(key);
      node.value = value;

      deleteNode(node);
      insertAtHead(node);
    } else {
      Node node = new Node(key, value);
      lookup.put(node.key, node);

      if (capacity >= size) {
        lookup.remove(tail.prev.key);
        deleteNode(tail.prev);
        insertAtHead(node);
      } else {
        insertAtHead(node);
        capacity++;
      }
    }
  }

  public static class Node {

    public int key;
    public int value;
    public Node next;
    public Node prev;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }
}
