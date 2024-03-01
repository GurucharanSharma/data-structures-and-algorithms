package array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = new int[] { 30, 7, 6, 5, 10 };

        // Print the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Reverse the array
        reverseArray(array);
        System.out.println();

        // Print reversed array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
    }
}
