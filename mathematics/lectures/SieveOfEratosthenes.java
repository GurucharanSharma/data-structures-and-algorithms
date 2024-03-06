package mathematics.lectures;

import java.util.Arrays;

/**
 * List all prime number less than the number N
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 16;
        sieve_2(n);
    }

    public static void sieve_1(int n) {
        boolean[] primeArray = new boolean[n + 1];
        Arrays.fill(primeArray, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime(i)) {
                for (int j = 2 * i; j <= n; j = j + i) {
                    primeArray[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primeArray[i] == true) {
                System.out.print(i + " ");
            }
        }
    } 

    public static void sieve_2(int n) {
        boolean[] primeArray = new boolean[n + 1];
        Arrays.fill(primeArray, true);

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j = j + i) {
                    primeArray[j] = false;
                }
            }
        }
    }

    public static boolean isPrime(int N) {
        if (N == 2 || N == 3 || N == 5) return true;
        if (N == 1 || N % 2 == 0 || N % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(N); i = i + 6) {
            if (N % i == 0) return false;
            if (N % (i + 2) == 0) return false;
        }

        return true;
    }
}