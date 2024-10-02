package mathematics.problems;

import java.util.Arrays;

public class ReverseBits {

  public static void main(String[] args) {
    long n = 153;

    System.out.println(reverseBits(n));
    System.out.println();
    System.out.println(reverseBits1(n));
    System.out.println();
    System.out.println(reverseBits2(n));
  }

  /**
   * Approach 1
   */
  public static long reverseBits(long n) {
    int[] binary = getBinary(n);
    System.out.println(Arrays.toString(binary));

    long reverse = getReverse(binary);
    System.out.println(Arrays.toString(getBinary(reverse)));

    return reverse;
  }

  private static int[] getBinary(long n) {
    int[] binary = new int[32];

    int count = 0;
    while (n > 0) {
      if (n % 2 != 0) {
        binary[count] = 1;
      }

      n = n / 2;
      count++;
    }

    return binary;
  }

  private static long getReverse(int[] binary) {
    long reverse = 0;
    for (int i = 0; i < binary.length; i++) {
      if (binary[i] == 1) {
        reverse += (long) Math.pow(2, 32 - i - 1);
      }
    }

    return reverse;
  }

  /**
   * Approach 2
   */
  public static long reverseBits1(long n) {
    int[] bits = new int[32];

    // Preparing the bits array.
    for (int i = 0; i < 32; i++) {

      // If the ith bit is set.
      if ((n & (long) 1 << i) > 0) {
        bits[i] = 1;
      }
    }

    for (int i = 0; i < 16; i++) {

      // Swapping the left and rightmost bits.
      swap(i, 31 - i, bits);
    }

    // 'ans' will store the value for the reversed bits representation.
    long ans = 0;

    for (int i = 0; i < 32; i++) {

      // If the i'th bit is set.
      if (bits[i] == 1) {
        ans += (long) 1 << i;
      }
    }
    return ans;

  }

  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * Approach 3
   */
  public static long reverseBits2(long n) {

    // 'ans' will store the value of reversed bits representation.
    long ans = 0;

    for (int i = 0; i < 32; i++) {
      // 'k' is the i'th bit.
      int k = (int) (n & (1 << i));

      // If the i'th bit from right is Set.
      if (k > 0) {

        // Increase the value of ans by value of i'th bit from left.
        ans += (long) 1 << (31 - i);
      }
    }
    return ans;
  }
}
