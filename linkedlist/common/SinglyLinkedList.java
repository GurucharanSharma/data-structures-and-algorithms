package linkedlist.common;

import linkedlist.lectures.DeleteNodeWithOnlyPointerGivenToIt;
import linkedlist.lectures.DetectLoopInLinkedList;
import linkedlist.lectures.InsertAtBeginningOfSinglyLinkedList;
import linkedlist.lectures.IntersectionPointOfTwoLinkedLists;
import linkedlist.lectures.LRUCache;
import linkedlist.lectures.MergeTwoSortedLInkedLists;
import linkedlist.lectures.MiddleOfLinkedList;
import linkedlist.lectures.NthNodeFromEndOfLinkedList;
import linkedlist.lectures.PairwiseSwapNodesOfLinkedList;
import linkedlist.lectures.PalindromeLinkedList;
import linkedlist.lectures.RemoveDuplicatesFromSortedSinglyLinkedList;
import linkedlist.lectures.RemoveLoopInLinkedList;
import linkedlist.lectures.ReverseLinkedList;
import linkedlist.lectures.ReverseLinkedListInGroupsOfSizeK;
import linkedlist.lectures.SegregateEvenAndOddNodes;
import linkedlist.lectures.SortedInsertInSinglyLinkedList;

public class SinglyLinkedList {

  public static void main(String[] args) {
    Node head = null;
    print(head);

    // InsertAtBeginningOfSinglyLinkedList
    head = InsertAtBeginningOfSinglyLinkedList.execute(head, 20);
    head = InsertAtBeginningOfSinglyLinkedList.execute(head, 10);
    print(head);

    // SortedInsertInSinglyLinkedList
    head = SortedInsertInSinglyLinkedList.insert(head, 15);
    head = SortedInsertInSinglyLinkedList.insert(head, 30);
    head = SortedInsertInSinglyLinkedList.insert(head, 35);
    head = SortedInsertInSinglyLinkedList.insert(head, 40);
    print(head);

    // MiddleOfLinkedList
    System.out.println("\nMiddle => ");
    System.out.println("Middle = " + MiddleOfLinkedList.execute(head));
    System.out.println("Middle = " + MiddleOfLinkedList.execute1(head));

    // NthNodeFromEndOfLinkedList
    System.out.println("\nNth node from end 1 => ");
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute(head, 2).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute(head, 1).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute(head, 0).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute(head, 10).data);

    System.out.println("\nNth node from end 2 => ");
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute1(head, 2).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute1(head, 1).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute1(head, 0).data);
    System.out.println("Nth Node = " + NthNodeFromEndOfLinkedList.execute1(head, 10).data);

    // ReverseLinkedList
    System.out.println("\nReverse 1 => ");
    ReverseLinkedList.execute(head);
    print(head);

    System.out.println("\nReverse 2 => ");
    head = ReverseLinkedList.execute1(head);
    print(head);

    System.out.println("\nReverse 3 => ");
    head = ReverseLinkedList.execute2(head);
    print(head);

    System.out.println("\nReverse 4 => ");
    head = ReverseLinkedList.execute3(head, null);
    print(head);

    // RemoveDuplicatesFromSortedSinglyLinkedList
    System.out.println("\nRemove duplicates => ");
    head = InsertAtBeginningOfSinglyLinkedList.execute(head, 10);
    head = InsertAtBeginningOfSinglyLinkedList.execute(head, 10);
    print(head);
    RemoveDuplicatesFromSortedSinglyLinkedList.execute(head);
    print(head);

    // ReverseLinkedListInGroupsOfSizeK
    System.out.println("\nReverse in groups of k 1 => ");
    head = ReverseLinkedListInGroupsOfSizeK.execute(head, 3);
    print(head);

    System.out.println("\nReverse in groups of k 2 => ");
    head = ReverseLinkedListInGroupsOfSizeK.execute1(head, 3);
    print(head);

    // DetectLoopInLinkedList
    // - Detect loop in a linked list
    // - First node of loop
    // - Length of loop
    head = new Node(10);
    head.next = new Node(15);
    head.next.next = new Node(20);
    head.next.next.next = new Node(25);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = head.next; // loop cannot be on the first node.

    System.out.println("\nDetect loop => ");
    System.out.println(DetectLoopInLinkedList.execute(head));
    System.out.println(DetectLoopInLinkedList.execute1(head));
    System.out.println(DetectLoopInLinkedList.execute2(head));
    System.out.println(DetectLoopInLinkedList.lengthOfLoop(head));
    System.out.println(DetectLoopInLinkedList.firstNodeOfLoop(head).data);

    // RemoveLoopInLinkedList
    System.out.println("\nDetect and remove loop => ");
    head = RemoveLoopInLinkedList.removeLoop(head);
    System.out.println(DetectLoopInLinkedList.execute(head));
    System.out.println(DetectLoopInLinkedList.lengthOfLoop(head));
    System.out.println(DetectLoopInLinkedList.firstNodeOfLoop(head).data);
    print(head);

    // DeleteNodeWithOnlyPointerGivenToIt
    System.out.println("\nDeleteNodeWithOnlyPointerGivenToIt => ");
    DeleteNodeWithOnlyPointerGivenToIt.execute(head.next.next);
    print(head);

    // SegregateEvenAndOddNodes
    head = new Node(5);
    head.next = new Node(15);
    head.next.next = new Node(20);
    head.next.next.next = new Node(25);
    head.next.next.next.next = new Node(30);
    head.next.next.next.next.next = new Node(35);
    head.next.next.next.next.next.next = new Node(40);

    System.out.println("\nSegregateEvenAndOddNodes => ");
    print(head);
    // head = SegregateEvenAndOddNodes.execute(head);
    head = SegregateEvenAndOddNodes.execute(head);
    print(head);

    // IntersectionPointOfTwoLinkedLists
    Node head1 = new Node(5);
    head1.next = new Node(15);
    head1.next.next = new Node(20);
    head1.next.next.next = new Node(25);
    head1.next.next.next.next = new Node(30);
    head1.next.next.next.next.next = new Node(35);
    head1.next.next.next.next.next.next = new Node(40);

    Node head2 = new Node(10);
    head2.next = new Node(17);
    head2.next.next = head1.next.next.next.next;

    System.out.println("\nIntersectionPointOfTwoLinkedLists => ");
    Node node = IntersectionPointOfTwoLinkedLists.execute(head1, head2);
    System.out.println("[" + node.data + "]");
    node = IntersectionPointOfTwoLinkedLists.execute1(head1, head2);
    System.out.println("[" + node.data + "]");

    // PairwiseSwapNodesOfLinkedList
    System.out.println("\nPairwiseSwapNodesOfLinkedList => ");
    print(head);
    head = PairwiseSwapNodesOfLinkedList.execute(head);
    print(head);
    head = PairwiseSwapNodesOfLinkedList.execute1(head);
    print(head);

    // LRUCache
    System.out.println("\nLRUCache => ");
    LRUCache cache = new LRUCache(5);
    cache.set(1, 100);
    cache.set(2, 200);
    cache.set(3, 300);
    cache.print();

    System.out.println(cache.get(5));
    System.out.println(cache.get(2));
    cache.print();

    cache.set(4, 400);
    cache.set(5, 500);
    cache.print();

    System.out.println(cache.get(4));
    cache.print();

    cache.set(6, 600);
    cache.print();

    // MergeTwoSortedLInkedLists
    head1 = new Node(5);
    head1.next = new Node(15);
    head1.next.next = new Node(25);
    head1.next.next.next = new Node(35);

    head2 = new Node(10);
    head2.next = new Node(20);
    head2.next.next = new Node(30);
    head2.next.next.next = new Node(40);

    System.out.println("\nMergeTwoSortedLInkedLists => ");
    head = MergeTwoSortedLInkedLists.execute(head1, head2);
    print(head);

    // PalindromeLinkedList
    head1 = new Node(5);
    head1.next = new Node(15);
    head1.next.next = new Node(25);
    head1.next.next.next = new Node(35);
    head1.next.next.next.next = new Node(25);
    head1.next.next.next.next.next = new Node(15);
    head1.next.next.next.next.next.next = new Node(5);

    System.out.println("\nPalindromeLinkedList => ");
    print(head1);
    boolean palindrome = PalindromeLinkedList.execute(head1);
    System.out.println(palindrome);
    print(head1);
  }

  public static void print(Node head) {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    while (head != null) {
      System.out.print("[" + head.data + "]" + " → ");
      head = head.next;
    }
    System.out.println("[X]");
  }

  public static class Node {

    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
