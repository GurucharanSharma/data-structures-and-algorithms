package bitwise.lectures;

public class PowerSet {

    public static void main(String[] args) {
        String str = "abc";
        printPowerSet(str);
    }

    static void printPowerSet(String str) {
        int n = str.length();

        // Same as doing Math.pow(2, n)
        int powSize = (1 << n);

        for (int i = 0; i < powSize; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(str.charAt(j) + " ");
                }
            }

            System.out.println();
        }
    }
}
