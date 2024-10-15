package mathematics.problems;

public class Exactly3Divisors {

  public static void main(String[] args) {
    int n = 10000;

    System.out.println(exactly3Divisors(n));
    System.out.println();
    System.out.println(exactly3Divisors1(n));
  }

  // Efficient approach
  public static int exactly3Divisors(int N) {
    int count = 0;

    for (int i = 1; (i * i) <= N; i++) {
      if (isPrime(i)) {
        System.out.print((i * i) + " ");
        count++;
      }
    }
    System.out.println();

    return count;
  }

  public static boolean isPrime(int N) {
    if (N == 2 || N == 3 || N == 5) {
      return true;
    }
    if (N == 1 || N % 2 == 0 || N % 3 == 0) {
      return false;
    }

    for (int i = 5; i <= Math.sqrt(N); i = i + 6) {
      if (N % i == 0) {
        return false;
      }
      if (N % (i + 2) == 0) {
        return false;
      }
    }

    return true;
  }

  // Naive approach
  private static int exactly3Divisors1(int N) {
    int count = 0;
    for (int i = 4; i <= N; i++) {
      if (divisors(i)) {
        count++;
      }
    }

    return count;
  }

  private static boolean divisors(int N) {
    if (N == 0 || N == 1) {
      return false;
    }

    int count = 0;
    for (int i = 1; i <= Math.sqrt(N); i++) {
      if (N % i == 0) {
        count++;

        if (N / i != i && N % (N / i) == 0) {
          count++;
        }
      }

      if (count > 3) {
        return false;
      }
    }

    return count == 3;
  }
}
