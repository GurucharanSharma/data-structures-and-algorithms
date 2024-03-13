package heap;

import heap.lectures.MinHeap;

public class HeapRunner {

  public static void main(String[] args) {
    /*
     * Minimum heap implementation
     */
//    System.out.println("MinHeap.insert() => ");
//    MinHeap minHeap = new MinHeap(5);
//    minHeap.print();
//    System.out.println("Yo");
//    minHeap.insert(30);
//    minHeap.insert(40);
//    minHeap.insert(10);
//    minHeap.insert(20);
//    minHeap.insert(50);
//    minHeap.print();
//    minHeap.insert(60);
//    minHeap.print();

    /*
     * Maximum heap implementation
     */
//    System.out.println("\nMaxHeap.insert() => ");
//    MaxHeap maxHeap = new MaxHeap(5);
//    maxHeap.print();
//    maxHeap.insert(30);
//    maxHeap.insert(40);
//    maxHeap.insert(10);
//    maxHeap.insert(20);
//    maxHeap.insert(50);
//    maxHeap.print();
//    maxHeap.insert(60);
//    maxHeap.print();

    /*
     * Minimum heapify
     */
//    System.out.println("\n# MinHeap.heapify() => ");
//    int[] arr = {40, 20, 30, 35, 25, 80, 32, 100, 70, 60};
//    MinHeap minHeap = new MinHeap(arr);
//    minHeap.print();
//    minHeap.heapify(50);
//    minHeap.heapify(0);
//    minHeap.print();

    /*
     * Maximum heapify
     */
//    System.out.println("\n# MaxHeap.heapify() => ");
//    int[] arr = {5, 20, 35, 10, 15, 25};
//    MaxHeap maxHeap = new MaxHeap(arr);
//    maxHeap.print();
//    maxHeap.heapify(50);
//    maxHeap.heapify(0);
//    maxHeap.print();

    /*
     * Extract Min
     */
    System.out.println("\n# MinHeap.extractMin() => ");
    MinHeap minHeap = new MinHeap(10);
    System.out.println(minHeap.extractMin());
    minHeap.insert(10);
    minHeap.insert(20);
    minHeap.insert(30);
    minHeap.insert(5);
    minHeap.insert(1);
    minHeap.print();
    System.out.println(minHeap.extractMin());
    minHeap.print();
  }
}
