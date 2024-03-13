package heap;

import heap.lectures.MaxHeap;
import heap.lectures.MinHeap;

public class HeapRunner {

  public static void main(String[] args) {
    System.out.println("Min Heap => ");
    MinHeap minHeap = new MinHeap(5);
    minHeap.print();
    System.out.println("Yo");
    minHeap.insert(30);
    minHeap.insert(40);
    minHeap.insert(10);
    minHeap.insert(20);
    minHeap.insert(50);
    minHeap.print();
    minHeap.insert(60);
    minHeap.print();

    System.out.println("\nMax Heap => ");
    MaxHeap maxHeap = new MaxHeap(5);
    maxHeap.print();
    maxHeap.insert(30);
    maxHeap.insert(40);
    maxHeap.insert(10);
    maxHeap.insert(20);
    maxHeap.insert(50);
    maxHeap.print();
    maxHeap.insert(60);
    maxHeap.print();
  }
}
