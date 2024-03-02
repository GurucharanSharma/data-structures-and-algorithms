package sorting.lectures;

public class MergeTwoSortedArrays {

  public static void main(String[] args) {

    int[] arr1 = {10, 20, 35};
    int[] arr2 = {5, 50, 50};

    merge(arr1, arr2);
  }

  private static void merge(int[] arr1, int[] arr2) {

    int i = 0;
    int j = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] <= arr2[j]) {
        System.out.print(arr1[i] + " ");
        i++;
      } else {
        System.out.print(arr2[j] + " ");
        j++;
      }
    }

    while (i < arr1.length) {
      System.out.print(arr1[i++] + " ");
    }

    while (j < arr2.length) {
      System.out.print(arr2[j++] + " ");
    }
  }
}
