package heap.lectures;

import java.util.Arrays;

public class MaxHeap {

  private final int[] arr;
  private final int capacity;
  private int size;

  public MaxHeap(int[] arr) {
    this.capacity = arr.length;
    this.size = arr.length;
    this.arr = Arrays.copyOf(arr, arr.length);
  }

  public MaxHeap(int capacity) {
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
    for (int i = size - 1; i >= 0 && arr[getParent(i)] < arr[i]; i = getParent(i)) {
      swap(i, getParent(i));
    }
  }

  public void heapify(int i) {
    if (i < 0 || i >= size) {
      System.out.println("Invalid index !");
      return;
    }

    int max = i;
    int left = getLeft(i);
    if (left < size && arr[left] > arr[max]) {
      max = left;
    }

    int right = getRight(i);
    if (right < size && arr[right] > arr[max]) {
      max = right;
    }

    if (max != i) {
      swap(i, max);
      heapify(max);
    }
  }

  public void print() {
    System.out.print("[");
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + ((i + 1) < size ? ", ": ""));
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
