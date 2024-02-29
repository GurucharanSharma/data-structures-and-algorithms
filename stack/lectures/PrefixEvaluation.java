package stack.lectures;

import java.util.Stack;

public class PrefixEvaluation {
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
