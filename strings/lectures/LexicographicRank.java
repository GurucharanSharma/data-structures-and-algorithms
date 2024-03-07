package strings.lectures;

public class LexicographicRank {

  public static void main(String[] args) {
    System.out.print(lexRank("STRING"));
  }

  private static int lexRank(String text) {
    int[] count = new int[256];
    int mul = factorial(text.length());

    for (int i = 0; i < text.length(); i++) {
      count[text.charAt(i)]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }

    int rank = 1;
    for (int i = 0; i < text.length(); i++) {
      mul = mul / (text.length() - i);
      rank += mul * count[text.charAt(i) - 1];

      for (int j = text.charAt(i); j < count.length; j++) {
        count[j]--;
      }
    }

    return rank;
  }

  private static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }
}
