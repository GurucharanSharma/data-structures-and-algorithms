package bitwise.problems;

public class MinimumBitFlips {

    public static int minBitFlips(int start, int goal) {
        if (start == goal) {
            return 0;
        }

        int count = 0;
        while (start > 0 && goal > 0) {
            if (((start & 1) ^ (goal & 1)) == 1) {
                count++;
            }

            start = start >> 1;
            goal = goal >> 1;
        }

        while (start > 0) {
            if ((start & 1) == 1) {
                count++;
            }

            start = start >> 1;
        }

        while (goal > 0) {
            if ((goal & 1) == 1) {
                count++;
            }

            goal = goal >> 1;
        }

        return count;
    }
}
