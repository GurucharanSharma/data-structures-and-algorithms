package bitwise.problems;

/**
 * Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are
 * set in the binary representation.
 */
public class SparseNumber {

    //Function to check if the number is sparse or not.
    public static boolean isSparse(int n) {
        boolean flag = false;

        while (n > 0) {
            int bit = n % 2;
            if (flag) {
                if (bit == 1) {
                    return false;
                } else {
                    flag = false;
                }
            } else {
                flag = bit == 1;
            }

            n = n / 2;
        }

        return flag;
    }
}
