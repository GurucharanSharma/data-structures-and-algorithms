package array.lectures;

public class MinimumGroupFlipsToMakeSame {

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 0, 0, 0, 1, 1};
        System.out.println(getMinimumGroupFlips(array));
    }

    /**
     * An Efficient Solution is based on the below facts :
     * <ul>
     * <li>There are only two types of groups (groups of 0s and groups of 1s).</li>
     * <li>Either the counts of both groups are same or the difference between counts
     * is at most 1. For example, in {1, 1, 0, 1, 0, 0} there are two groups of 0s and two groups of 1s.  In example, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
     * count of groups of 1 is one more than the counts of 0s.</li>
     * </ul>
     * <p>
     * Time Complexity:  O(n) <br>
     * Auxiliary Space:  O(1)
     * </p>
     */
    static int getMinimumGroupFlips(int[] array) {
        int first = array[0];
        int groupFlipCount = 0;

        // We are always checking the first group because if the array ends in first group elements, then the second group flips
        // would be minimum. If the array ends with the second group elements they would be same in worst case. In either case,
        // flipping the second group gives the minimum number of flips.
        for (int i = 1; i < array.length; i++) {
            boolean isFlipped = false;
            while (i < array.length && array[i] != first) {
                isFlipped = true;
                System.out.print(i + " ");
                array[i] = array[i] == 0 ? 1 : 0;
                i++;
            }

            if (isFlipped) {
                groupFlipCount++;
                System.out.println();
            }
        }

        return groupFlipCount;
    }
}
