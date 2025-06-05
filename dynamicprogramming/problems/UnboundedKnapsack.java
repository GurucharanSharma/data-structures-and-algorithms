package dynamicprogramming.problems;

public class UnboundedKnapsack {

    public int knapSack(int[] val, int[] wt, int capacity) {
        if (wt.length != val.length) {
            return 0;
        }

        int n = wt.length;
        int[][] table = new int[n + 1][capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            table[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (wt[i - 1] <= j) {
                    table[i][j] = Math.max(val[i - 1] + table[i][j - wt[i - 1]], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][capacity];
    }
}
