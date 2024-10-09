package recursion.lectures;

/**
 * Given a rope of length N meters, and the rope can be cut in only 3 sizes A, B and C. The task is to maximizes the number of cuts in rope. If it is
 * impossible to make cut then print the number else print -1. Examples:
 * <p>
 * Input:
 * <p>
 * N = 17, A = 10, B = 11, C = 3
 * <p>
 * Output: 3
 * <p>
 * Explanation: The maximum cut can be obtain after making 2 cut of length 3 and one cut of length 11.
 * <p>
 * Input: N = 10, A = 9, B = 7, C = 11
 * <p>
 * Output: -1
 * <p>
 * Explanation: It is impossible to make any cut so output will be -1.
 */
public class RopeCuttingProblem {

  public static void main(String[] args) {
    int n = 10;
    int a = 9;
    int b = 7;
    int c = 11;

    System.out.println(divide(n, a, b, c));
  }

  static int divide(int n, int a, int b, int c) {
    if (n == 0) {
      return 0;
    }

    if (n < 0) {
      return -1;
    }

    int res = Math.max(Math.max(divide(n - a, a, b, c), divide(n - b, a, b, c)), divide(n - c, a, b, c));

    if (res == -1) {
      return -1;
    }

    return res + 1;
  }
}
