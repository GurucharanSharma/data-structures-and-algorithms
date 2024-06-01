package array.lectures;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 0, 10, 0, 20};
        System.out.println(maximumProfit_1(array, 0, array.length));
        System.out.println(maximumProfit_2(array));
    }

    /**
     * Naive approach <br>
     * Time Complexity: O(n2), Trying to buy every stock and exploring all possibilities. <br>
     * Auxiliary Space: O(1)
     */
    static int maximumProfit_1(int[] price, int start, int end) {
        if (end <= start) {
            return 0;
        }

        int profit = 0;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {

                if (price[j] > price[i]) {
                    int currProfit = price[j] - price[i] + maximumProfit_1(price, start, i - 1) + maximumProfit_1(price, j + 1, end);
                    //System.out.println("price[j] = " + price[j] + " | price[i] = " + price[i] + " | currProfit = " + currProfit + " profit = " + profit);
                    profit = Math.max(profit, currProfit);
                }
            }
        }

        return profit;
    }

    /**
     * Efficient approach <br>
     * Time Complexity: O(n), Traversing over the array of size n <br>
     * Auxiliary Space: O(1)
     */
    static int maximumProfit_2(int[] price) {
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += (price[i] - price[i - 1]);
            }
        }

        return profit;
    }
}
