package mathematics.lectures;

/**
 * <b>List the number of trailing zeros in the factorial of the number N</b>
 * <p>
 * The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. Our task is done if we can
 * count the number of 5s and 2s. Consider the following examples:
 * <p>
 * n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So a count of trailing 0s is 1. <br>n = 11: There are two 5s and eight 2s in
 * prime factors of 11! (2 8 * 34 * 52 * 7). So the count of trailing 0s is 2. <br>We can easily observe that the number of 2s in prime factors is always
 * more than or equal to the number of 5s. So if we count 5s in prime factors, we are done.
 * <p>
 * Following is the summarized formula for counting trailing 0s:
 * <p>
 * Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */
public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        System.out.println(getTrailingZeros(100));
    }

    public static int getTrailingZeros(int n) {
        int count = 0;

        for (int i = 5; (n / i) >= 1; i = i * 5) {
            count = count + (n / i);
        }

        return count;
    }
}