package array.lectures;

public class MaximumConsecutive1s {
    public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(maxConsecutiveCount(array));
        System.out.println(maxConsecutiveCount_1(array));
    }

    static int maxConsecutiveCount(int[] array) {
        int count = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int currCount = 0;
            while (i < n && array[i] == 1) {
                currCount++;
                i++;
            }

            count = Math.max(count, currCount);
        }

        return count;
    }

    static int maxConsecutiveCount_1(int[] array) {
        int count = 0;
        int currCount = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                currCount++;
                count = Math.max(count, currCount);
            } else if (array[i] == 0) {
                currCount = 0;
            }
        }

        return count;
    }
}
