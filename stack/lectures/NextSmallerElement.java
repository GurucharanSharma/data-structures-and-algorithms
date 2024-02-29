package stack.lectures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {
    public static List<Integer> execute(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            list.add(stack.isEmpty() ? arr.length - 1 : stack.peek() - 1); // The limit is one before the element that is smaller
            stack.push(i);
        }

        Collections.reverse(list);
        return list;
    }
}
