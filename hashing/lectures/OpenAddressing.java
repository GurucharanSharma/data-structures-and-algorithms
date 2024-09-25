package hashing.lectures;

import java.util.Arrays;

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
    // TODO
  }

  /**
   * Using double hashing
   */
  static class DoubleHashing {
    // TODO
  }
}
