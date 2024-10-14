package deque.problems;

import java.util.ArrayDeque;

public class DequeDeletion {

  public static void main(String[] args) {
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    deq.offer(1);
    deq.offer(2);
    deq.offer(4);
    deq.offer(5);
    deq.offer(6);

    System.out.println(deq);
//    eraseAt(deq, 2);
    eraseInRange(deq, 1, 4);
    System.out.println(deq);
  }

  //Function to erase the element from specified position X in deque.
  public static void eraseAt(ArrayDeque<Integer> deq, int X) {
    if (X >= deq.size()) {
      return;
    }

    ArrayDeque<Integer> aux = new ArrayDeque<>();
    for (int i = 0; i < X; i++) {
      aux.offer(deq.poll());
    }

    deq.poll();

    while (!aux.isEmpty()) {
      deq.offerFirst(aux.pollLast());
    }
  }

  //Function to erase the elements in range start (inclusive), end (exclusive).
  public static void eraseInRange(ArrayDeque<Integer> deq, int start, int end) {
    if (end >= deq.size() || start < 0) {
      return;
    }

    ArrayDeque<Integer> aux = new ArrayDeque<>();
    for (int i = 0; i < start; i++) {
      aux.offer(deq.poll());
    }

    for (int i = start; i < end; i++) {
      deq.poll();
    }

    while (!aux.isEmpty()) {
      deq.offerFirst(aux.pollLast());
    }
  }

  //Function to erase all the elements in the deque.
  public static void eraseAll(ArrayDeque<Integer> deq) {
    while (!deq.isEmpty()) {
      deq.poll();
    }
  }
}
