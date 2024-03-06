package mathematics.lectures;

public class CountDigits {
    public static void main(String[] args) {
        int n = 100000;
        Solution solution = new Solution();

        System.out.println(solution.countDigitsIterative(n));
        System.out.println(solution.countDigitsRecursive(n));
    }

}

class Solution {
    public int countDigitsIterative(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public int countDigitsRecursive(int n) {
        if (n/10 == 0) return 1;
        return 1 + countDigitsRecursive(n/10);
    }
}