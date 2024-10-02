package recursion;

public class RecursionRunner {

  public static void main(String[] args) {
    System.out.println(maximumCuts(10, 9, 7, 11));
  }

  private static int maximumCuts(int n, int a, int b, int c) {
    if (n == 0) {
      return 0;
    }

    if (n < 0) {
      return -1;
    }

    int res = Math.max(Math.max(maximumCuts(n - a, a, b, c), maximumCuts(n - b, a, b, c)), maximumCuts(n - c, a, b, c));
    if (res < 0) {
      return -1;
    }

    return res + 1;
  }
}
