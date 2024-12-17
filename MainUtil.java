import linkedlist.common.CircularLinkedList;
import linkedlist.common.SinglyLinkedList;

public class MainUtil {

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }

  public static SinglyLinkedList.Node createSinglyLinkedList(int[] values) {
    SinglyLinkedList.Node head = new SinglyLinkedList.Node(values[0]);
    SinglyLinkedList.Node current = head;

    for (int i = 1; i < values.length; i++) {
      current.next = new SinglyLinkedList.Node(values[i]);
      current = current.next;
    }

    return head;
  }

  public static CircularLinkedList.Node createCircularLinkedList(int[] values) {
    CircularLinkedList.Node head = new CircularLinkedList.Node(values[0]);
    CircularLinkedList.Node current = head;

    for (int i = 1; i < values.length; i++) {
      current.next = new CircularLinkedList.Node(values[i]);
      current = current.next;
    }

    current.next = head;
    return head;
  }
}
