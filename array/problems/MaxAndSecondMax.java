package array.problems;

import java.util.ArrayList;

public class MaxAndSecondMax {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(largestAndSecondLargest(arr.length, arr));
    }

    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int[] arr) {
        int max = arr[0];
        int sMax = -1;

        for (int i = 1; i < sizeOfArray; i++) {
            if (arr[i] > max) {
                sMax = max;
                max = arr[i];
            } else if (arr[i] != max && (sMax == -1 || arr[i] > sMax)) {
                sMax = arr[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(max);
        list.add(sMax);

        return list;
    }
}
