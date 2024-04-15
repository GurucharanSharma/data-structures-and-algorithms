package recursion.problems;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int item = stack.pop();
        reverseStack(stack);
        insert(stack, item);
    }

    private static void insert(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int num = stack.pop();
            insert(stack, item);
            stack.push(num);
        }
    }
}
