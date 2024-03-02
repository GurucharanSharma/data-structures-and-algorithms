package sorting.lectures;

public class IntersectionOfTwoSortedArrays {

  public static void main(String[] args) {

    int[] arr = {10, 20, 20, 40, 60};
    int[] brr = {2, 20, 20, 20, 40};

    intersection(arr, brr);
  }

  private static void intersection(int[] arr, int[] brr) {
    int i = 0;
    int j = 0;
    while (i < arr.length && j < brr.length) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        i++;
        continue;
      }

      if (arr[i] < brr[j]) {
        i++;
      } else if (arr[i] > brr[j]) {
        j++;
      } else {
        System.out.print(arr[i] + " ");
        i++;
        j++;
      }
    }
  }
}
