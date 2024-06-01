package array.lectures;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] array = new int[]{-5, 1, -2, 3, -1, 2, -2};
        System.out.println(getMaximumSubArraySum(array));
    }

    static int getMaximumSubArraySum(int[] array) {
        int res = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i] + max, array[i]);
            res = Math.max(max, res);
        }

        return res;
    }
}
