package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class GoodNumbers {

    /**
     * Approach 1
     */
    public static List<Integer> goodNumbers(int a, int b, int digit) {
        List<Integer> list = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            int temp = i;
            int sum = 0;
            boolean ignore = false;
            while (temp > 0) {
                if (temp % 10 == digit) {
                    ignore = true;
                    break;
                }

                sum = sum + temp % 10;
                temp = temp / 10;
            }

            if (!ignore) {
                String str = String.valueOf(i);
                boolean isGoodNumber = true;
                int currSum = 0;
                for (int j = 0; j < str.length() - 1; j++) {
                    int num = Integer.parseInt(String.valueOf(str.charAt(j)));
                    currSum = currSum + num;
                    if (num <= sum - currSum) {
                        isGoodNumber = false;
                        break;
                    }
                }

                if (isGoodNumber) {
                    list.add(i);
                }
            }
        }

        return list;
    }

    /**
     * Approach 2
     */
    public static List<Integer> goodNumbers1(int a, int b, int digit) {
        List<Integer> list = new ArrayList<>();
        findGoodNumbers(list, a, b, digit);
        return list;
    }

    private static void findGoodNumbers(List<Integer> list, int a, int b, int digit) {
        if (a > b) {
            return;
        }

        int temp = a;
        int sum = 0;
        boolean ignore = false;
        while (temp > 0) {
            if (temp % 10 == digit) {
                ignore = true;
                break;
            }

            sum = sum + temp % 10;
            temp = temp / 10;
        }

        if (!ignore) {
            String str = String.valueOf(a);
            boolean isGoodNumber = true;
            int currSum = 0;
            for (int j = 0; j < str.length() - 1; j++) {
                int num = Integer.parseInt(String.valueOf(str.charAt(j)));
                currSum = currSum + num;
                if (num <= sum - currSum) {
                    isGoodNumber = false;
                    break;
                }
            }

            if (isGoodNumber) {
                list.add(a);
            }
        }

        findGoodNumbers(list, a + 1, b, digit);
    }

    /**
     * Approach 3
     */
    public static List<Integer> goodNumbers2(int a, int b, int digit) {
        List<Integer> ans = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            if (goodWithoutDigit(i, digit)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static boolean goodWithoutDigit(int n, int digit) {
        if (n % 10 == digit) {
            return false;
        }

        int sum = n % 10;
        n = n / 10;

        while (n > 0) {
            if (n % 10 == digit || n % 10 <= sum) {
                return false;
            }

            sum += n % 10;
            n /= 10;
        }

        return true;
    }
}
