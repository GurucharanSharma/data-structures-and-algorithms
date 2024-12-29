package stack.problems;

import java.util.Stack;

public class PostfixToInfix {

  public static void main(String[] args) {
//    String expr = "A B + C D - * E F + G H - / +";    // ((A + B) * (C - D)) + ((E + F) / (G - H))
//    String expr = "A B C + * D E / -";                // (A * (B + C)) - (D / E)
//    String expr = "X Y Z + * W U V - * +";            // (X * (Y + Z)) + (W * (U - V))
//    String expr = "P Q R + S * T U / + V -";          // ((Q + R) * S) + (T / U) - V
    String expr = "M N + O P * Q R / + -";            // (M + N) - ((O * P) + (Q / R))

    System.out.println(postfixToInfix(expr));
  }

  private static String postfixToInfix(String expr) {
    int n = expr.length();
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      char ch = expr.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        if (isOperator(ch)) {
          String op1 = stack.pop();
          String op2 = stack.pop();

          String res = "(" + op2 + ch + op1 + ")";
          stack.push(res);
        }
      }
    }

    return stack.pop();
  }

  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }
}
