package stack.lectures;

import java.util.Stack;

public class BalancedParenthesis {

  public static boolean execute(String expr) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expr.length(); i++) {
      if (expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '[') {
        stack.push(expr.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        } else if (!matching(stack.peek(), expr.charAt(i))) {
          return false;
        }

        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  private static boolean matching(char a, char b) {
    return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
  }
}
