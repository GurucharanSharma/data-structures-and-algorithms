package mathematics.lectures;

public class CountDigits {

  public static int countDigits(int n) {
    if (n / 10 == 0) {
      return 1;
    }

    if (n < 0) {
      n = -n;
    }

    int count = 0;
    while (n > 0) {
      count++;
      n = n / 10;
    }

    return count;
  }

  public static int countDigits1(int n) {
    if (n / 10 == 0) {
      return 1;
    }

    return 1 + countDigits1(n / 10);
  }

  public static int countDigits2(int n) {
    if (n < 0) {
      n = -n;
    }

    return String.valueOf(n).length();
  }

  public static int countDigits3(int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      n = -n;
    }

    return 1 + (int) Math.floor(Math.log10(n));
  }

  public static int countDigits4(int n) {
    if (n == 0) {
      return 1;
    }

    return 1 + (int) Math.floor(Math.log10(Math.abs(n)));
  }
}