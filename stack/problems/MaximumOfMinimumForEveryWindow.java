package stack.problems;

import java.util.Arrays;
import java.util.Stack;

public class MaximumOfMinimumForEveryWindow {

  public static void main(String[] args) {
//    int[] arr = {10, 20, 30, 50, 10, 70, 30};
    int[] arr = {10, 20, 30};

    System.out.println(Arrays.toString(maxOfMin(arr, arr.length)));
    System.out.println();
    System.out.println(Arrays.toString(maxOfMin1(arr, arr.length)));
  }

  //Function to find maximum of minimums of every window size.
  private static int[] maxOfMin(int[] arr, int n) {
    int[] maxOfWin = new int[n];
    int index = 0;

    for (int win = 1; win <= n; win++) {
      int max = Integer.MIN_VALUE;

      for (int i = 0; i <= arr.length - win; i++) {
        int min = arr[i];

        for (int j = 1; j < win; j++) {
          min = Math.min(min, arr[i + j]);
        }

        max = Math.max(max, min);
      }

      maxOfWin[index++] = max;
    }

    return maxOfWin;
  }

  //Function to find maximum of minimums of every window size.
  private static int[] maxOfMin1(int[] arr, int n) {
    Stack<Integer> stack = new Stack<>();
    int[] left = new int[n];
    int[] right = new int[n];

    for (int i = 0; i < n; i++) {
      while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }

      left[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }

    while (!stack.empty()) {
      stack.pop();
    }

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }

      right[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int len = right[i] - left[i] - 2;
      ans[len] = Math.max(ans[len], arr[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      ans[i] = Math.max(ans[i], ans[i + 1]);
    }

    return ans;
  }
}
