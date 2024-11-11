package recursion.problems;

public class PowerOfNumbers {

  private static final long MODULO = 1000000007;

  public static void main(String[] args) {
    int N = 12;
    int R = 21;

    System.out.println(power(N, R));
  }

  // Approach 1
  private static long power(int N, int R) {
    // Base cases
    if (N == 0) {
      return 0;
    }

    // power zero mean answer is 1
    if (R == 0) {
      return 1;
    }

    // If R is even
    long res;

    if (R % 2 == 0) {
      // finding r/2 power as power is even then storing answer in y and if power is even like 2^4 we can simply do (2^2)*(2^2)
      res = power(N, R / 2);
      res = (res * res) % 1000000007;
    }

    // If R is odd
    else {
      res = N % 1000000007;
      // reduce the power by 1 to make it even. The reducing power by one can be done if we take one n out. Like 2^3 can be written as 2*(2^2)
      res = (res * power(N, R - 1) % 1000000007) % 1000000007;
    }
    // finally return the answer (y+mod)%mod = (y%mod+mod%mod)%mod = (y%mod)%mod
    return ((res + 1000000007) % 1000000007);
  }

  // Approach 2
  private static long power1(int N, int R) {
    if (N == 0) {
      return 0;
    }

    if (R == 0) {
      return 1;
    }

    long res = 1;
    if (R % 2 == 0) {
      res = power1(N, R / 2);
      res = (res * res) % 1000000007;
    } else {
      res = ((N % 1000000007) * (power1(N, R - 1) % 1000000007)) % 1000000007;
    }

    return res % 1000000007;
  }
}
