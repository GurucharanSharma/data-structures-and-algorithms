package array.problems;

import java.util.Arrays;

public class FractionTrouble {

  public static void main(String[] args) {

//    System.out.println(Arrays.toString(LargestFraction(1, 8)));
    System.out.println(Arrays.toString(LargestFraction(2, 53)));
  }

  public static int[] LargestFraction(int n, int d) {
    int num = 0;
    int denom = 1;

    for (int q = 10000; q > 1; q--) {
      int p = (n * q - 1) / d;

      if (gcd(p, q) == 1 && (p / (double) q > num / (double) denom)) {
        num = p;
        denom = q;
      }
    }

    return new int[]{num, denom};
  }

  static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }

    return gcd(b % a, a);
  }
}
