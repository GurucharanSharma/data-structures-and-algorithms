package mathematics.lectures;

public class PrimeFactors {

    public static void main(String[] args) {
        int n = 780;
        System.out.println("Prime Factors 1: ");
        primeFactors_1(n);

        System.out.println("Prime Factors 2: ");
        primeFactors_2(n);

        System.out.println("Prime Factors 3: ");
        primeFactors_3(n);

        System.out.println("Prime Factors 4: ");
        primeFactors_4(n);
    }

    /**
     * Naive approach 1
     */
    public static void primeFactors_1(int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }

        if (n > 3) {
            System.out.println(n);
        }
    }

    /**
     * Naive approach 2
     */
    public static void primeFactors_2(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }

        System.out.println();
    }

    /**
     * Naive approach 3
     */
    public static void primeFactors_3(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }

        if (n > 3) {
            System.out.println(n);
        }
    }

    /**
     * Efficient approach
     */
    public static void primeFactors_4(int n) {
        if (n <= 1) {
            return;
        }

        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n = n / 2;
        }

        while (n % 3 == 0) {
            System.out.print(3 + " ");
            n = n / 3;
        }

        while (n % 5 == 0) {
            System.out.print(5 + " ");
            n = n / 5;
        }

        while (n % 7 == 0) {
            System.out.print(7 + " ");
            n = n / 7;
        }

        for (int i = 11; i <= Math.sqrt(n); i = i + 6) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }

            while (n % (i + 2) == 0) {
                System.out.print((i + 2) + " ");
                n = n / (i + 2);
            }
        }

        if (n > 3) {
            System.out.println(n);
        }
    }

}