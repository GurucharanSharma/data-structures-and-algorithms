package deque.lectures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class JavaDeque {

  public static void execute() {
    Deque<Integer> linkedList = new LinkedList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    /*
      add(element):	        This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.
      addFirst(element):	  This method is used to add an element at the head of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.
      addLast(element):	    This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.
      contains():	          This method is used to check whether the queue contains the given object or not.
      descendingIterator():	This method returns an iterator for the deque. The elements will be returned in order from last(tail) to first(head).
      element():	          This method is used to retrieve, but not remove, the head of the queue represented by this deque.
      getFirst():	          This method is used to retrieve, but not remove, the first element of this deque.
      getLast():	          This method is used to retrieve, but not remove, the last element of this deque.
      iterator():	          This method returns an iterator for the deque. The elements will be returned in order from first (head) to last (tail).
      offer(element):	      This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.
      offerFirst(element):	This method is used to add an element at the head of the queue. This method is preferable to addFirst() method since this method does not throws an exception when the capacity of the container is full since it returns false.
      offerLast(element):	  This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.
      peek():	              This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.
      peekFirst():	        This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.
      peekLast():	          This method is used to retrieve the element at the tail of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.
      poll():	              This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.
      pollFirst():	        This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.
      pollLast():	          This method is used to retrieve and remove the element at the tail of the deque. This method returns null if the deque is empty.
      pop():	              This method is used to remove an element from the head and return it.
      push(element):	      This method is used to add an element at the head of the queue.
      removeFirst():	      This method is used to remove an element from the head of the queue.
      removeLast():       	This method is used to remove an element from the tail of the queue.
      size():	              This method is used to find and return the size of the deque.
     */
  }
}
