package bitwise.lectures;

public class TwoOddOccurrence {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 10, 6, 10, 6, 3, 3, 6, 10, 5, 7};

        findTwoOddOccurrence(arr);
        System.out.println();

        findTwoOffOccurrence1(arr);
        System.out.println();
    }

    /**
     * Approach 1: Naive
     */
    private static void findTwoOffOccurrence1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count % 2 != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * Approach 2: Efficient
     */
    static void findTwoOddOccurrence(int[] arr) {
        int xor = 0;

        // The code first initializes a variable xor to 0.
        //It then iterates through all elements of the array.
        //For each element, it performs bitwise XOR (^) operation with xor.
        // This results in xor containing the XOR of all elements in the array.
        // Since XORing a number with itself results in 0, the elements occurring
        // an even number of times cancel out, leaving only the elements occurring an odd number of times.
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        int num1 = 0;
        int num2 = 0;

        // After XORing all elements, xor now contains the XOR of the two integers occurring an odd number of times.
        // To isolate the rightmost (least significant) set bit of xor, the code computes lsbNumber as xor & ~(xor - 1).
        // This operation effectively gives us a number with only the rightmost set bit of xor set to 1.
        int lsbNumber = xor & ~(xor - 1); // Gives only the last set bit of number "xor"

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & lsbNumber) == 0) {
                num1 = num1 ^ arr[i];
            } else {
                num2 = num2 ^ arr[i];
            }
        }

        System.out.println(num1 + " " + num2);
    }
}
