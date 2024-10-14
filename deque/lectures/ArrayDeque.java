package deque.lectures;

public class ArrayDeque {

  public static void main(String[] args) {
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
  }

  // Operations on Deque:
  //  void insertfront(int key);
  //  void insertrear(int key);
  //  void deletefront();
  //  void deleterear();
  //  bool isFull();
  //  bool isEmpty();
  //  int getFront();
  //  int getRear();
  public static class CircularQueue {

    int[] arr;
    int front;
    int size, capacity;

    public CircularQueue(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.front = -1;

      this.arr = new int[capacity];
    }

    public boolean insertFront(int val) {
      if (isFull()) {
        System.out.println("Deque full !");
        return false;
      }

      front = (front - 1 + capacity) % capacity;
      arr[front] = val;
      size++;

      return true;
    }

    public boolean insertRear(int val) {
      if (isFull()) {
        System.out.println("Deque full !");
        return false;
      }

      int rear = (front + size - 1) % capacity;
      rear = (rear + 1) % capacity;
      arr[rear] = val;
      size++;

      return true;
    }

    public int deleteFront() {
      if (isEmpty()) {
        System.out.println("Deque empty !");
        return -1;
      }

      int val = arr[front];
      front = (front + 1) % capacity;
      size--;

      return val;
    }

    public int deleteRear() {
      if (isEmpty()) {
        System.out.println("Deque empty !");
        return -1;
      }

      int rear = (front + size - 1) % capacity;
      int val = arr[rear];
      size--;

      return val;
    }

    public int getFront() {
      if (isEmpty()) {
        return -1;
      }

      return arr[front];
    }

    public int getRear() {
      if (isEmpty()) {
        return -1;
      }

      int rear = (front + size - 1) % capacity;
      return arr[rear];
    }

    public boolean isFull() {
      return size == capacity;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int getSize() {
      return size;
    }
  }
}
