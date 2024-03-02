package sorting.lectures;

public class UnionOfTwoSortedArrays {

  public static void main(String[] args) {

    int[] arr = {10, 20, 20, 40, 60, 60, 60, 60};
    int[] brr = {2, 20, 20, 20, 40, 40, 40};

    union(arr, brr);
  }

  private static void union(int[] arr, int[] brr) {
    int i = 0;
    int j = 0;
    while (i < arr.length && j < brr.length) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        i++;
        continue;
      }

      if (j > 0 && brr[j] == brr[j - 1]) {
        j++;
        continue;
      }

      if (arr[i] < brr[j]) {
        System.out.print(arr[i] + " ");
        i++;
      } else if (arr[i] > brr[j]) {
        System.out.print(brr[j] + " ");
        j++;
      } else {
        System.out.print(arr[i] + " ");
        i++;
        j++;
      }
    }

    while (i < arr.length) {
      if (i > 0 && arr[i] != arr[i - 1]) {
        System.out.print(arr[i] + " ");
      }
      i++;
    }

    while (j < brr.length) {
      if (j > 0 && brr[j] != brr[j - 1]) {
        System.out.print(brr[j] + " ");
      }
      j++;
    }
  }
}
