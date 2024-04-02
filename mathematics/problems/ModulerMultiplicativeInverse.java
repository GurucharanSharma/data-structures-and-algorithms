package mathematics.problems;

public class ModulerMultiplicativeInverse {

    public int modInverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if (((a % m) * (i % m)) % m == 1) {
                return i;
            }
        }

        return -1;
    }
}
