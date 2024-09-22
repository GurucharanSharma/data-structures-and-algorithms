package sorting.problems;

import java.util.Arrays;

/**
 * Given two positive integer arrays arr and brr, find the number of pairs such that x<sup>y</sup> > y<sup>x</sup> (raised to power of) where x is an
 * element from arr and y is an element from brr.
 */
public class NumberOfPairs {

  public static void main(String[] args) {
    int[] X = {2, 1, 6};
    int[] Y = {1, 5};

    System.out.println(countPairs(X, Y, X.length, Y.length));
  }

  // Function to count number of pairs such that x^y is greater than y^x.
  public static long countPairs(int[] x, int[] y, int M, int N) {
    // count frequencies of 0, 1, 2, 3, 4 in array y
    int[] freqY = new int[5];
    for (int i = 0; i < N; i++) {
      if (y[i] < 5) {
        freqY[y[i]]++;
      }
    }

    Arrays.sort(y);
    long res = 0;

    for (int i = 0; i < M; i++) {
      res += count(x[i], y, N, freqY);
    }

    return res;
  }

  static long count(int x, int[] Y, int N, int[] freqY) {
    // If x is 0, then there cannot be any value in Y
    // such that x^Y[i] > Y[i]^x
    if (x == 0) {
      return 0;
    }

    // If x is 1, then the number of pairs is equal to
    // number of zeroes in Y[]
    if (x == 1) {
      return freqY[0];
    }

    int result;

    // Find number of elements in Y[] with values greater than x getting upperbound of x with binary search
//    int idx = Arrays.binarySearch(Y, x);
    int idx = upperBound(Y, x);

    if (idx < 0) {
      idx = Math.abs(idx + 1);
    } else {
      // The method Arrays.binarySearch(Y, x) will give the first index of x in Y.
      // In case x is repeated in Y, we have to increment the idx till all the repeated
      // x's are counted.
      while (idx < N && Y[idx] == x) {
        idx++;
      }
    }

    // idx contains the index, in the array Y, below which all the elements are lesser than x.
    // So the count of elements which are greater than x will be N - idx.
    result = N - idx;

    // If we have reached here, then x must be greater
    // than 1, increase number of pairs for y=0 and y=1
    result = result + (freqY[0] + freqY[1]);

    // Decrease number of pairs for x=2 and (y=4 or y=3)
    if (x == 2) {
      result = result - (freqY[3] + freqY[4]);
    }

    // Increase number of pairs for x=3 and y=2
    if (x == 3) {
      result = result + freqY[2];
    }

    return result;
  }

  // Helper function to find the first index in brr[] where brr[idx] > x.
  static int upperBound(int[] brr, int x) {
    int low = 0, high = brr.length;
    while (low < high) {
      int mid = (low + high) / 2;
      if (brr[mid] > x) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
