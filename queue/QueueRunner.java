package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import queue.lectures.CircularArrayQueue;
import queue.lectures.DigitNumberGenerator;
import queue.lectures.LinkedQueue;
import queue.lectures.QueueUsingStack;
import queue.lectures.ReverseFirstKElements;
import queue.lectures.ReverseQueue;
import queue.lectures.SimpleArrayQueue;
import queue.lectures.SlidingWindowMaximum;
import queue.lectures.StackUsingQueue;

public class QueueRunner {

  public static void main(String[] args) {
    // Implementing queue using simple array
    System.out.println("\nSimpleArrayQueue => ");
    SimpleArrayQueue.Queue sQueue = new SimpleArrayQueue.Queue(5);
    sQueue.enqueue(10);
    sQueue.enqueue(20);
    sQueue.enqueue(30);
    sQueue.enqueue(40);
    sQueue.enqueue(50);
    sQueue.enqueue(60);
    System.out.println(sQueue.isEmpty());
    System.out.println(sQueue.isFull());

    System.out.println(sQueue.deque());
    System.out.println(sQueue.deque());
    System.out.println(sQueue.deque());
    System.out.println(sQueue.isEmpty());
    System.out.println(sQueue.isFull());

    sQueue.print();

    // Implementing queue using circular array
    System.out.println("\nCircularArrayQueue => ");
    CircularArrayQueue.Queue cQueue = new CircularArrayQueue.Queue(5);
    cQueue.enqueue(10);
    cQueue.enqueue(20);
    cQueue.enqueue(30);
    cQueue.enqueue(40);
    cQueue.enqueue(50);
    cQueue.enqueue(60);
    System.out.println(cQueue.isEmpty());
    System.out.println(cQueue.isFull());

    System.out.println(cQueue.deque());
    System.out.println(cQueue.deque());
    System.out.println(cQueue.deque());
    System.out.println(cQueue.isEmpty());
    System.out.println(cQueue.isFull());
    cQueue.print();

    // Implementing queue using linked lists
    System.out.println("\nLinkedQueue => ");
    LinkedQueue.Queue lQueue = new LinkedQueue.Queue();
    lQueue.enqueue(10);
    lQueue.enqueue(20);
    lQueue.enqueue(30);
    lQueue.enqueue(40);
    lQueue.enqueue(50);
    lQueue.enqueue(60);

    lQueue.print();
    System.out.println(lQueue.isEmpty());
    System.out.println(lQueue.getSize());

    System.out.println(lQueue.dequeue());
    System.out.println(lQueue.dequeue());
    System.out.println(lQueue.dequeue());
    System.out.println(lQueue.isEmpty());
    System.out.println(lQueue.getSize());
    lQueue.print();

    // Implement stack using queue
    System.out.println("\ntStackUsingQueue (push costly) => ");
    StackUsingQueue.PushQueue pushStack = new StackUsingQueue.PushQueue();
    System.out.println(pushStack.enqueue(10));
    System.out.println(pushStack.enqueue(20));
    System.out.println(pushStack.enqueue(30));
    System.out.println(pushStack.enqueue(40));

    System.out.println(pushStack.dequeue());
    System.out.println(pushStack.peek());

    System.out.println(pushStack.dequeue());
    System.out.println(pushStack.peek());

    System.out.println(pushStack.getSize());

    System.out.println("\ntStackUsingQueue (pop/peek costly) => ");
    StackUsingQueue.PopQueue popStack = new StackUsingQueue.PopQueue();
    System.out.println(popStack.enqueue(10));
    System.out.println(popStack.enqueue(20));
    System.out.println(popStack.enqueue(30));
    System.out.println(popStack.enqueue(40));

    System.out.println(popStack.dequeue());
    System.out.println(popStack.peek());

    System.out.println(popStack.dequeue());
    System.out.println(popStack.peek());

    System.out.println(popStack.getSize());

    System.out.println("\ntStackUsingQueue (push costly - single queue) => ");
    StackUsingQueue.SingleQueue singleQueue = new StackUsingQueue.SingleQueue();
    System.out.println(singleQueue.enqueue(10));
    System.out.println(singleQueue.enqueue(20));
    System.out.println(singleQueue.enqueue(30));
    System.out.println(singleQueue.enqueue(40));

    System.out.println(singleQueue.dequeue());
    System.out.println(singleQueue.peek());

    System.out.println(singleQueue.dequeue());
    System.out.println(singleQueue.peek());

    System.out.println(singleQueue.getSize());

    // Reversing a queue
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(10);
    queue.offer(20);
    queue.offer(30);
    queue.offer(40);
    queue.offer(50);

    System.out.println("\nReverseQueue => ");
    System.out.println(queue);
    ReverseQueue.execute(queue);
    System.out.println(queue);
    ReverseQueue.execute1(queue);
    System.out.println(queue);

    // Generate numbers with given digits
    System.out.println("\nDigitNumberGenerator => ");
    int[] arr = {5, 6};
    DigitNumberGenerator.execute(10, arr);

    // Sliding Window Maximum
    System.out.println("\nSlidingWindowMaximum => ");
    int[] brr = {10, 8, 5, 12, 15, 7, 6};
    System.out.println(Arrays.toString(brr));
    SlidingWindowMaximum.execute(brr, 3);

    // Reversing the first K elements of a Queue
    Queue<Integer> rQueue = new LinkedList<>();
    rQueue.offer(10);
    rQueue.offer(20);
    rQueue.offer(30);
    rQueue.offer(40);
    rQueue.offer(50);

    System.out.println("\nReverseFirstKElements => ");
    System.out.println(rQueue);
    ReverseFirstKElements.execute(rQueue, 3);
    System.out.println(rQueue);

    // Implementing Queue using Stack
    // Method 1 (By making enQueue operation costly)
    QueueUsingStack.PushQueue pushQueue = new QueueUsingStack.PushQueue();

    System.out.println("\nQueueUsingStack.PushQueue => ");
    System.out.println(pushQueue.peek());
    System.out.println(pushQueue.isEmpty());
    System.out.println(pushQueue.size());

    pushQueue.enqueue(10);
    pushQueue.enqueue(20);
    pushQueue.enqueue(30);
    pushQueue.enqueue(40);
    pushQueue.enqueue(50);

    System.out.println(pushQueue.peek());
    System.out.println(pushQueue.isEmpty());
    System.out.println(pushQueue.size());

    System.out.println(pushQueue.dequeue());

    System.out.println(pushQueue.peek());
    System.out.println(pushQueue.isEmpty());
    System.out.println(pushQueue.size());

    System.out.println(pushQueue.dequeue());

    System.out.println(pushQueue.peek());
    System.out.println(pushQueue.isEmpty());
    System.out.println(pushQueue.size());

    // Implementing Queue using Stack
    // Method 2 (By making deQueue operation costly)
    QueueUsingStack.PopQueue popQueue = new QueueUsingStack.PopQueue();

    System.out.println("\nQueueUsingStack.PopQueue => ");
    System.out.println(popQueue.peek());
    System.out.println(popQueue.isEmpty());
    System.out.println(popQueue.size());

    popQueue.enqueue(10);
    popQueue.enqueue(20);
    popQueue.enqueue(30);
    popQueue.enqueue(40);
    popQueue.enqueue(50);

    System.out.println(popQueue.peek());
    System.out.println(popQueue.isEmpty());
    System.out.println(popQueue.size());

    System.out.println(popQueue.dequeue());

    System.out.println(popQueue.peek());
    System.out.println(popQueue.isEmpty());
    System.out.println(popQueue.size());

    System.out.println(popQueue.dequeue());

    System.out.println(popQueue.peek());
    System.out.println(popQueue.isEmpty());
    System.out.println(popQueue.size());
  }
}
