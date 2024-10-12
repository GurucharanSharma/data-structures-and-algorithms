package stack.lectures;

import java.util.Stack;

public class InfixToPrefix {

  public static String execute(String expr) {
    StringBuilder builder = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = expr.length() - 1; i >= 0; i--) {
      char ch = expr.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        builder.append(ch);
      } else if (ch == ')') {
        stack.push(ch);
      } else if (ch == '(') {
        while (!stack.isEmpty() && stack.peek() != ')') {
          builder.append(stack.pop());
        }

        stack.pop();
      } else {
        // To handle the whitespaces in the input expression
        if (isOperator(ch)) {
          while (!stack.isEmpty() && (precedence(ch) < precedence(stack.peek()))) {
            builder.append(stack.pop());
          }

          stack.push(ch);
        }
      }
    }

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.reverse().toString();
  }

  private static boolean isOperator(char ch) {
    return (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-');
  }

  private static int precedence(char ch) {
    return switch (ch) {
      case '+', '-' -> 1;
      case '*', '/' -> 2;
      case '^' -> 3;
      default -> -1;
    };
  }
}
