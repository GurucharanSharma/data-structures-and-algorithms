package queue.lectures;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

  /**
   * Push costly stack using two queues.
   */
  public static class PushQueue {

    Queue<Integer> mQueue;
    Queue<Integer> aQueue;

    public PushQueue() {
      this.mQueue = new LinkedList<>();
      this.aQueue = new LinkedList<>();
    }

    public boolean enqueue(int data) {
      aQueue.offer(data);

      while (!mQueue.isEmpty()) {
        aQueue.offer(mQueue.poll());
      }

      Queue<Integer> tQueue = mQueue;
      mQueue = aQueue;
      aQueue = tQueue;

      return true;
    }

    public int dequeue() {
      if (mQueue.isEmpty()) {
        return -1;
      }

      return mQueue.poll();
    }

    public int getSize() {
      return mQueue.size();
    }

    public int peek() {
      return mQueue.peek() == null ? -1 : mQueue.peek();
    }

    public boolean isEmpty() {
      return mQueue.isEmpty();
    }
  }

  /**
   * Pop costly stack using two queues.
   */
  public static class PopQueue {

    Queue<Integer> mQueue;
    Queue<Integer> aQueue;

    public PopQueue() {
      this.mQueue = new LinkedList<>();
      this.aQueue = new LinkedList<>();
    }

    public boolean enqueue(int data) {
      mQueue.offer(data);
      return true;
    }

    public int dequeue() {
      while (mQueue.size() > 1) {
        aQueue.offer(mQueue.poll());
      }

      int element = mQueue.poll();
      while (!aQueue.isEmpty()) {
        mQueue.offer(aQueue.poll());
      }

      return element;
    }

    public int getSize() {
      return mQueue.size();
    }

    public int peek() {
      while (mQueue.size() > 1) {
        aQueue.offer(mQueue.poll());
      }

      int element = mQueue.poll();
      aQueue.offer(element);
      while (!aQueue.isEmpty()) {
        mQueue.offer(aQueue.poll());
      }

      return element;
    }

    public boolean isEmpty() {
      return mQueue.isEmpty();
    }
  }

  /**
   * Push costly stack using single queue.
   */
  public static class SingleQueue {

    Queue<Integer> queue;

    public SingleQueue() {
      this.queue = new LinkedList<>();
    }

    public boolean enqueue(int data) {
      queue.offer(data);
      for (int i = 0; i < queue.size() - 1; i++) {
        queue.offer(queue.poll());
      }

      return true;
    }

    public int dequeue() {
      if (queue.isEmpty()) {
        return -1;
      }

      return queue.poll();
    }

    public int getSize() {
      return queue.size();
    }

    public int peek() {
      return queue.peek() == null ? -1 : queue.peek();
    }

    public boolean isEmpty() {
      return queue.isEmpty();
    }
  }
}
