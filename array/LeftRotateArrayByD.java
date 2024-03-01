package array;

public class LeftRotateArrayByD {
    public static void main(String[] args) {
        int[] array = new int[] {40,13,27,87,95,40,96,71,35,79,68,2,98,3,18,93,53,57,2,81,87,42,66,90,45,20,41,30,32,18,98,72,82,76,10,28,68,57,98,54,87,66,7,84,20,25,29,72,33,30,4,20,71,69,9,16,41,50,97,24,19,46,47,52,22,56,80,89,65,29,42,51,94,1,35,65,25};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        leftRotateArrayByD_2(array, 69);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void leftRotateArrayByD_1(int[] array, int d) {
        int[] temp = new int[d];
        int n = array.length;

        for (int i = 0; i < d; i++) {
            temp[i] = array[i];
        }

        for (int i = d; i < n; i++) {
            array[i - d] = array[i];
        }

        for (int i = 0; i < d; i++) {
            array[n - d + i] = temp[i];
        }
    }

    static void leftRotateArrayByD_2(int[] array, int d) {
        int n = array.length;

        reverse(array, 0, d - 1);
        reverse(array, d, n - 1);
        reverse(array, 0, n - 1);
    }

    static void reverse(int[] array, int low, int high) {
        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }
}
