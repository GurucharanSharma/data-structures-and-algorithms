package array;

public class FrequenciesInASortedArray {
    public static void main(String[] args) {
        int[] array = new int[] { 8, 8, 8, 5, 5, 5, 0, 0, 10, 20, 20, 20, 20 };
        printFrequencies(array);
    }

    static void printFrequencies(int[] array) {
        int i = 1;
        int n = array.length;

        while (i < n) {
            int freq = 1;
            while (i < n && array[i] == array[i - 1]) {
                freq++;
                i++;
            }

            System.out.println(array[i - 1] + " : " + freq);
            i++;
        }

        if (n == 1 || array[n - 1] != array[n - 2])
            System.out.println(array[i - 1] + " : " + 1);
    }
}
