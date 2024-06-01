package array.lectures;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 4, 0, 0, 3, 10, 5 };
        System.out.println(hasSubarrayWithGivenSum(array, 7));
    }

    static boolean hasSubarrayWithGivenSum(int[] array, int givenSum) {
        int start = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            while (sum > givenSum) {
                sum = sum - array[start++];
            }

            if (sum == givenSum)
                return true;
        }

        return false;
    }
}
