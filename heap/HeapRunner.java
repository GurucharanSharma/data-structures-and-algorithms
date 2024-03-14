package heap;

import heap.lectures.KClosestElements;

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
//    System.out.println("\n# MinHeap.decreaseKey() / MinHeap.increaseKey() => ");
//    MinHeap minHeap = new MinHeap(10);
//    minHeap.decreaseKey(2, 1);
//    minHeap.print();
//    minHeap.insert(50);
//    minHeap.insert(40);
//    minHeap.insert(30);
//    minHeap.insert(20);
//    minHeap.insert(10);
//    minHeap.print();
//    System.out.println(minHeap.decreaseKey(2, 5));
//    minHeap.print();
//    System.out.println(minHeap.decreaseKey(2, 55));
//    minHeap.print();
//    System.out.println(minHeap.increasKey(1, 55));
//    minHeap.print();
//    System.out.println(minHeap.increasKey(1, 5));
//    minHeap.print();

    /*
     * Decrease/Increase Key in Max Heap
     */
//    System.out.println("\n# MaxHeap.decreaseKey() / MaxHeap.increaseKey() => ");
//    MaxHeap maxHeap = new MaxHeap(10);
//    maxHeap.decreaseKey(2, 1);
//    maxHeap.print();
//    maxHeap.insert(50);
//    maxHeap.insert(40);
//    maxHeap.insert(30);
//    maxHeap.insert(20);
//    maxHeap.insert(10);
//    maxHeap.print();
//    System.out.println(maxHeap.decreaseKey(2, 5));
//    maxHeap.print();
//    System.out.println(maxHeap.decreaseKey(2, 55));
//    maxHeap.print();
//    System.out.println(maxHeap.increaseKey(1, 55));
//    maxHeap.print();
//    System.out.println(maxHeap.increaseKey(1, 5));
//    maxHeap.print();

    /*
     * Delete key in Min Heap
     */
//    System.out.println("\n# MinHeap.deleteKey() => ");
//    MinHeap minHeap = new MinHeap(10);
//    minHeap.deleteKey1(1);
//    minHeap.print();
//    minHeap.insert(50);
//    minHeap.insert(40);
//    minHeap.insert(30);
//    minHeap.insert(20);
//    minHeap.insert(10);
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(1));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();
//    System.out.println(minHeap.deleteKey1(0));
//    minHeap.print();

    /*
     * Delete key in Max Heap
     */
//    System.out.println("\n# MaxHeap.deleteKey() => ");
//    MaxHeap maxHeap = new MaxHeap(10);
//    maxHeap.deleteKey1(1);
//    maxHeap.print();
//    maxHeap.insert(50);
//    maxHeap.insert(40);
//    maxHeap.insert(30);
//    maxHeap.insert(20);
//    maxHeap.insert(10);
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(1));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();
//    System.out.println(maxHeap.deleteKey1(0));
//    maxHeap.print();

    /*
     * Build min heap
     */
//    System.out.println("\n# MinHeap.buildHeap() => ");
//    int[] arr = {5, 23, 6, 89, 4, 85, 45, 50, 7, 3, 10};
//    MinHeap minHeap = new MinHeap(arr);
//    minHeap.print();
//    minHeap.buildHeap();
//    minHeap.print();

    /*
     * Build max heap
     */
//    System.out.println("\n# MinHeap.buildHeap() => ");
//    int[] arr = {5, 23, 6, 89, 4, 85, 45, 50, 7, 3, 10};
//    MaxHeap maxHeap = new MaxHeap(arr);
//    maxHeap.print();
//    maxHeap.buildHeap();
//    maxHeap.print();

    /*
     * Heap sort (ascending)
     */
//    System.out.println("\n# MaxHeap.heapSort() => ");
//    int[] arr = {5, 23, 6, 89, 4, 85, 45, 50, 7, 3, 10};
//    MaxHeap maxHeap = new MaxHeap(arr);
//    maxHeap.heapSort();
//    maxHeap.print();

    /*
     * Heap sort (descending)
     */
//    System.out.println("\n# MinHeap.heapSort() => ");
//    int[] arr = {5, 23, 6, 89, 4, 85, 45, 50, 7, 3, 10};
//    MinHeap minHeap = new MinHeap(arr);
//    minHeap.heapSort();
//    minHeap.print();

    /*
     * Sort K-Sorted array
     */
//    int[] arr = {2, 6, 3, 12, 56, 8};
//    SortKSortedArray.execute(arr, 3);
//    System.out.println(Arrays.toString(arr));

    /*
     * Buy Maximum Items with Given Sum
     */
//    System.out.println("\n# MaximumItems() => ");
//    int[] cost1 = {1, 12, 5, 111, 200, 1000, 10, 9, 12, 15};
//    int[] cost2 = {1, 12, 5, 111, 200, 1000, 10};
//
//    System.out.println("Approach 1:");
//    System.out.println(MaximumItems.execute(cost1, 50));
//    System.out.println(MaximumItems.execute(cost2, 50));
//
//    System.out.println("Approach 2:");
//    System.out.println(MaximumItems.execute1(cost1, 50));
//    System.out.println(MaximumItems.execute1(cost2, 50));

    /*
     * K Largest Elements
     */
//    System.out.println("\n# KLargestElements => ");
//    int[] arr = {1, 23, 12, 9, 30, 2, 50};
//    KLargestElements.execute(arr, 3);

    /*
     * K smallest Elements
     */
//    System.out.println("\n# KSmallestElements => ");
//    int[] arr = {1, 23, 12, 9, 30, 2, 50};
//    KSmallestElements.execute(arr, 3);

    /*
     * K Closest Elements
     */
    System.out.println("\n# KClosestElements => ");
    int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};

    System.out.println("Approach 1:");
    KClosestElements.execute(arr, 4, 35);

    System.out.println("Approach 2:");
    KClosestElements.execute1(arr, 4, 35);
  }
}
