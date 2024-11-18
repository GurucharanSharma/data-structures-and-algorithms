package array.lectures;

public class MajorityElement {

  public static void main(String[] args) {
    int[] array = {8, 8, 6, 6, 6, 7, 6};

    System.out.println(getMajorityElement(array));
    System.out.println();
    System.out.println(getMajorityElement1(array));
  }

  private static int getMajorityElement(int[] arr) {
    if (arr.length == 0) {
      return -1;
    }

    int num = -1;
    for (int i = 0; i <= arr.length / 2; i++) {
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] == arr[i]) {
          count++;
        }
      }

      if (count > arr.length / 2) {
        num = arr[i];
        break;
      }
    }

    return num;
  }

  static int getMajorityElement1(int[] array) {
    int n = array.length;
    int count = 1;
    int res = 0;

    for (int i = 1; i < n; i++) {
      if (array[i] == array[res]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        res = i;
        count = 1;
      }
    }

    count = 0;
    for (int i = 0; i < n; i++) {
      if (array[i] == array[res]) {
        count++;
      }
    }

    if (count > n / 2) {
      return array[res];
    } else {
      return -1;
    }
  }
}
