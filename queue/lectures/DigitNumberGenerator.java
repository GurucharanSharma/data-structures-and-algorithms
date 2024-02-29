package queue.lectures;

import java.util.LinkedList;
import java.util.Queue;

public class DigitNumberGenerator {

  public static void execute(int k, int[] arr) {
    Queue<String> queue = new LinkedList<>();
    for (int i: arr) {
      queue.offer(String.valueOf(i));
    }

    for (int i = 0; i < k; i++) {
      String str = queue.poll();
      System.out.println(str);

      for (int j: arr) {
        queue.offer(str + j);
      }
    }
  }
}
