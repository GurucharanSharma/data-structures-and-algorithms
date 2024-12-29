package stack.problems;

import java.util.Stack;

public class PrefixToInfix {

  public static void main(String[] args) {
//    String expr = "- * + A B C / D E";        // ((A + B) * C) - (D / E)
//    String expr = "+ * X + Y Z * W - U V";    // (X * (Y + Z)) + (W * (U - V))
//    String expr = "- + * + Q R S / T U V";    // (((Q + R) * S) + (T / U)) - V
    String expr = "- + M N + * O P / Q R";    // ((M + N) - ((O * P) + (Q / R)))

    System.out.println(prefixToInfix(expr));
  }

  private static String prefixToInfix(String expr) {
    int n = expr.length();
    Stack<String> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      char ch = expr.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else if (isOperator(ch)) {
        String op1 = stack.pop();
        String op2 = stack.pop();
        String res = "(" + op1 + ch + op2 + ")";

        stack.push(res);
      }
    }

    return stack.pop();
  }

  private static boolean isOperator(char ch) {
    return (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-');
  }
}
