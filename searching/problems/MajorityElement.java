package searching.problems;

public class MajorityElement {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 1, 3, 3, 2};
    System.out.println(majorityElement(arr, arr.length));
  }

  private static int majorityElement(int[] a, int size) {
    int index = 0;
    int count = 1;

    for (int i = 0; i < size; i++) {
      if (a[i] == a[index]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        index = i;
        count = 1;
      }
    }

    count = 0;
    for (int i = 0; i < size; i++) {
      if (a[i] == a[index]) {
        count++;
      }
    }

    if (count > size / 2) {
      return a[index];
    } else {
      return -1;
    }
  }
}
