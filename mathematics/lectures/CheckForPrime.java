package mathematics.lectures;

public class CheckForPrime {

    public static boolean checkForPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        if (n == 2 || n == 3 || n == 5 || n == 7) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
            return false;
        }

        // because if a number is expressed as n = xy and any of the x or y is greater than the root of n,
        // the other must be less than the root value
        for (int i = 11; i < Math.sqrt(n); i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
