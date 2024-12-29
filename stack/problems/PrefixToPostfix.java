package stack.problems;

import java.util.Stack;

public class PrefixToPostfix {

  public static void main(String[] args) {
//    String expr = "/ * + A B - C D + E F";      // A B + C D - * E F + /
//    String expr = "- + * A B / C D + E F";      // A B * C D / + E F + -
    String expr = "+ - * + A B + C D / E F G";  // A B + C D + * E F / - G +

    System.out.println(prefixToPostfix(expr));
  }

  private static String prefixToPostfix(String expr) {
    int n = expr.length();
    Stack<String> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      char ch = expr.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else if (isOperator(ch)) {
        String op1 = stack.pop();
        String op2 = stack.pop();
        String res = op1 + op2 + ch;

        stack.push(res);
      }
    }

    return stack.pop();
  }

  private static boolean isOperator(char ch) {
    return (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-');
  }
}
