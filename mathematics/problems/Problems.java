package mathematics.problems;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        // Problems.AbsoluteValue absoluteValue = new Problems.AbsoluteValue();
        // System.out.println(absoluteValue.absolute(-32));

        // Problems.QuadraticEquationRoots rQuadraticEquationRoots = new
        // Problems.QuadraticEquationRoots();
        // System.out.println(rQuadraticEquationRoots.quadraticRoots(752, 904, 164));

        // Problems.Factorial factorial = new Problems.Factorial();
        // System.out.println(factorial.factorial(42));

        // Problems.DigitsInFactorial digitsInFactorial = new Problems.DigitsInFactorial();
        // System.out.println(digitsInFactorial.digitsInFactorial(42));

        // Problems.Exactly3Divisors exactly3Divisors = new Problems.Exactly3Divisors();
        // System.out.println(exactly3Divisors.exactly3Divisors(999999));

        // Problems.GPTerm gpTerm = new Problems.GPTerm();
        // System.out.println(gpTerm.termOfGP(2, 3, 1));

        ModulerMultiplicativeInverse modulerMultiplicativeInverse = new ModulerMultiplicativeInverse();
        System.out.println(modulerMultiplicativeInverse.modInverse(10, 17));
    }

}

class AbsoluteValue {
    public int absolute(int I) {
        return I < 0 ? (-1 * I) : I;
    }
}

class ConvertCelciusToFahrenheit {
    public double cToF(int C) {
        // °F = (°C x 1.8) + 32
        return (C * 1.8) + 32;
    }
}

class QuadraticEquationRoots {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();
        if ((b * b) - (4 * a * c) < 0) {
            roots.add(-1);
        } else {
            roots.add((int) Math.floor(((-1 * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a)));
            roots.add((int) Math.floor(((-1 * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a)));
        }

        Collections.sort(roots, Collections.reverseOrder());
        return roots;
    }
}

class Factorial {

    public long factorial(int N) {
        long fact = 1;
        for (int i = 1; i <= N; i++) {
            fact = fact * i;
        }

        return fact;
    }
}

class DigitsInFactorial {
    public int digitsInFactorial(long N) {
        double sum = 0.0;
        for (int j = 1; j <= N; j++) {
            // sum stores log(j) + log(j+1) + ... + log(N)
            sum += Math.log10(j);

        }
        return (int) (1 + Math.floor(sum));
    }
}

class Exactly3Divisors {

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
        if (N == 2 || N == 3 || N == 5)
            return true;
        if (N == 1 || N % 2 == 0 || N % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(N); i = i + 6) {
            if (N % i == 0)
                return false;
            if (N % (i + 2) == 0)
                return false;
        }

        return true;
    }
}

class GPTerm {

    public double termOfGP(int A, int B, int N) {
        return A * calculatePower(B / (double) A, N - 1);
    }

    private double calculatePower(double x, int n) {
        double result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n / 2;
        }

        return result;
    }
}

class AdditionUnderModulo {
    private static final long MODULO = 1000000007;

    public static long sumUnderModulo(long a, long b) {
        return ((a % MODULO) + (b % MODULO)) % MODULO;
    }
}

class MultiplicationUnderModulo {
    private static final long MODULO = 1000000007;

    public static long multiplicationUnderModulo(long a, long b) {
        return ((a % MODULO) * (b % MODULO)) % MODULO;
    }
}

class ModulerMultiplicativeInverse {

    public int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if (((a % m) * (i % m)) % m == 1) return i;
        }

        return -1;
    }
}