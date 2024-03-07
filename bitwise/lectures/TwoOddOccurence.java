package bitwise.lectures;

public class TwoOddOccurence {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 10, 6, 10, 6, 3, 3, 6, 10, 5, 7};
        findTwoOddOccurence(arr);
    }

    static void findTwoOddOccurence(int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        int num1 = 0;
        int num2 = 0;
        int lsbNumber = xor & ~(xor - 1);

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
