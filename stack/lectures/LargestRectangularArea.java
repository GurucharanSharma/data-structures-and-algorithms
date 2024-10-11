package stack.lectures;

import java.util.List;
import java.util.Stack;

public class LargestRectangularArea {

  public static int execute(int[] hist) {
    List<Integer> pse = PreviousSmallerElement.execute(hist);
    List<Integer> nse = NextSmallerElement.execute(hist);

    System.out.println(pse);
    System.out.println(nse);

    int res = 0;
    for (int i = 0; i < hist.length; i++) {
      int area = hist[i] * (nse.get(i) - pse.get(i) + 1);
      res = Math.max(res, area);
    }

    return res;
  }

  public static int execute1(int[] hist) {
    int res = 0;
    for (int i = 0; i < hist.length; i++) {
      int pse = 0;
      int nse = hist.length - 1;

      for (int j = i - 1; j >= 0; j--) {
        if (hist[j] < hist[i]) {
          pse = j + 1;
          break;
        }
      }

      for (int j = i + 1; j < hist.length; j++) {
        if (hist[j] < hist[i]) {
          nse = j - 1;
          break;
        }
      }

      int area = hist[i] * (nse - pse + 1);
      res = Math.max(area, res);
    }

    return res;
  }

  // Naive approach
  public static int execute2(int[] hist) {
    int res = 0;
    for (int i = 0; i < hist.length; i++) {
      int area = hist[i];

      for (int j = i - 1; j >= 0; j--) {
        if (hist[j] >= hist[i]) {
          area += hist[i];
        } else {
          break;
        }
      }

      for (int j = i + 1; j < hist.length; j++) {
        if (hist[j] >= hist[i]) {
          area += hist[i];
        } else {
          break;
        }
      }

      res = Math.max(area, res);
    }

    return res;
  }

  // Better solution
  private static int execute3(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] pse = new int[arr.length];
    int[] nse = new int[arr.length];

    pse[0] = -1;
    stack.push(0);
    for (int i = 1; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }

      pse[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      stack.pop();
    }

    nse[arr.length - 1] = arr.length;
    stack.push(arr.length - 1);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }

      nse[i] = stack.isEmpty() ? arr.length : stack.peek();
      stack.push(i);
    }

    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int area = arr[i];
      area += (i - pse[i] - 1) * arr[i];
      area += (nse[i] - i - 1) * arr[i];
      res = Math.max(res, area);
    }

    return res;
  }
}