package queue.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateBinaryNumbers {

  public static void main(String[] args) {
    int N = 2;

    System.out.println(generate(N));
  }

  //Function to generate binary numbers from 1 to N using a queue.
  static ArrayList<String> generate(int N) {
    ArrayList<String> list = new ArrayList<>();
    Queue<String> queue = new ArrayDeque<>();
    queue.add("1");
    queue.add("10");

    for (int i = 0; i < N; i++) {
      String num = String.valueOf(queue.poll());
      list.add(num);

      if (!num.equals("1")) {
        queue.add(num + "0");
      }

      queue.add(num + "1");
    }

    return list;
  }
}
