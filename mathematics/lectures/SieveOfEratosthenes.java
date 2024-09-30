package mathematics.lectures;

/**
 * List all prime number less than the number N
 */
public class SieveOfEratosthenes {

  public static void main(String[] args) {
    int n = 16;

    sieve_1(n);
    System.out.println();
    sieve_2(n);
  }

  public static void sieve_1(int n) {
    boolean[] primeArray = new boolean[n + 1];
    for (int i = 2; i < n + 1; i++) {
      primeArray[i] = true;
    }

    // According to the algorithm we will mark all the numbers which are divisible by 2 and are greater than or
    // equal to the square of it.
    // Now we move to our next unmarked number 3 and mark all the numbers which are multiples of 3 and are greater
    // than or equal to the square of it.
    // We move to our next unmarked number 5 and mark all multiples of 5 and are greater than or equal to the
    // square of it.
    // We will continue this process till root of n.
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (isPrime(i)) {
        for (int j = 2 * i; j <= n; j = j + i) {
          primeArray[j] = false;
        }
      }
    }

    for (int i = 0; i <= n; i++) {
      if (primeArray[i]) {
        System.out.print(i + " ");
      }
    }
  }

  /**
   * Time Complexity: O(n*log(log(n)))
   * <p>
   * Auxiliary Space: O(n)
   */
  public static void sieve_2(int n) {
    boolean[] primeArray = new boolean[n + 1];
    for (int i = 2; i < n + 1; i++) {
      primeArray[i] = true;
    }

    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
//        System.out.print(i + " ");
        for (int j = i * i; j <= n; j = j + i) {
          primeArray[j] = false;
        }
      }
    }

    for (int i = 0; i <= n; i++) {
      if (primeArray[i]) {
        System.out.print(i + " ");
      }
    }
  }

  public static boolean isPrime(int N) {
    if (N == 2 || N == 3 || N == 5 || N == 7) {
      return true;
    }

    if (N == 1 || N % 2 == 0 || N % 3 == 0 || N % 5 == 0 || N % 7 == 0) {
      return false;
    }

    for (int i = 11; i <= Math.sqrt(N); i = i + 6) {
      if (N % i == 0) {
        return false;
      }
      if (N % (i + 2) == 0) {
        return false;
      }
    }

    return true;
  }
}