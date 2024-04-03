package mathematics.lectures;

public class ModularExponentiation {

    public static void main(String[] args) {
        System.out.println(modularExponentiation(5, 2, 7));
    }

    private static int modularExponentiation(int x, int n, int m) {
        if (n == 0) {
            return 1 % m;
        }

        int u = modularExponentiation(x, n / 2, m);

        if (n % 2 == 0) {
            return (u * u) % m;
        } else {
            return (u * u * x) % m;
        }
    }
}
