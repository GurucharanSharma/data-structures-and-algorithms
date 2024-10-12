package stack.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteMidOfStack {

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    st.push(6);
    st.push(7);

    deleteMid(st, st.size());
//    deleteMid1(st, st.size());

    while (!st.empty()) {
      System.out.print(st.pop() + " ");
    }
  }

  // Function to delete middle element of a stack.
  // Approach 1: Using recursion
  private static void deleteMid(Stack<Integer> s, int sizeOfStack) {
    delete(s, sizeOfStack, 0);
  }

  private static void delete(Stack<Integer> s, int sizeOfStack, int i) {
    if (i == sizeOfStack / 2) {
      s.pop();
      return;
    }

    int data = s.pop();
    delete(s, sizeOfStack, i + 1);
    s.push(data);
  }

  private static void deleteMid1(Stack<Integer> s, int sizeOfStack) {
    List<Integer> backup = new ArrayList<>();
    while (!s.isEmpty()) {
      backup.add(s.pop());
    }

    for (int i = 0; i < backup.size(); i++) {
      if (i != sizeOfStack / 2) {
        s.push(backup.get(i));
      }
    }
  }
}
