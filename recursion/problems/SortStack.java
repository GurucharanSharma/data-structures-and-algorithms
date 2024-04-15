package recursion.problems;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int item = stack.pop();
        sortStack(stack);
        insert(stack, item);
    }

    private static void insert(Stack<Integer> stack, int item) {
        if (stack.isEmpty() || item > stack.peek()) {
            stack.push(item);
        } else {
            int num = stack.pop();
            insert(stack, item);
            stack.push(num);
        }
    }
}
