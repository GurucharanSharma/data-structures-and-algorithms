package deque;

import deque.lectures.ArrayDeque;
import deque.lectures.ArrayDeque.CircularQueue;
import deque.lectures.FirstCircularTour;
import deque.lectures.SubArrayMaximum;
import java.util.Arrays;

public class DequeRunner {

  public static void main(String[] args) {

    // Circular implementation of Deque
    System.out.println("\nArrayDeque.CircularQueue => ");
    ArrayDeque.CircularQueue circularQueue = new CircularQueue(5);

    System.out.println(circularQueue.isEmpty());
    System.out.println(circularQueue.getRear());
    System.out.println(circularQueue.getFront());
    System.out.println(circularQueue.isFull());
    System.out.println(circularQueue.getSize());
    System.out.println();

    System.out.println(circularQueue.deleteFront());
    System.out.println(circularQueue.deleteRear());
    System.out.println();

    System.out.println(circularQueue.insertFront(10));
    System.out.println(circularQueue.insertFront(20));
    System.out.println(circularQueue.insertRear(30));
    System.out.println(circularQueue.insertRear(40));
    System.out.println(circularQueue.insertFront(50));
    System.out.println(circularQueue.insertRear(60));
    System.out.println();

    System.out.println(circularQueue.isEmpty());
    System.out.println(circularQueue.getRear());
    System.out.println(circularQueue.getFront());
    System.out.println(circularQueue.isFull());
    System.out.println(circularQueue.getSize());
    System.out.println();

    System.out.println(circularQueue.deleteFront());
    System.out.println(circularQueue.deleteRear());
    System.out.println();

    System.out.println(circularQueue.isEmpty());
    System.out.println(circularQueue.getRear());
    System.out.println(circularQueue.getFront());
    System.out.println(circularQueue.isFull());
    System.out.println(circularQueue.getSize());

    // Maximums of all subarrays of size K
    System.out.println("\nSubArrayMaximum => ");
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(arr));
    SubArrayMaximum.execute(arr, 3);

    // First Circular Tour
    System.out.println("\nFirstCircularTour => ");
    int[] petrol = {4, 6, 7, 4};
    int[] distance = {6, 5, 3, 5};
    System.out.println(FirstCircularTour.execute(petrol, distance));
    System.out.println(FirstCircularTour.execute1(petrol, distance));
    System.out.println(FirstCircularTour.execute2(petrol, distance));
  }
}
