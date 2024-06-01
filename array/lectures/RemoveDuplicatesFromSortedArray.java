package array.lectures;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] { 10, 10, 10, 10, 10, 10 };

        // Print the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Remove duplicates from the array and get the new size
        int size = removeDuplicates(array);
        System.out.println();

        // Unique array
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static int removeDuplicates(int[] array) {
        int size = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                array[size++] = array[i];
            }
        }

        return size;
    }
}
