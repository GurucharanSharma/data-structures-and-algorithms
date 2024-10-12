package stack.problems;

import java.util.Stack;

public class RemovingConsecutiveDuplicates {

  public static void main(String[] args) {
    String str = "aaaaaabaabccccccc";
//    String str = "abbccbcd";

    System.out.println(removeConsecutiveDuplicates(str));
    System.out.println();
    System.out.println(removeConsecutiveDuplicates1(str));
  }

  //Function to remove consecutive duplicates from given string using Stack.
  public static String removeConsecutiveDuplicates(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (stack.isEmpty()) {
        stack.push(ch);
      } else {

        if (stack.peek() != ch) {
          stack.push(ch);
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.reverse().toString();
  }

  //Function to remove consecutive duplicates from given string using Stack.
  public static String removeConsecutiveDuplicates1(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (stack.isEmpty()) {
        stack.push(ch);
      } else {

        if (stack.peek() != ch) {
          stack.push(ch);
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.insert(0, stack.pop());
    }

    return builder.toString();
  }
}
