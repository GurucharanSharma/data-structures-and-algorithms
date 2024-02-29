package stack.lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousSmallerElement {
    public static List<Integer> execute(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            list.add(stack.isEmpty() ? 0 : stack.peek() + 1); // The limit is one after the element that is greater
            stack.push(i);
        }

        return list;
    }
}