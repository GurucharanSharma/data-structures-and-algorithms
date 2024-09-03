package array.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

  public static void main(String[] args) {
//    int n = 16;
//    int n = 10;
    int n = 0;

    System.out.println(pattern(n));
  }

  public static List<Integer> pattern(int N) {
    List<Integer> list = new ArrayList<>();

    if (N <= 0) {
      list.add(N);
    } else {
      printPattern(list, N, N, false);
    }

    return list;
  }

  static void printPattern(List<Integer> list, int N, int n, boolean flip) {
    list.add(n);

    flip = n <= 0 || flip;
    n = flip ? n + 5 : n - 5;

    if (n == N) {
      list.add(n);
      return;
    }

    printPattern(list, N, n, flip);
  }
}
