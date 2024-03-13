package heap.lectures;

import java.util.Arrays;

public class MinHeap {

  private final int[] arr;
  private final int capacity;
  private int size;

  public MinHeap(int[] arr) {
    this.capacity = arr.length;
    this.size = arr.length;
    this.arr = Arrays.copyOf(arr, arr.length);
  }

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.arr = new int[capacity];
  }

  public int getSize() {
    return size;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getLeft(int i) {
    return 2 * i + 1;
  }

  public int getRight(int i) {
    return 2 * i + 2;
  }

  public int getParent(int i) {
    return (i - 1) / 2; // returns floor
  }

  public void insert(int key) {
    if (size == capacity) {
      System.out.println("Capacity full !");
      return;
    }

    arr[size++] = key;
    for (int i = size - 1; i >= 0 && arr[getParent(i)] > arr[i]; i = getParent(i)) {
      swap(i, getParent(i));
    }
  }

  public void print() {
    System.out.print("[");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.print("]");
    System.out.println();
  }

  private void swap(int i, int j) {
    if (i == j) {
      return;
    }

    if (i < 0 || i >= size || j < 0 || j >= size) {
      System.out.println("Invalid index !");
    }

    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
