package hashing.lectures;

import java.util.HashMap;

/**
 * Complexity analysis of Insert:
 * <ul>
 * <li>Time Complexity: O(N), It takes O(N) time complexity because we are checking the load factor each time and when it is greater than 0.5 we call rehashing function which takes O(N) time.</li>
 * <li>Space Complexity: O(N), It takes O(N) space complexity because we are creating a new array of doubled size and copying all the elements to the new array.</li>
 * </ul>
 * Complexity analysis of Search:
 * <ul>
 * <li>Time Complexity: O(N),  It takes O(N) time complexity because we are searching in a linked list of size N.</li>
 * <li>Space Complexity: O(1),  It takes O(1) space complexity because we are not using any extra space for searching.</li>
 * </ul>
 */
public class DynamicChaining<T> {

  private int numOfElements;
  private int capacity;
  private HashMap<Integer, Node<T>> arr;  // Use HashMap for efficiency and type safety

  DynamicChaining() {
    this.capacity = 1;
    this.numOfElements = 0;
    this.arr = new HashMap<>();
  }

  public static void main(String[] args) {
    DynamicChaining<Integer> dynamicChaining = new DynamicChaining<>();
    dynamicChaining.insert("A", 16);
    dynamicChaining.insert("B", 14);
    dynamicChaining.insert("C", 14);
    dynamicChaining.insert("D", 14);
    dynamicChaining.insert("E", 14);
    dynamicChaining.insert("F", 14);
    dynamicChaining.insert("G", 14);
    dynamicChaining.insert("H", 14);
    dynamicChaining.insert("I", 14);
    dynamicChaining.insert("J", 14);
    dynamicChaining.insert("K", 17);

    System.out.println(dynamicChaining.numOfElements + " of " + dynamicChaining.capacity);
    System.out.println(dynamicChaining.search("K"));

    System.out.println(dynamicChaining.delete("K"));

    System.out.println(dynamicChaining.numOfElements + " of " + dynamicChaining.capacity);
    System.out.println(dynamicChaining.search("K"));
  }

  // Hash function: Assume that this hash function works, and it gives the correct index.
  private int hashFunction(String key) {
    long sum = 0, factor = 31;
    for (int i = 0; i < key.length(); i++) {
      sum = ((sum % capacity) + ((key.charAt(i)) * factor) % capacity) % capacity;
      factor = ((factor % Short.MAX_VALUE) * (31 % Short.MAX_VALUE)) % Short.MAX_VALUE;
    }

    return (int) sum;
  }

  private float getLoadFactor() {
    return (float) (numOfElements + 1) / (float) capacity;
  }

  // Rehashing
  private void rehashing() {
    int oldCapacity = capacity;
    HashMap<Integer, Node<T>> temp = new HashMap<>(arr);

    capacity = oldCapacity * 2;     // Resetting the capacity
    numOfElements = 0;              // Resetting the size
    arr = new HashMap<>(capacity);  // Casting is necessary in Java

    for (int i = 0; i < oldCapacity; i++) {
      Node<T> currentBucketHead = temp.get(i);
      while (currentBucketHead != null) {
        insert(currentBucketHead.key, currentBucketHead.value);
        currentBucketHead = currentBucketHead.next;
      }
    }
  }

  // Insert method
  public void insert(String key, T value) {
    if (getLoadFactor() > 0.5f) {
      System.out.println("Rehashing...");
      rehashing();
    }

    int bucketIndex = hashFunction(key);
    Node<T> newNode = new Node<>(key, value);
    newNode.next = arr.get(bucketIndex);
    arr.put(bucketIndex, newNode);
    numOfElements++;
  }

  // Delete method
  public T delete(String key) {
    int index = hashFunction(key);
    Node<T> head = arr.get(index);

    // If the list is empty, return null
    if (head == null) {
      return null;
    }

    // Special case: If the head node is the node to be deleted
    if (head.key.equals(key)) {
      arr.put(index, head.next); // Move the head to the next node
      numOfElements--;
      return head.value;
    }

    // Traverse the list to find the node with the given key
    Node<T> prev = null;
    Node<T> current = head;

    while (current != null && !current.key.equals(key)) {
      prev = current;
      current = current.next;
    }

    // If the node with the key is not found, return null
    if (current == null) {
      return null;
    }

    // If the node to be deleted is the last node (current.next is null)
    if (current.next == null) {
      prev.next = null; // Update the previous node's next to null
    } else {
      // If the node to be deleted is in the middle
      prev.next = current.next;
    }

    numOfElements--;
    return current.value;
  }

  private T search(String key) {
    int bucketIndex = this.hashFunction(key);
    Node<T> bucketHead = this.arr.get(bucketIndex);
    while (bucketHead != null) {
      if (bucketHead.key.equals(key)) {  // Use equals for string comparison
        return bucketHead.value;
      }
      bucketHead = bucketHead.next;
    }
    System.out.println("Oops!! Data not found.");
    return null;  // Return null instead of -1 for better Java practice
  }

  public void print() {
    for (HashMap.Entry<Integer, Node<T>> entry : arr.entrySet()) {
      Node<T> head = entry.getValue();
      while (head != null) {
        System.out.print("[" + head.key + ", " + head.value + "]");
        head = head.next;
      }

      System.out.println();
    }
  }
}

class Node<T> {

  String key;
  T value;
  Node<T> next;

  Node(String key, T value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}