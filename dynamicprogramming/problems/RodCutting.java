package dynamicprogramming.problems;

public class RodCutting {

    public int cutRod(int[] price) {
        int n = price.length;
        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {          // Assume i represents an array of lengths from 1 to N
            for (int j = 1; j <= n; j++) {      // Assume j represents the total length of the rod i.e. N
                if (i <= j) {
                    table[i][j] = Math.max(price[i - 1] + table[i][j - i], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][n];
    }
}
