package queue.lectures;

public class SimpleArrayQueue {

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

    public boolean enqueue(int data) {
      if (size == capacity) {
        System.out.println("Queue full !");
        return false;
      }

      rear = getRear() + 1;
      arr[rear] = data;
      size++;

      return true;
    }

    public int deque() {
      if (size == -1) {
        System.out.println("Queue empty !");
        return -1;
      } else {
        int res = arr[front];
        for (int i = 0; i < size - 1; i++) {
          arr[i] = arr[i + 1];
        }
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
      if (size == 0) {
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
