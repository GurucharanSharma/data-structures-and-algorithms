package linkedlist.problems;

import java.util.Arrays;
import java.util.List;
import linkedlist.common.SinglyLinkedList;
import linkedlist.common.SinglyLinkedList.Node;

public class MergeKSortedLinkedLists {

  public static void main(String[] args) {
    Node[] arr = new Node[3];

    arr[0] = new Node(1);
    arr[0].next = new Node(3);
    arr[0].next.next = new Node(5);
    arr[0].next.next.next = new Node(7);

    arr[1] = new Node(2);
    arr[1].next = new Node(4);
    arr[1].next.next = new Node(6);
    arr[1].next.next.next = new Node(8);

    arr[2] = new Node(0);
    arr[2].next = new Node(9);
    arr[2].next.next = new Node(10);
    arr[2].next.next.next = new Node(11);

    // Merge all lists
    Node head = mergeKLists(Arrays.asList(arr));
    SinglyLinkedList.print(head);
  }

  // Function to merge K sorted linked list.
  // Naive Approach 1 – Merge One by One
  private static Node mergeKLists(List<Node> arr) {
    for (int i = 1; i < arr.size(); i++) {
      while (true) {
        Node oHead = arr.get(0);
        Node iHead = arr.get(i);

        if (iHead == null) {
          break;
        }

        // First node of second list is smaller than first node of first list.
        // This means that the first node of second list needs to be inserted
        // at the head of the first list and the head needs to be changed.
        if (oHead.data > iHead.data) {
          arr.set(i, iHead.next); // Move the curr (head) pointer of the second list to the next element.
          iHead.next = oHead;
          arr.set(0, iHead);      // Change the head of the first array to the first node of the second list
        } else {
          while (oHead.next != null) {
            if (oHead.next.data > iHead.data) {
              arr.set(i, iHead.next);
              iHead.next = oHead.next;
              oHead.next = iHead;
              break;
            }

            oHead = oHead.next;

            if (oHead.next == null) {
              arr.set(i, iHead.next);
              iHead.next = null;
              oHead.next = iHead;
              oHead.next.next = null;
              break;
            }
          }
        }
      }
    }

    return arr.get(0);
  }
}
