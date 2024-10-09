package recursion.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class PossibleWords {

  private static final HashMap<Integer, String> digitLetterMap = new HashMap<>() {{
    put(1, "1");
    put(2, "ABC");
    put(3, "DEF");
    put(4, "GHI");
    put(5, "JKL");
    put(6, "MNO");
    put(7, "PQRS");
    put(8, "TUV");
    put(9, "WXYZ");
  }};

  public static void main(String[] args) {
//    int[] arr = {2, 3, 4};
    int[] arr = {3, 4, 5};

    System.out.println(possibleWords(arr, arr.length));
  }

  //Function to find list of all words possible by pressing given numbers.
  public static ArrayList<String> possibleWords(int[] a, int N) {
    ArrayList<String> list = new ArrayList<>();
    listWords(a, N, 0, "", list);
    return list;
  }

  private static void listWords(int[] a, int n, int index, String curr, ArrayList<String> list) {
    if (index >= n) {
      list.add(curr);
      return;
    }

    for (int i = 0; i < digitLetterMap.get(a[index]).length(); i++) {
      String word = curr.concat(String.valueOf(digitLetterMap.get(a[index]).charAt(i)));
      listWords(a, n, index + 1, word, list);
    }
  }
}
