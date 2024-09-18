package array.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

  public static void main(String[] args) {
    int n = 16;
//    int n = 10;
//    int n = 0;
//    int n = -1;

    System.out.println(pattern(n));
    System.out.println();
    System.out.println(pattern1(n));
    System.out.println();
    System.out.println(pattern2(n));
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

  // Recursive approach
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

  // Iterative approach
  public static List<Integer> pattern1(int N) {
    if (N <= 0) {
      return List.of(N);
    }

    boolean flipped = false;
    List<Integer> list = new ArrayList<>();
    list.add(N);

    int start = N - 5;
    while (start != N) {
      list.add(start);

      if (!flipped && start <= 0) {
        flipped = true;
      }

      if (flipped) {
        start = start + 5;
      } else {
        start = start - 5;
      }
    }

    list.add(N);
    return list;
  }

  static List<Integer> pattern2(int N) {
    if (N < 0) {
      return List.of(N);
    }

    boolean flipped = false;
    List<Integer> list = new ArrayList<>();
    int start = N;

    do {
      list.add(start);
      if (!flipped && start <= 0) {
        flipped = true;
      }

      if (flipped) {
        start = start + 5;
      } else {
        start = start - 5;
      }
    } while (start != N);

    list.add(N);
    return list;
  }
}
