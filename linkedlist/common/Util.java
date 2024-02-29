package linkedlist.common;

public class Util {

  public static void print(SNode head) {
    if (head == null) {
      System.out.println("[X]");
      return;
    }

    while (head != null) {
      System.out.print(head.data + " → ");
      head = head.next;
    }
    System.out.println("[X]");
  }
}
