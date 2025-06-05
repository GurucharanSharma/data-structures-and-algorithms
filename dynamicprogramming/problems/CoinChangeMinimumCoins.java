package dynamicprogramming.problems;

public class CoinChangeMinimumCoins {

    // Recursion + Memoization
    public int minCoins1(int[] coins, int sum) {
        int n = coins.length;
        Integer[][] table = new Integer[n + 1][sum + 1];

        int res = minCoins(coins, sum, 0, table);
        if (res == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return res;
        }
    }

    private int minCoins(int[] coins, int sum, int index, Integer[][] table) {
        if (index == coins.length) {
            if (sum == 0) {
                return 0;
            } else {
                return Integer.MAX_VALUE - 1;
            }
        }

        if (index > coins.length || sum < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (table[index][sum] != null) {
            return table[index][sum];
        }

        table[index][sum] = Math.min(1 + minCoins(coins, sum - coins[index], index, table), minCoins(coins, sum, index + 1, table));
        return table[index][sum];
    }

    // Tabulation
    public int minCoins2(int[] coins, int sum) {
        int n = coins.length;
        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = Integer.MAX_VALUE - 1;

            if (i % coins[0] == 0) {
                table[1][i] = i / coins[0];
            } else {
                table[1][i] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    table[i][j] = Math.min(table[i - 1][j], 1 + table[i][j - coins[i - 1]]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
