package dynamicprogramming.problems;

public class CoinChangeCountWays {

    /// Recursion + Memoization
    public int count1(int[] coins, int sum) {
        int n = coins.length;

        Integer[][] memory = new Integer[n + 1][sum + 1];
        return countWays(coins, sum, 0, memory);
    }

    private int countWays(int[] coins, int sum, int index, Integer[][] memory) {
        if (index == coins.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (index > coins.length || sum < 0) {
            return 0;
        }

        if (memory[index][sum] != null) {
            return memory[index][sum];
        }

        memory[index][sum] = countWays(coins, sum, index + 1, memory) + countWays(coins, sum - coins[index], index, memory);
        return memory[index][sum];
    }

    /// Tabulation
    public int count2(int[] coins, int sum) {
        int n = coins.length;
        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            table[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] <= j) {
                    table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[n][sum];
    }
}
