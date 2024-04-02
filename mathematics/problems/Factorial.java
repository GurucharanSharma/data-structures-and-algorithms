package mathematics.problems;

public class Factorial {

    public long factorial(int N) {
        long fact = 1;
        for (int i = 1; i <= N; i++) {
            fact = fact * i;
        }

        return fact;
    }
}
