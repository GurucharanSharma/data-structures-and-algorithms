package mathematics.problems;

public class Exactly3Divisors {

    public int exactly3Divisors(int N) {
        int count = 0;

        for (int i = 1; (i * i) <= N; i++) {
            if (isPrime(i)) {
                System.out.println("i: " + (i * i));
                count++;
            }
        }

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
}
