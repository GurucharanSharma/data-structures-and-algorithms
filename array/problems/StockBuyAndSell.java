package array.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {

  public static void main(String[] args) {
    int[] A = {100, 180, 260, 310, 40, 535, 695};
//    int[] A = {4, 2, 2, 2, 4};
//    int[] A = {822, 754, 1689, 305, 214, 782, 1463, 1432, 1382, 1734, 948, 231, 210, 1676, 877, 670, 1384, 725, 1370, 412, 724, 371, 928, 358, 533,
//        1031, 850, 1555, 1064, 845, 1692, 514, 630, 1333, 1640, 315, 1639, 1792, 1779, 1325, 1619, 1400, 378, 145, 913, 901, 1652, 530, 1259, 880,
//        303, 685, 1586};

    System.out.println(stockBuySell(A, A.length));
  }

  //Function to find the days of buying and selling stock for max profit.
  static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
    int start = 0;
    int end = 0;
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 1; i < n; i++) {
      if (A[i] <= A[i - 1]) {
        if (start != end) {
          result.add(new ArrayList<>(Arrays.asList(start, end)));
        }

        start = i;
      }

      end = i;
    }

    if (start != end) {
      result.add(new ArrayList<>(Arrays.asList(start, end)));
    }

    return result;
  }
}
