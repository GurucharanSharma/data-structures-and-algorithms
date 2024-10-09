package linkedlist.problems;

import linkedlist.common.SinglyLinkedList;
import linkedlist.common.SinglyLinkedList.Node;

public class AddNumberLinkedLists {

  public static void main(String[] args) {
    // Creating first linked list: 1 -> 2 -> 3
    // (represents 123)
    Node num1 = new Node(1);
    num1.next = new Node(2);
    num1.next.next = new Node(3);

    // Creating second linked list: 9 -> 9 -> 9
    // (represents 999)
    Node num2 = new Node(9);
    num2.next = new Node(9);
    num2.next.next = new Node(9);

//    Node head = addTwoLists(num1, num2);
//    SinglyLinkedList.print(head);

    Node head = addTwoLists1(num1, num2);
    SinglyLinkedList.print(head);
  }

  // Function to add two numbers represented by linked list.
  // Here we are using a third linked list to store the result
  private static Node addTwoLists(Node num1, Node num2) {
    int carry = 0, sum = 0;
    Node output = null;
    Node oHead = null;

    num1 = reverse(num1);
    num2 = reverse(num2);

    while (num1 != null || num2 != null || carry != 0) {
      sum = carry;

      if (num1 != null) {
        sum += num1.data;
        num1 = num1.next;
      }

      if (num2 != null) {
        sum += num2.data;
        num2 = num2.next;
      }

      Node result = new Node(sum % 10);
      carry = sum / 10;

      if (output == null) {
        output = oHead = result;
      } else {
        output.next = result;
        output = output.next;
      }
    }

    return reverse(oHead);
  }

  // Function to add two numbers represented by linked list.
  //  Note: The idea is to iterate over both the linked list simultaneously and instead of creating a
  //  new linked list to store the result, we can store the result in the longer list itself. If we are
  //  left with some carry after traversing both the linked list, we can create a new node and append
  //  it at the end of the longer linked list.
  private static Node addTwoLists1(Node num1, Node num2) {
    int size1 = countNodes(num1);
    int size2 = countNodes(num2);

    if (size1 < size2) {
      return addTwoLists1(num2, num1);
    }

    num1 = reverse(num1);
    num2 = reverse(num2);

    Node output = num1;
    int carry = 0;
    while (num2 != null || carry != 0) {
      output.data += carry;

      if (num2 != null) {
        output.data += num2.data;
        num2 = num2.next;
      }

      carry = output.data / 10;
      output.data = output.data % 10;

      if (output.next == null && carry != 0) {
        output.next = new Node(0);
      }

      output = output.next;
    }

    return reverse(num1);
  }

  private static Node reverse(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node prev = null, curr = head;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  private static int countNodes(Node head) {
    int count = 0;
    while (head != null) {
      head = head.next;
      count++;
    }

    return count;
  }
}
