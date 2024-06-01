package array.lectures;

public class SecondLargestElement {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        secondLargest(array);
    }

    static void secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] != largest && (secondLargest == -1 || arr[i] > secondLargest)) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Largest: " + largest + " | Second Largest: " + secondLargest);
    }
}
