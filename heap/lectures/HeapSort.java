package heap.lectures;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 8, 3, 1, 9, 6, 5, 7};

        Solution solution = new Solution();

        System.out.println(Arrays.toString(arr));
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static class Solution {

        private void heapSort(int[] arr) {
            int n = arr.length;

            buildMaxHeap(arr);
            for (int i = n - 1; i >= 0; i--) {
                swap(arr, i, 0);
                maxHeapify(arr, i, 0);
            }
        }

        private void buildMaxHeap(int[] arr) {
            int n = arr.length;
            for (int i = (n - 2) / 2; i >= 0; i--) {
                maxHeapify(arr, n, i);
            }
        }

        private void maxHeapify(int[] arr, int n, int i) {
            int left = 2 * i + 1, right = 2 * i + 2;
            int index = i;

            if (left < n && arr[left] > arr[index]) {
                index = left;
            }

            if (right < n && arr[right] > arr[index]) {
                index = right;
            }

            if (index != i) {
                swap(arr, index, i);
                maxHeapify(arr, n, index);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
