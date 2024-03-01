package array;

public class CheckSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] { 7, 20, 30, 10 };

        System.out.println(isSorted(array));
    }

    static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return false;
        }

        return true;
    }
}
