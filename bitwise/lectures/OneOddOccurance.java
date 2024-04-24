package bitwise.lectures;

/**
 * Find a number that occurs odd number of times in a given array of Integers.
 */
public class OneOddOccurance {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 3, 3, 4, 4, 6};

        System.out.println(findOddOccurence(arr));
    }

    static int findOddOccurence(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i]; // Bitwise XOR
            System.out.println(res);
        }

        return res;
    }
}
