package stack.lectures;

import java.util.Stack;

public class PrefixEvaluation {

  public static void main(String[] args) {
//    String expr = "+9*26";
    String expr = "-+8/632";
//    String expr = "-+7*45+20";

    System.out.println(execute(expr));
  }

  public static Integer execute(String prefix) {
    Stack<Integer> stack = new Stack<>();

    for (int i = prefix.length() - 1; i >= 0; i--) {
      char ch = prefix.charAt(i);

      if (Character.isDigit(ch)) {
        stack.push(ch - '0'); // converting the character into integer
      } else {
        int left = stack.pop();
        int right = stack.pop();

        switch (ch) {
          case '*':
            stack.push(left * right);
            break;
          case '/':
            stack.push(left / right);
            break;
          case '+':
            stack.push(left + right);
            break;
          case '-':
            stack.push(left - right);
            break;
          case '^':
            stack.push((int) Math.pow(left, right));
          default:
            System.out.println("Invalid operator");
            break;
        }
      }
    }

    return stack.pop();
  }
}
