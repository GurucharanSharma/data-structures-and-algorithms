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
                while (!stack.isEmpty() && (precedence(ch) < precedence(stack.peek()))) {
                    builder.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
