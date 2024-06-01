package array.lectures;

public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] array = new int[] { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(getEquilibriumPoint(array));
    }

    static int getEquilibriumPoint(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println(sum);

        int prefixSum = array[0];
        int suffixSum = sum;
        for (int i = 1; i < array.length; i++) {
            System.out.println("ps = " + prefixSum + " | ss = " + suffixSum);
            prefixSum += array[i];
            suffixSum = suffixSum - array[i - 1];

            if (prefixSum == suffixSum)
                return i;

        }

        return -1;
    }
}
