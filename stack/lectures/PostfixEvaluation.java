package stack.lectures;

import java.util.Stack;

public class PostfixEvaluation {
    public static Integer execute(String expr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // converting the character to int
            } else {
                int left = stack.pop();
                int right = stack.pop();

                switch (ch) {
                    case '*':
                        stack.push(right * left);
                        break;
                    case '/':
                        stack.push(right / left);
                        break;
                    case '+':
                        stack.push(right + left);
                        break;
                    case '-':
                        stack.push(right - left);
                        break;
                    case '^':
                        stack.push((int) Math.pow(right, left));
                    default:
                        System.out.println("Invalid operator");
                        break;
                }
            }
        }

        return stack.pop();
    }
}
