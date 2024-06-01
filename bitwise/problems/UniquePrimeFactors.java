package bitwise.problems;

import java.util.ArrayList;

public class UniquePrimeFactors {

    /**
     * Naive approach
     */
    public static int[] AllPrimeFactors(int N) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (isPrime(i)) {
                    list.add(i);
                }

                if ((N / i) != i && isPrime(N / i)) {
                    list.add(N / i);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPrime(int N) {
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

    /**
     * Efficient approach
     */
    public static int[] AllPrimeFactors1(int N) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                list.add(i);
                while (N % i == 0) {
                    N = N / i;
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
