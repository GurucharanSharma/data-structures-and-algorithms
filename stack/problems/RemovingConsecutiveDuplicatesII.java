package stack.problems;

import java.util.Stack;

public class RemovingConsecutiveDuplicatesII {

  public static void main(String[] args) {
//    String str = "aaabbaaccd";
    String str = "aaaa";

    System.out.println(removePair(str));
  }

  //Function to remove pair of duplicates from given string using Stack.
  public static String removePair(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (stack.isEmpty() || stack.peek() != ch) {
        stack.push(ch);
      } else {
        stack.pop();
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.insert(0, stack.pop());
    }

    return builder.toString();
  }
}
