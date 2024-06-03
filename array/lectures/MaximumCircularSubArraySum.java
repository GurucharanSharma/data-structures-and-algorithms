package array.lectures;

public class MaximumCircularSubArraySum {

    public static void main(String[] args) {
        int[] array = new int[]{5, -2, 3, 4};
        System.out.println(getMaximumCircularSubArraySum_1(array));
        System.out.println(getMaximumCircularSubArraySum_2(array));
    }

    /**
     * Naive approach <br> Time Complexity: O(n2) <br> Auxiliary Space: O(1)
     */
    static int getMaximumCircularSubArraySum_1(int[] array) {
        int res = array[0];
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int currSum = array[i];
            int currMax = array[i];

            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currSum += array[index];
                currMax = Math.max(currMax, currSum);
            }

            res = Math.max(res, currMax);
        }

        return res;
    }

    /**
     * Efficient approach <br> Time Complexity: O(n), where n is the number of elements in the input array. Linear traversal of the array is needed.
     * <br> Auxiliary Space: O(1), No extra space is required.
     */
    static int getMaximumCircularSubArraySum_2(int[] array) {
        int n = array.length;
        int normalMaxSum = getMaximumSubArraySum(array);
        System.out.println("Normal max sum: " + normalMaxSum);

        if (normalMaxSum < 0) {
            return normalMaxSum;
        }

        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += array[i];
            // Simultaneously, each element of the array is negated. This transformation is necessary for finding the minimum subarray sum using getMaximumSubArraySum on the negated array.
            array[i] = -1 * array[i];
        }

        int circularMaxSum = arrSum + getMaximumSubArraySum(array);
        System.out.println("Circular max sum: " + circularMaxSum);

        return Math.max(normalMaxSum, circularMaxSum);
    }

    static int getMaximumSubArraySum(int[] array) {
        int n = array.length;
        int res = array[0];
        int currMax = array[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(array[i] + currMax, array[i]);
            res = Math.max(currMax, res);
        }

        return res;
    }
}
