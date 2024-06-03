package array.lectures;

public class EquilibriumPoint {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 2, 9, 4, 6, -4};
        System.out.println(getEquilibriumPoint(array));
    }

    private static int getEquilibriumPoint(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }

        int prefixSum = array[0];
        int suffixSum = sum;
        for (int i = 1; i < array.length; i++) {
            prefixSum += array[i];
            suffixSum = suffixSum - array[i - 1];

            if (prefixSum == suffixSum) {
                return i;
            }

        }

        return -1;
    }
}
