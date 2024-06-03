package array.lectures;

public class PrefixSum {

    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 9, 6, 5, 4};
        int[] prefixSum = getPrefixSumArray(arr);

        System.out.println(getSum(prefixSum, 1, 3));
    }

    private static int[] getPrefixSumArray(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    private static int getSum(int[] prefixSum, int l, int r) {
        return prefixSum[r] - prefixSum[l - 1];
    }
}
