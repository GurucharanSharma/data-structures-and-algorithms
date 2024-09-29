package hashing;

/**
 * Practice Session
 */
public class HashingRunner {

  public static void main(String[] args) {
//    int[] arr = {9, 1, 1, 1, 2, 3, 4, 1, 1, 3, 4, 5, 5, 6, 7, 1, 2, 3, 4, 5};
//    int[] arr = {1, 2, 3, 4, 5, 6, 7};
//    int[] arr = {1, 1, 1, 1, 1, 1, 6};
    int[] arr = {1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3};

    int[] brr = {1, 2, 1, 1, 2, 2};

    intersection(arr, brr);
  }

  private static void intersection(int[] arr, int[] brr) {
    for (int i = 0; i < arr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          break;
        }
      }

      if (flag) {
        continue;
      }

      for (int j = 0; j < brr.length; j++) {
        if (arr[i] == brr[j]) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.print(arr[i] + " ");
      }
    }

    for (int i = 0; i < brr.length; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (brr[i] == brr[j]) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.print(brr[i] + " ");
      }
    }
  }
}
