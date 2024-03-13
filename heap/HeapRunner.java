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
     * Extract Min in Min Heap
     */
//    System.out.println("\n# MinHeap.extractMin() => ");
//    MinHeap minHeap = new MinHeap(10);
//    System.out.println(minHeap.extractMin());
//    minHeap.insert(10);
//    minHeap.insert(20);
//    minHeap.insert(30);
//    minHeap.insert(5);
//    minHeap.insert(1);
//    minHeap.print();
//    System.out.println(minHeap.extractMin());
//    minHeap.print();

    /*
     * Extract Max in Max Heap
     */
//    System.out.println("\n# MaxHeap.extractMax() => ");
//    MaxHeap maxHeap = new MaxHeap(10);
//    System.out.println(maxHeap.extractMax());
//    maxHeap.insert(10);
//    maxHeap.insert(20);
//    maxHeap.insert(30);
//    maxHeap.insert(5);
//    maxHeap.insert(1);
//    maxHeap.print();
//    System.out.println(maxHeap.extractMax());
//    maxHeap.print();

    /*
     * Decrease/Increase Key in Min Heap
     */
    System.out.println("\n# MaxHeap.extractMax() => ");
    MinHeap minHeap = new MinHeap(10);
    minHeap.decreaseKey(2, 1);
    minHeap.print();
    minHeap.insert(50);
    minHeap.insert(40);
    minHeap.insert(30);
    minHeap.insert(20);
    minHeap.insert(10);
    minHeap.print();
    System.out.println(minHeap.decreaseKey(2, 5));
    minHeap.print();
    System.out.println(minHeap.decreaseKey(2, 55));
    minHeap.print();
    System.out.println(minHeap.increasKey(1, 55));
    minHeap.print();
    System.out.println(minHeap.increasKey(1, 5));
    minHeap.print();
  }
}
