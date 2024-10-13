package queue.lectures;

public class CircularArrayQueue {

  // Using 2 pointers, one for front and other for rear
  public static class Queue {

    int[] arr;
    int size, capacity;
    int front, rear;

    public Queue(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.front = this.rear = 0;
      this.arr = new int[capacity];
    }

    public void enqueue(int data) {
      if (isFull()) {
        System.out.println("Queue full !");
        return;
      }

      rear = (rear + 1) % capacity;
      arr[rear] = data;
      size++;
    }

    public int deque() {
      if (size == -1) {
        System.out.println("Queue empty !");
        return -1;
      } else {
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;

        return res;
      }
    }

    public boolean isEmpty() {
      return (size == 0);
    }

    public boolean isFull() {
      return (size == capacity);
    }

    private int getFront() {
      return front;
    }

    public void print() {
      if (size == 0) {
        return;
      }

      while (size != 0) {
        System.out.print(deque() + " ");
      }
      System.out.println();
    }
  }

  // Using only front pointer
  public static class FrontQueue {

    int[] arr;
    int size, capacity;
    int front;

    public FrontQueue(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.front = 0;
      this.arr = new int[capacity];
    }

    public void enqueue(int data) {
      if (isFull()) {
        System.out.println("Queue full !");
        return;
      }

      int rear = (getRear() + 1) % capacity;
      arr[rear] = data;
      size++;
    }

    public int deque() {
      if (size == -1) {
        System.out.println("Queue empty !");
        return -1;
      } else {
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;

        return res;
      }
    }

    public boolean isEmpty() {
      return (size == 0);
    }

    public boolean isFull() {
      return (size == capacity);
    }

    private int getRear() {
      if (isEmpty()) {
        return -1;
      }

      return (front + size - 1) % capacity;
    }

    private int getFront() {
      return front;
    }

    public void print() {
      if (size == 0) {
        return;
      }

      while (size != 0) {
        System.out.print(deque() + " ");
      }
      System.out.println();
    }
  }
}
