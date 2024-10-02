package recursion.lectures;

public class LogNBase2 {

  public static void main(String[] args) {
//    int n = 16;
    int n = 226;

    System.out.println(logNBase2(n));
  }

  private static int logNBase2(int n) {
    if (n == 1) {
      return 0;
    }

    return 1 + logNBase2(n / 2);
  }
}
