package array.problems;

public class CheckRotatedAndSortedArray {

  public static void main(String[] args) {
//    int[] arr = {3, 4, 1, 2};
    int[] arr = {1, 2, 3};
    System.out.println(checkRotatedAndSorted(arr, arr.length));
  }

  // arr[]: input array
  // num: size of array
  // Function to check if array is sorted and rotated
  public static boolean checkRotatedAndSorted(int[] arr, int num) {
    int pivot = -1;

    if (arr[num - 1] < arr[0]) {
      for (int i = 1; i < num; i++) {
        if (arr[i] < arr[i - 1]) {
          if (pivot == -1) {
            pivot = i;
          } else {
            return false;
          }
        }
      }
    } else {
      for (int i = 1; i < num; i++) {
        if (arr[i] > arr[i - 1]) {
          if (pivot == -1) {
            pivot = i;
          } else {
            return false;
          }
        }
      }
    }

    return (pivot != -1);
  }
}
