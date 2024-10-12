package stack.lectures;

import java.util.Stack;

public class InfixToPostfix {

  public static void main(String[] args) {
    String expString = "a+b*(c^d-e)^(f+g*h)-i";       // Without whitespaces
//    String expString = "((A + B) - C * (D / E)) + F";   // With whitespaces

    System.out.println(InfixToPostfix.execute(expString));
  }

  public static String execute(String expr) {
    Stack<Character> stack = new Stack<>();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < expr.length(); i++) {
      char ch = expr.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        builder.append(ch);
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          builder.append(stack.pop());
        }

        stack.pop();
      } else {
        // To handle the whitespaces in the input expression
        if (isOperator(ch)) {
          while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
            builder.append(stack.pop());
          }

          stack.push(ch);
        }
      }
    }

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.toString();
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
