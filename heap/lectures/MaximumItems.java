package heap.lectures;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumItems {

  public static int execute(int[] cost, int sum) {
    int res = 0;

    if (sum == 0 || cost.length == 0) {
      return res;
    }

    Arrays.sort(cost);
    for (int j : cost) {
      sum = sum - j;
      if (sum > 0) {
        res++;
      }
    }

    return res;
  }

  public static int execute1(int[] cost, int sum) {
    int res = 0;

    if (sum == 0 || cost.length == 0) {
      return res;
    }

    Queue<Integer> queue = new PriorityQueue<>();
    for (int j : cost) {
      queue.add(j);
    }

    while (!queue.isEmpty() && sum > 0) {
      sum = sum - queue.remove();
      if (sum >= 0) {
        res++;
      }
    }

    return res;
  }
}
