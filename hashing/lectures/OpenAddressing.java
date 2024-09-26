package hashing.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class OpenAddressing {

  /**
   * Using linear probing
   */
  static class LinearProbing {

    private final int capacity;
    private final int[] arr;
    private int size;

    LinearProbing(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.arr = new int[capacity];

      Arrays.fill(arr, -1);
    }

    private int hash(int key) {
      return key % this.capacity;
    }

    private boolean search(int key) {
      int h = hash(key);
      int i = h;

      while (arr[i] != -1) {
        if (arr[i] == key) {
          return true;
        }

        i = (i + 1) % capacity;

        if (i == h) {
          return false;
        }
      }

      return false;
    }

    private boolean insert(int key) {
      if (size == capacity) {
        return false;
      }

      int i = hash(key);
      while (arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
        i = (i + 1) % capacity;
      }

      if (arr[i] == key) {
        return false;
      } else {
        arr[i] = key;
        size++;
        return true;
      }
    }

    private boolean erase(int key) {
      int h = hash(key);
      int i = h;

      while (arr[i] != -1) {
        if (arr[i] == key) {
          arr[i] = -2;
          return true;
        }

        i = (i + 1) % capacity;
        if (i == h) {
          return false;
        }
      }

      return false;
    }
  }

  /**
   * Using quadratic probing
   */
  static class QuadraticProbing {

    int capacity;
    int size;
    int[] table;

    QuadraticProbing(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.table = new int[capacity];
      Arrays.fill(table, -1);
    }

    private int hash(int key) {
      return key % capacity;
    }

    public boolean insert(int key) {
      if (size == capacity) {
        System.out.println("Table is full!");
        return false;
      }

      int i = hash(key);
      for (int j = 0; j <= capacity; j++) {
        if (table[i] == -1 || table[i] == -2) {
          table[i] = key;
          size++;
          return true;
        }

        i = (i + j * j) % capacity;
      }

      return false;
    }

    public boolean search(int key) {
      int i = hash(key);

      for (int j = 0; j <= capacity; j++) {
        if (table[i] == key) {
          return true;
        }

        i = (i + j * j) % capacity;
      }

      return false;
    }

    public boolean delete(int key) {
      int i = hash(key);
      for (int j = 0; j <= capacity; j++) {
        if (table[i] == key) {
          table[i] = -2;
          size--;
          return true;
        }

        i = (i + j * j) % capacity;
      }

      return false;
    }
  }

  /**
   * Using double hashing
   */
  static class DoubleHashing {

    private static final long MAX_SIZE = 10000001L;
    private final int TABLE_SIZE;
    private final ArrayList<Integer> hashTable;
    private final BitSet isPrime;
    private int keysPresent;
    private int PRIME;

    public DoubleHashing(int n) {
      isPrime = new BitSet((int) MAX_SIZE);
      setSieve();
      TABLE_SIZE = n;

      /* Find the largest prime number smaller than hash table's size. */
      PRIME = TABLE_SIZE - 1;
      while (isPrime.get(PRIME)) {
        PRIME--;
      }

      keysPresent = 0;

      /* Fill the hash table with -1 (empty entries). */
      hashTable = new ArrayList<>();
      for (int i = 0; i < TABLE_SIZE; i++) {
        hashTable.add(-1);
      }
    }

    /* Function to set sieve of Eratosthenes. */
    private void setSieve() {
      isPrime.set(0, true);
      isPrime.set(1, true);
      for (long i = 2; i * i <= MAX_SIZE; i++) {
        if (!isPrime.get((int) i)) {
          for (long j = i * i; j <= MAX_SIZE; j += i) {
            isPrime.set((int) j);
          }
        }
      }
    }

    private int hash1(int value) {
      return value % TABLE_SIZE;
    }

    private int hash2(int value) {
      return PRIME - (value % PRIME);
    }

    private boolean isFull() {
      return (TABLE_SIZE == keysPresent);
    }

    private void printPrime(long n) {
      for (long i = 0; i <= n; i++) {
        if (!isPrime.get((int) i)) {
          System.out.print(i + ", ");
        }
      }
      System.out.println();
    }

    /* Function to insert value in hash table */
    public void insert(int value) {

      if (value == -1 || value == -2) {
        System.out.println("ERROR : -1 and -2 can't be inserted in the table");
      }

      if (isFull()) {
        System.out.println("ERROR : Hash Table Full");
        return;
      }

      int probe = hash1(value), offset = hash2(value); // in linear probing offset = 1;

      while (hashTable.get(probe) != -1) {
        if (-2 == hashTable.get(probe)) {
          break; // insert at deleted element's location
        }
        probe = (probe + offset) % TABLE_SIZE;
      }

      hashTable.set(probe, value);
      keysPresent += 1;
    }

    public void erase(int value) {
      /* Return if element is not present */
      if (!search(value)) {
        return;
      }

      int probe = hash1(value), offset = hash2(value);

      while (hashTable.get(probe) != -1) {
        if (hashTable.get(probe) == value) {
          hashTable.set(probe, -2); // mark element as deleted (rather than unvisited(-1)).
          keysPresent--;
          return;
        } else {
          probe = (probe + offset) % TABLE_SIZE;
        }
      }

    }

    public boolean search(int value) {
      int probe = hash1(value), offset = hash2(value), initialPos = probe;
      boolean firstItr = true;

      // Stop search if -1 is encountered.
      // Stop search after finding the element.
      // Stop search if one complete traversal of hash table is completed.
      // if none of the above cases occur then update the index and
      while (hashTable.get(probe) != -1) {
        if (hashTable.get(probe) == value) { // Stop search after finding the element.
          return true;
        } else if (probe == initialPos && !firstItr) { // Stop search if one complete traversal of hash table is completed.
          return false;
        } else {
          probe = ((probe + offset) % TABLE_SIZE); // if none of the above cases occur then update the index and
        }
        // check at it.

        firstItr = false;
      }

      return false;
    }

    /* Function to display the hash table. */
    public void print() {
      for (int i = 0; i < TABLE_SIZE; i++) {
        System.out.print(hashTable.get(i) + ", ");
      }
      System.out.println();
    }
  }
}
