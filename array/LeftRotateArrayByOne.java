package array;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] array = new int[] { 8, 5, 0, 10, 0, 20 };

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        leftRotateArrayByOne(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void leftRotateArrayByOne(int[] array) {
        int firstElement = array[0];

        int i = 0;
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = firstElement;
    }
}
