package searching.lectures;

public class MissingNumber {

  public static void main(String[] args) {

    int[] arr = new int[]{9, 1, 5, 7, 8, 6, 2, 4};
    int[] input = new int[arr.length + 1];

    System.arraycopy(arr, 0, input, 0, arr.length);

    System.out.println(missingNumberHashing(input));
    System.out.println(missingNumberSum(input));
    System.out.println(missingNumberXor(input));
  }

  private static int missingNumberHashing(int[] arr) {
    int[] hash = new int[arr.length + 1];

    for (int j : arr) {
      hash[j] = 1;
    }

    for (int i = 1; i < hash.length; i++) {
      if (hash[i] == 0) {
        return i;
      }
    }

    return -1;
  }

  private static int missingNumberSum(int[] arr) {
    int sumN = arr.length * (arr.length + 1) / 2;
    int sumArr = 0;
    for (int i = 0; i < arr.length; i++) {
      sumArr += arr[i];
    }

//    System.out.println(sumN + " " + sumArr);

    return sumN - sumArr;
  }

  private static int missingNumberXor(int[] arr) {
    int xor1 = 0;
    int xor2 = 0;

    for (int i = 0; i < arr.length; i++) {
      xor1 = xor1 ^ (i + 1);
      xor2 = xor2 ^ arr[i];
    }

    return xor1 ^ xor2;
  }

}
