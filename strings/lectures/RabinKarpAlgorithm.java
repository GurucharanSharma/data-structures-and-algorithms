package strings.lectures;

public class RabinKarpAlgorithm {

  public static void main(String[] args) {
    search("geeks for geeks", "for");
    search("hello world!", "ello");
  }

  /**
   * Improved Hash: hT(abc) = a * d<sup>2</sup> + b * d<sup>1</sup> + c * d<sup>0</sup> <br> Rolling Hash: hT<sub>i + 1</sub> = (d * (hT<sub>i</sub> -
   * txt[i] * d<sup>m - 1</sup>)) + txt[i + m] <br> - here, m = length of the pattern
   */
  private static void search(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    int d = 256;
    int q = 101; // Any large prime number

    // Calculating d ^ (m - 1)
    int h = 1;
    for (int i = 0; i < m - 1; i++) {
      h = (h * d) % q;
    }

    // Calculating hash(text) and hash(pattern)
    long hT = 0, hP = 0;
    for (int i = 0; i < m; i++) {
      hT = (hT * d + text.charAt(i)) % q;
      hP = (hP * d + pattern.charAt(i)) % q;
    }

    for (int i = 0; i <= n - m; i++) {
      if (hT == hP) {
        boolean match = true;
        for (int j = 0; j < m; j++) {
          if (text.charAt(i + j) != pattern.charAt(j)) {
            match = false;
            break;
          }
        }

        if (match) {
          System.out.println(i);
        }
      }

      if (i < n - m) {
        hT = ((d * (hT - (long) text.charAt(i) * h)) + text.charAt(i + m)) % q;
        if (hT < 0) {
          hT = hT + q;
        }
      }
    }
  }
}
